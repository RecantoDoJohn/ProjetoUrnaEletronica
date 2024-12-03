import Pessoas.Candidato;
import Pessoas.Eleitor;
import Pessoas.Pessoa;

import java.util.Scanner;

public class Eleicao {

    private Eleitor[] eleitors;
    private Candidato[] candidatos;
    private Boolean encerrado = false;

    public static Pessoa[] cadastrarEleitor(int quantEleitor) {
        Scanner entrada = new Scanner(System.in);
        Eleitor[] listaEleitor = new Eleitor[quantEleitor];

        for (int i = 0; i != quantEleitor; i++){
            System.out.println("digite o nome-");
            String nome = entrada.nextLine();

            System.out.println("digite o cpf-");
            String cpf = entrada.nextLine();

            System.out.println("digite a idade-");
            int idade = entrada.nextInt();

            listaEleitor[i] = new Eleitor(nome, cpf, idade);
        }

        return listaEleitor;
    }

    public void finalizarEleicao() {
        encerrado = true;
    }
}

