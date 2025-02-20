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
    private ArrayList<ArrayList> listaCargoProporcional;

    public Partido(String nomePartido, String numeroPartido) {
        this.nomePartido = nomePartido;
        this.numeroPartido = numeroPartido;

        this.cadeirasCargo = new int[2];

        this.listaDeputadoEstadual = new ArrayList<>();
        this.listaDeputadoFederal = new ArrayList<>();
        this.listaSenandor = new ArrayList<>();
        this.listaGovernador = new ArrayList<>();
        this.listaPresidente = new ArrayList<>();

        this.listaCargoProporcional = new ArrayList<>();
        this.listaCargoProporcional.add(listaDeputadoFederal);
        this.listaCargoProporcional.add(listaDeputadoEstadual);
    }

    public String getNome() {
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

    public void addCadeiras(int ordemCargo, int quantCadeiras) {
        this.cadeirasCargo[ordemCargo] += quantCadeiras;
    }

    public int getCadeirasCargo(int ordemCargo) {
        return cadeirasCargo[ordemCargo];
    }

    public void addDeputadoFederal(DeputadoFederal deputadoFederal) {
        this.listaDeputadoFederal.add(deputadoFederal);
    }

    public void addDeputadoEstadual(DeputadoEstadual deputadoEstadual) {
        this.listaDeputadoEstadual.add(deputadoEstadual);
    }

    public int mediaVotosProporcionais(int indexCargo) {
        return listaVoto[indexCargo] / (cadeirasCargo[indexCargo] + 1);
    }


    // por cargo separado
    public ArrayList<Candidato> elegerProporcional(int cargoIndex, int quoEleitoral) {
        ArrayList<Candidato> vencedores = new ArrayList<>();

        ArrayList<Candidato> cargo = (ArrayList<Candidato>) this.listaCargoProporcional.get(cargoIndex);

        ArrayList<Candidato> cargoOrdenado = cargo.stream()
                .sorted(Comparator.comparingInt(Candidato::getQntVotos).reversed())
                .collect(Collectors.toCollection(ArrayList::new));

        for (int numeroCadeira = 0; numeroCadeira < cadeirasCargo[cargoIndex]; numeroCadeira++) {
            if (cargoOrdenado.size() != numeroCadeira) {
                Candidato candidatoEleito = cargoOrdenado.get(numeroCadeira);
                if (candidatoEleito.calcularQuoIndividual(quoEleitoral)) {
                    vencedores.add(candidatoEleito);
                } else {
                    this.cadeirasCargo[cargoIndex]--;
                }
            }
        }


        return vencedores;

    }
}
