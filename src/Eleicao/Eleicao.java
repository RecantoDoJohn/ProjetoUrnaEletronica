package Eleicao;

import Pessoas.Candidato;
import Pessoas.Cargos.*;
import Pessoas.Eleitor;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Eleicao {
    private HashMap<String, Eleitor> eleitores;
    private HashMap<String, Candidato> candidatos;
    private Boolean aberto;
    private LocalTime horarioDeAbertura;
    private static final LocalTime horarioDeFechamento = LocalTime.of(20,0);
    private int votoNulo;
    private int votoBranco;
    private Eleitor eleitorDoMomento;
    private String[] nomesCargos;



    // ver se isso é jogo ou brisa
    private HashMap<String, DeputadoEstadual> deputadoEstadualHashMap;
    private HashMap<String, DeputadoFederal> deputadoFederalHashMap;
    private HashMap<String, Governador> governadorHashMap;
    private HashMap<String, Presidente> presidenteHashMap;
    private HashMap<String, Senador> senadorHashMap;

    private ArrayList< HashMap<String, ?> > cargosList;


    public Eleicao() {
        this.aberto = false;
        this.candidatos = new HashMap<>();
        this.eleitores = new HashMap<>();

        this.deputadoEstadualHashMap = new HashMap<>();
        this.deputadoFederalHashMap = new HashMap<>();
        this.governadorHashMap = new HashMap<>();
        this.presidenteHashMap = new HashMap<>();
        this.senadorHashMap = new HashMap<>();

        this.cargosList = new ArrayList<>();
        Collections.addAll(cargosList,
                deputadoFederalHashMap,
                deputadoEstadualHashMap,
                senadorHashMap,
                governadorHashMap,
                presidenteHashMap
        );

        this.nomesCargos = new String[]{
                "DEPUTADO FEDERAI",
                "DEPUTADO ESTADUAl",
                "SENADOR",
                "GOVERNADOR",
                "PRESIDENTe"
        };

        this.votoNulo = 0;
        this.votoBranco = 0;


        /* teoricamente essa é a ordem:
        0 Deputado Federal: é o primeiro cargo a ser votado, que tem 4 dígitos, representando o número do candidato;
        1 Deputado Estadual: vem na sequência, com 5 dígitos;
        2 Senador e seus dois suplentes: o eleitor deve teclar 3 dígitos;
        3 Governador e Vice-Governador: 2 dígitos;
        4 Presidente e Vice-Presidente da República: também 2 dígitos.
        */
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
        definirHorarioDeAbertura();
        aberto = true;
    }

    public Boolean getAberto() {
        return aberto;
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
        votoBranco++;
        eleitorDoMomento.avancarVoto();
    }

    private void addVotoNulo() {
        votoNulo++;
    }

    public void gerarRelatorio() {

        System.out.println("Horario de abertura: " + horarioDeAbertura);
        System.out.println("Horario de Fechamento: " + LocalTime.now());

        int index = 0;

        for (HashMap<String, ?> cargo : cargosList) {
            System.out.printf("\n%s: \n", nomesCargos[index++]);
            for (Object candidatoCru : cargo.values() ) {
                Candidato candidato = (Candidato) candidatoCru;
                System.out.printf("%s: %d\n", candidato.getNome(),candidato.getQntVotos());
            }
        }
    }

    public void verificarHorario() {
        LocalTime horaAgora = LocalTime.now();

        if (horaAgora.isBefore(horarioDeAbertura) || horaAgora.isAfter(horarioDeFechamento)) {
            finalizarEleicao();
        }

    }

    public void definirHorarioDeAbertura() {
        if (horarioDeAbertura == null) {
            this.horarioDeAbertura = LocalTime.now();
            verificarHorario();
        }
    }

    public Candidato verificarCandidato(String numeroCandidato) {
        Candidato candidato = this.getCandidatos().get(numeroCandidato);
        return candidato;
    }

    public Eleitor verificarEleitor(String tituloEleitor) {
        Eleitor eleitor = this.getEleitores().get(tituloEleitor);
        return eleitor;
    }

    public Boolean selecionarEleitor(String tituloEleitor) {
        Eleitor eleitorTst = eleitores.get(tituloEleitor);

        if (eleitorTst == null || eleitorTst.getOrdemVotacao() == 5) {
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
}

