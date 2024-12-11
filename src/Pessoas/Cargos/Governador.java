package Pessoas.Cargos;

import Pessoas.Candidato;

public class Governador extends Candidato {
    public Governador(String numero, String partido, int qntVotos, boolean eleicaoProporcional) {
        super(numero, partido, qntVotos, numero, partido);
    }
}
