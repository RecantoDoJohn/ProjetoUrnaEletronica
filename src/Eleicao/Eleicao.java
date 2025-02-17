package Eleicao;

import Pessoas.Candidato;
import Pessoas.Cargos.*;
import Pessoas.Eleitor;
import Pessoas.EleitorMagico;
import Pessoas.Partido;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;


public class Eleicao {
    private HashMap<String, Eleitor> eleitores;
    private HashMap<String, Candidato> candidatos;
    private Boolean aberto;
    private LocalTime horarioDeAbertura;
    private LocalTime horarioDeFechamento;
    private Eleitor eleitorDoMomento;
    private String[] nomesCargos;

    private int votoNuloDepuEstatual, votoNuloDepuFederal, votoNuloGovernador, votoNuloSenador, votoNuloPresidente;
    private int[] listaVotoNulo = {votoNuloDepuFederal, votoNuloDepuEstatual,  votoNuloGovernador, votoNuloSenador, votoNuloPresidente};

    private int votoBrancoDepuFederal, votoBrancoDepuEstatual, votoBracoGovernador, votoBrancoSenador, votoBrancoPresidente;
    private int[] listaVotoBranco = {votoBrancoDepuFederal, votoBrancoDepuEstatual, votoBracoGovernador, votoBrancoSenador, votoBrancoPresidente};

    // ver se isso é jogo ou brisa
    private HashMap<String, DeputadoEstadual> deputadoEstadualHashMap;
    private HashMap<String, DeputadoFederal> deputadoFederalHashMap;
    private HashMap<String, Governador> governadorHashMap;
    private HashMap<String, Presidente> presidenteHashMap;
    private HashMap<String, Senador> senadorHashMap;

    private ArrayList< HashMap<String, ?> > cargosList;
    private ArrayList< HashMap<String, ?> > cargosProporcionnal;
    private ArrayList< HashMap<String, ?> > cargosMajoritario;

    private HashMap<String, Partido> partidoHashMap;


    public Eleicao() {
        this.aberto = false;
        this.candidatos = new HashMap<>();
        this.eleitores = new HashMap<>();

        this.deputadoEstadualHashMap = new HashMap<>();
        this.deputadoFederalHashMap = new HashMap<>();
        this.governadorHashMap = new HashMap<>();
        this.presidenteHashMap = new HashMap<>();
        this.senadorHashMap = new HashMap<>();
        this.partidoHashMap = new HashMap<>();

        this.cargosList = new ArrayList<>();
        this.cargosProporcionnal = new ArrayList<>();
        this.cargosMajoritario = new ArrayList<>();

        Collections.addAll(cargosList,
                deputadoFederalHashMap,
                deputadoEstadualHashMap,
                senadorHashMap,
                governadorHashMap,
                presidenteHashMap
        );

        Collections.addAll(cargosProporcionnal,
                deputadoFederalHashMap,
                deputadoEstadualHashMap
        );

        Collections.addAll(cargosMajoritario,
                senadorHashMap,
                governadorHashMap,
                presidenteHashMap
        );

        this.nomesCargos = new String[]{
                "DEPUTADO FEDERAL",
                "DEPUTADO ESTADUAl",
                "SENADOR",
                "GOVERNADOR",
                "PRESIDENTE"
        };


        /* teoricamente essa é a ordem:
        0 Deputado Federal: é o primeiro cargo a ser votado, que tem 4 dígitos, representando o número do candidato;
        1 Deputado Estadual: vem na sequência, com 5 dígitos;
        2 Senador e seus dois suplentes: o eleitor deve teclar 3 dígitos;
        3 Governador e Vice-Governador: 2 dígitos;
        4 Presidente e Vice-Presidente da República: também 2 dígitos.
        */
    }

    public void cadastrarPartido(Partido partido) {
        this.partidoHashMap.put(partido.getNumeroPartido(), partido);
    }

    public void cadastrarEleitor(Eleitor novoEleitor) {
        this.eleitores.put(novoEleitor.getTituloEleitoral(), novoEleitor);
    }

    public void cadastrarPresidente(Presidente presidente) {
        this.candidatos.put(presidente.getNumero(), (Candidato) presidente);
        this.presidenteHashMap.put(presidente.getNumero(), presidente);
    }

    public void cadastrarGovernador(Governador governador) {
        this.candidatos.put(governador.getNumero(), (Candidato) governador);
        this.governadorHashMap.put(governador.getNumero(), governador);
    }

    public void cadastrarSenador(Senador senador) {
        this.candidatos.put(senador.getNumero(), (Candidato) senador);
        this.senadorHashMap.put(senador.getNumero(), senador);
    }

    public void cadastrarDeputadoEstatual(DeputadoEstadual deputadoEstadual) {
        this.candidatos.put(deputadoEstadual.getNumero(), (Candidato) deputadoEstadual);
        this.deputadoEstadualHashMap.put(deputadoEstadual.getNumero(), deputadoEstadual);
    }

    public void cadastrarDeputadoFederal(DeputadoFederal deputadoFederal) {
        this.candidatos.put(deputadoFederal.getNumero(), (Candidato) deputadoFederal);
        this.deputadoFederalHashMap.put(deputadoFederal.getNumero(), deputadoFederal);
    }



    public HashMap<String, Eleitor> getEleitores() {
        return eleitores;
    }

    public HashMap<String, Candidato> getCandidatos() {
        return candidatos;
    }

    public void finalizarEleicao() {
        aberto = false;
    }

    public void abrirEleicao() {
        candidatos.values().forEach(Candidato::zerarVotos);
        Arrays.fill(listaVotoBranco, 0);
        Arrays.fill(listaVotoNulo, 0);

        definirHorarioDeAbertura();
        aberto = true;
    }

    public Boolean getAberto() {
        return aberto;
    }


    public void gerarRelatorio() {

        try (PrintWriter writer = new PrintWriter(new FileWriter("Resultado.txt"))) {
            writer.println("Horario de abertura: " + horarioDeAbertura);
            writer.println("Horario de Fechamento: " + LocalTime.now());

            int index = 0;

            for (HashMap<String, ?> cargo : cargosList) {
                writer.printf("\n%s: \n", nomesCargos[index]);
                for (Object candidatoCru : cargo.values() ) {
                    Candidato candidato = (Candidato) candidatoCru;
                    writer.printf("%s: %d\n", candidato.getNome(),candidato.getQntVotos());
                }
                writer.printf("Votos nulo: %d\n", listaVotoNulo[index]);
                writer.printf("Votos brancos: %d\n", listaVotoBranco[index++]);
            }

            ArrayList<Candidato> vencedoresMajor = this.calculoEleicaoMajoritaria();
            for (Candidato vencedor : vencedoresMajor) {
                writer.println(nomesCargos[vencedor.getOrdem()] + "\n" + vencedor.getNome() + "\n");
            }




        } catch (Exception e) {
            System.err.println("Erro ao criar o arquivo");
        }


//        this.calculoEleicaoProporcional();
    }
    // fazer uma funcao que receba o numero do candidato e o titulo e add voto pra algum bagulho

    public void registrarVoto(String numeroCandidato) {
        Candidato candidato = this.getCandidatos().get(numeroCandidato);

        if (candidato == null || eleitorDoMomento.getOrdemVotacao() != candidato.getOrdem()) {
            this.addVotoNulo();
        } else {
            candidato.receberVoto();
        }
        eleitorDoMomento.avancarVoto();

    }

    public void addVotoBranco() {
        this.listaVotoBranco[this.eleitorDoMomento.getOrdemVotacao()]++;
        eleitorDoMomento.avancarVoto();
    }

    private void addVotoNulo() {
        listaVotoNulo[eleitorDoMomento.getOrdemVotacao()]++;
    }

    public void verificarHorario() {
        LocalTime horaAgora = LocalTime.now();
        System.out.println(this.horarioDeFechamento);

        if (horaAgora.isBefore(horarioDeAbertura) || horaAgora.isAfter(horarioDeFechamento)) {
            finalizarEleicao();
        }

    }

    public void definirHorarioDeAbertura() {
        if (horarioDeAbertura == null) {
            this.horarioDeAbertura = LocalTime.now();
        }
    }

    public void definirHorarioDeFechamento(int hora) {
        if (horarioDeFechamento == null) {
            this.horarioDeFechamento = LocalTime.of(hora, 0, 0, 0);
        }
    }

    public Boolean selecionarEleitor(String tituloEleitor) {
        Eleitor eleitorTst = eleitores.get(tituloEleitor);

        if (eleitorTst == null || eleitorTst.getOrdemVotacao() == 4) {
            return false;
        } else {
            this.eleitorDoMomento = eleitorTst;
            return true;
        }
    }

    public Eleitor getEleitorDoMomento() {
        return eleitorDoMomento;
    }

    public String getNomeCargo(int i) {
            return this.nomesCargos[i];
    }

    public void votosMagicos(int quantEleitores) {

//        if (this.aberto) {
            Eleitor oz = new EleitorMagico("Oz", "000", 99, "abcd");
            this.cadastrarEleitor(oz);
            this.selecionarEleitor(oz.getTituloEleitoral());

            SecureRandom geradorNumeroAleatorio = new SecureRandom();

            for (int i= 0; i <= quantEleitores - 1; i++) {
                for (HashMap<String, ?> cargo : cargosList) {

                    int num = geradorNumeroAleatorio.nextInt(cargo.size() + 1);

                    String[] listaNumeros = cargo.keySet().toArray(new String[0]);

                    if (num < cargo.size()) {
                        this.registrarVoto(listaNumeros[num]);
                    } else {
                        if (geradorNumeroAleatorio.nextInt(2) == 0) {
                            addVotoBranco();
                        }
                        else {
                            this.registrarVoto("00");
                        }
                    }
                }

            }

//        }


    }

    public ArrayList<Candidato> calculoEleicaoMajoritaria() {
        ArrayList<Candidato> vencedores = new ArrayList<>();
        for (HashMap<String, ?> cargo : cargosMajoritario) {
            HashMap<String, Candidato> novoCargo = (HashMap<String, Candidato>) cargo;

            ArrayList<Candidato> listaCargoOrdenada = novoCargo.values().stream()
                    .sorted(Comparator.comparingInt(Candidato::getQntVotos))
                    .collect(Collectors.toCollection(ArrayList::new));

            Candidato vencedor = listaCargoOrdenada.getFirst();
            vencedores.add(vencedor);

        }

        return vencedores;
    }

    public void calculoEleicaoProporcional() {
        int[] quantCadeiras = {3, 3};

        int indexCargo = 0;
        for (HashMap<String, ?> cargo : cargosProporcionnal) {
            HashMap<String, Candidato> novoCargo = (HashMap<String, Candidato>) cargo;
            double votosValidosCargos = novoCargo.values().stream().mapToInt(Candidato::getQntVotos).sum();
            double quoEleitoral = votosValidosCargos / quantCadeiras[indexCargo];

            for (Partido partido : this.partidoHashMap.values()) {
                double quantFloat = (partido.getVotos(indexCargo) / quoEleitoral);
                System.out.println("\n");
                System.out.println(quantFloat);
                partido.setCadeiras(indexCargo, (int) Math.round(quantFloat));
                System.out.printf("%s = %d", partido.getNomePartido(), partido.getCadeirasCargo(indexCargo));
            }
            System.out.println("\n");
            indexCargo++;
        }
        this.calculoEleicaoMajoritaria();

        for (Partido partido : partidoHashMap.values()) {
            partido.elegerProporcional();
        }
    }
}

