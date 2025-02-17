package Pessoas;

import Pessoas.Cargos.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

//
public class Partido {
    private String nomePartido;
    private String numeroPartido;
    private int votoDepuEstatual, votoDepuFederal, votoGovernador, votoSenador, votoPresidente;
    private int[] listaVoto = {votoDepuEstatual, votoDepuFederal, votoGovernador, votoSenador, votoPresidente};
    private int[] cadeirasCargo;


    private ArrayList<DeputadoFederal> listaDeputadoFederal;
    private ArrayList<DeputadoEstadual> listaDeputadoEstadual;
    private ArrayList<Senador> listaSenandor;
    private ArrayList<Governador> listaGovernador;
    private ArrayList<Presidente> listaPresidente;

    public Partido(String nomePartido, String numeroPartido) {
        this.nomePartido = nomePartido;
        this.numeroPartido = numeroPartido;

        this.cadeirasCargo = new int[2];

        this.listaDeputadoEstadual = new ArrayList<>();
        this.listaDeputadoFederal = new ArrayList<>();
        this.listaSenandor = new ArrayList<>();
        this.listaGovernador = new ArrayList<>();
        this.listaPresidente = new ArrayList<>();
    }

    public String getNome() {
        return nomePartido;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public void receberVoto(int ordemCargo) {
        this.listaVoto[ordemCargo]++;
    }
    public String getNumeroPartido() {
        return this.numeroPartido;
    }

    public int getVotos(int ordemCargo) {
        return this.listaVoto[ordemCargo];
    }

    public void setCadeiras(int i, int quantCadeiras) {
        this.cadeirasCargo[i] = quantCadeiras;
    }

    public int getCadeirasCargo(int i) {
        return cadeirasCargo[i];
    }

    public void addDeputadoFederal(DeputadoFederal deputadoFederal) {
        this.listaDeputadoFederal.add(deputadoFederal);
    }

    public void addDeputadoEstadual(DeputadoEstadual deputadoEstadual) {
        this.listaDeputadoEstadual.add(deputadoEstadual);
    }


    public void elegerProporcional() {
        ArrayList<DeputadoFederal> depuFederalOrdenada = this.listaDeputadoFederal.stream()
                .sorted(Comparator.comparingInt(DeputadoFederal::getQntVotos))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<DeputadoEstadual> depuEstadualOrdenada = this.listaDeputadoEstadual.stream()
                .sorted(Comparator.comparingInt(DeputadoEstadual::getQntVotos))
                .collect(Collectors.toCollection(ArrayList::new));



//        for (int i = 0 ; i < 2; i++) {
            for (int y = 0; y < cadeirasCargo[0]; y++) {

                if (depuFederalOrdenada.size() != y) {
                    Candidato candidatoEleito = depuFederalOrdenada.get(y); // temos os ganhadores :)
                    System.out.println(candidatoEleito.getNome() + "\n");
                }
            }

        for (int y = 0; y < cadeirasCargo[0]; y++) {

            if (depuFederalOrdenada.size() != y) {
                Candidato candidatoEleito = depuEstadualOrdenada.get(y); // temos os ganhadores :)
                System.out.println(candidatoEleito.getNome() + "\n");
            }
        }
//        }

    }
}
