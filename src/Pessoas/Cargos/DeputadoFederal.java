package Pessoas.Cargos;

import Pessoas.Candidato;
import Pessoas.Partido;

public class DeputadoFederal extends Candidato {
    public DeputadoFederal(String nome, String cpf, int idade, String numero, Partido partido, String localImagem) {
        super(nome, cpf, idade, numero, partido, localImagem, 0);
    }
}
