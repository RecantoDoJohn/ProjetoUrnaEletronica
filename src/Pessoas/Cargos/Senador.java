package Pessoas.Cargos;

import Pessoas.Candidato;

public class Senador extends Candidato {
    public Senador(String nome, String cpf, int idade, String numero, String partido, boolean eleicaoProporcional) {
        super(nome, cpf, idade, numero, partido, eleicaoProporcional);
    }
}
