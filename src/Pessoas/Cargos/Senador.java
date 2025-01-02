package Pessoas.Cargos;

import Pessoas.Candidato;
import Pessoas.Partido;

public class Senador extends Candidato {
    public Senador(String nome, String cpf, int idade, String numero, Partido partido, boolean eleicaoProporcional) {
        super(nome, cpf, idade, numero, partido, eleicaoProporcional);
    }
}
