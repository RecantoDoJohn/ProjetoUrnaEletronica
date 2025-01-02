package Pessoas.Cargos;

import Pessoas.Candidato;
import Pessoas.Partido;

public class Governador extends Candidato {
    public Governador(String nome, String cpf, int idade, String numero, Partido partido, boolean eleicaoProporcional) {
        super(nome, cpf, idade, numero, partido, eleicaoProporcional);
    }
}
