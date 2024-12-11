package Pessoas.Cargos;

import Pessoas.Candidato;

public class Presidente extends Candidato {

    public Presidente(String numero, String partido, int qntVotos, boolean eleicaoProporcional) {
        super(numero, partido, qntVotos, numero, partido);
    }
}
