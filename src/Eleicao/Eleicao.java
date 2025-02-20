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

    private HashMap<String, Partido> partidoHashMap;

    private HashMap<String, DeputadoEstadual> deputadoEstadualHashMap;
    private HashMap<String, DeputadoFederal> deputadoFederalHashMap;
    private HashMap<String, Governador> governadorHashMap;
    private HashMap<String, Presidente> presidenteHashMap;
    private HashMap<String, Senador> senadorHashMap;

    private ArrayList< HashMap<String, ?> > cargosList;
    private ArrayList< HashMap<String, ?> > cargosProporcionnal;
    private ArrayList< HashMap<String, ?> > cargosMajoritario;


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
                "DEPUTADO ESTADUAL",
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

    public Eleitor getEleitorDoMomento() {
        return eleitorDoMomento;
    }

    public String getNomeCargo(int ordemCargo) {
        return this.nomesCargos[ordemCargo];
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

    public void finalizarEleicao() {
        aberto = false;
        this.gerarRelatorio();
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

            int indexCargo = 0;

            for (HashMap<String, ?> cargo : cargosList) {
                writer.printf("\n%s: \n", nomesCargos[indexCargo]);
                for (Object candidatoCru : cargo.values() ) {
                    Candidato candidato = (Candidato) candidatoCru;
                    writer.printf("%s - %s: %d\n", candidato.getNome(), candidato.getPartido().getNome(), candidato.getQntVotos());
                }
                writer.printf("\nVotos nulo: %d\n", listaVotoNulo[indexCargo]);
                writer.printf("Votos brancos: %d\n\n", listaVotoBranco[indexCargo++]);
            }

            ArrayList<Candidato> vencedores = this.calculoEleicaoMajoritaria();
            ArrayList<Candidato> vencedoresPro = this.calculoEleicaoProporcional();
            vencedores.addAll(vencedoresPro);

            if (vencedores != null) {
                vencedores.sort(Comparator.comparing(Candidato::getOrdem));

                writer.println("Vencedores: \n");
                for (int i = 0; i < vencedores.size(); i++) {
                    writer.println(nomesCargos[vencedores.get(i).getOrdem()] + "\n" + vencedores.get(i).getNome() + vencedores.get(i).getPartido().getNome() + "\n");
                }

                System.out.println("Relatorio gerado com sucesso :D");
            }


        } catch (Exception e) {
            System.err.println("Erro ao criar o arquivo: " + e);
        }

    }

    public void registrarVoto(String numeroCandidato) {
        Candidato candidato = this.getCandidatos().get(numeroCandidato);

        if (candidato == null || eleitorDoMomento.getOrdemVotacao() != candidato.getOrdem()) {
            this.addVotoNulo();
        } else {
            candidato.receberVoto();
        }

        if (this.eleitorDoMomento.getOrdemVotacao() == 4) {
            verificarEleitoresRestantes();
            verificarHorario();
        }
        eleitorDoMomento.avancarVoto();
    }

    public void addVotoBranco() {
        this.listaVotoBranco[this.eleitorDoMomento.getOrdemVotacao()]++;

        if(this.eleitorDoMomento.getOrdemVotacao() == 4) {
            verificarEleitoresRestantes();
            verificarHorario();
        }
            eleitorDoMomento.avancarVoto();

    }

    private void addVotoNulo() {
        listaVotoNulo[eleitorDoMomento.getOrdemVotacao()]++;
    }

    public void verificarHorario() {
        LocalTime horaAgora = LocalTime.now();

        if (horaAgora.isBefore(horarioDeAbertura) || horaAgora.isAfter(horarioDeFechamento)) {
            finalizarEleicao();
        }

    }

    public void verificarEleitoresRestantes() {
        boolean todosVotaram = eleitores.values().stream()
                .allMatch(eleitor -> eleitor.getOrdemVotacao() == 4);
        if (todosVotaram) {
            finalizarEleicao();
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

    public void votosMagicos(int quantEleitores) {

        if (this.aberto) {
            Eleitor oz = new EleitorMagico("Oz", "000", 99, "abcd");
            this.cadastrarEleitor(oz);
            this.selecionarEleitor(oz.getTituloEleitoral());

            SecureRandom geradorNumeroAleatorio = new SecureRandom();

            for (int i= 0; i < quantEleitores; i++) {
                for (HashMap<String, ?> cargo : cargosList) {

                    int numeroAleatorio = geradorNumeroAleatorio.nextInt(cargo.size() + 1);

                    String[] listaNumeros = cargo.keySet().toArray(new String[0]);

                    if (numeroAleatorio < cargo.size()) {
                        this.registrarVoto(listaNumeros[numeroAleatorio]);
                    }
                    else {
                        if (geradorNumeroAleatorio.nextInt(2) == 0) {
                            addVotoBranco();
                        }
                        else {
                            this.registrarVoto("00");
                        }
                    }
                }

            }

            eleitores.remove(oz.getTituloEleitoral());
        }

    }

    public ArrayList<Candidato> calculoEleicaoMajoritaria() {
        ArrayList<Candidato> vencedores = new ArrayList<>();
        for (HashMap<String, ?> cargo : cargosMajoritario) {
            HashMap<String, Candidato> novoCargo = (HashMap<String, Candidato>) cargo;

            ArrayList<Candidato> listaCargoOrdenada = novoCargo.values().stream()
                    .sorted(Comparator.comparingInt(Candidato::getQntVotos).reversed())
                    .collect(Collectors.toCollection(ArrayList::new));

            Candidato vencedor = listaCargoOrdenada.getFirst();
            vencedores.add(vencedor);

        }

        return vencedores;
    }

    public ArrayList<Candidato> calculoEleicaoProporcional() {
        int[] quantCadeiras = { 5, 7};
        ArrayList<Candidato> vencedores = new ArrayList<>();


        int indexCargo = 0;
        for (HashMap<String, ?> cargo : cargosProporcionnal) {
            HashMap<String, Candidato> novoCargo = (HashMap<String, Candidato>) cargo;

            double votosValidosCargos = novoCargo.values().stream().mapToInt(Candidato::getQntVotos).sum();
            double quoEleitoral = votosValidosCargos / quantCadeiras[indexCargo];

            for (Partido partido : this.partidoHashMap.values()) {
                int quoPartidario = (int) (partido.getVotos(indexCargo) / quoEleitoral);

                partido.addCadeiras(indexCargo, quoPartidario);
                vencedores.addAll(partido.elegerProporcional(indexCargo, quoPartidario));
                quantCadeiras[indexCargo] -= partido.getCadeirasCargo(indexCargo);
            }


            // redistribuir
            while (quantCadeiras[indexCargo] != 0) {
                double maiorMedia = 0;
                Partido maiorPartido = null;

                for (Partido partido : this.partidoHashMap.values()) {
                    int mediaPartido = partido.mediaVotosProporcionais(indexCargo);

                    if (mediaPartido > maiorMedia) {
                        maiorMedia = mediaPartido;
                        maiorPartido = partido;
                    }
                }
                if (maiorPartido != null) {
                    maiorPartido.addCadeiras(indexCargo, 1);
                    int quoPartidario = (int) (maiorPartido.getVotos(indexCargo) / quoEleitoral);

                    for (Candidato vencedor: maiorPartido.elegerProporcional(indexCargo, quoPartidario)) {
                        if (!vencedores.contains(vencedor)) {
                            vencedores.add(vencedor);
                        }
                    }
                    quantCadeiras[indexCargo] -= 1;
                }

            }

            indexCargo++;
        }

        return vencedores;
    }
}

