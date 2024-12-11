package Pessoas.Cargos;

import Pessoas.Candidato;

public class DeputadoEstadual extends Candidato {
    public DeputadoEstadual(String numero, String partido, int qntVotos, boolean eleicaoProporcional) {
        super(numero, partido, qntVotos, numero, partido);
    }
}
