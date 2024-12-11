import Pessoas.Candidato;
import Pessoas.Eleitor;
import Pessoas.Pessoa;

import java.util.Scanner;

public class Eleicao {

    private Eleitor[] eleitores;
    private Candidato[] candidatos;
    private Boolean encerrado = false;


    // colocar aqui como void no diagrama
    public void cadastrarEleitor(int quantEleitor) {
        Scanner entrada = new Scanner(System.in);
        this.eleitores = new Eleitor[quantEleitor];

        for (int i = 0; i != quantEleitor; i++){
            System.out.println("digite o nome:");
            String nome = entrada.nextLine();

            System.out.println("digite o cpf:");
            String cpf = entrada.nextLine();

            System.out.println("digite a idade:");
            int idade = entrada.nextInt();
            entrada.nextLine();

            // tratamento (pode fazer melhor se achar ruim)
            if ( nome.isEmpty() || cpf.isEmpty() ) {
                i--;
            } else {
                this.eleitores[i] = new Eleitor(nome, cpf, idade);
            }


        }

    }


    public void cadastrarCandidato(int quantCandidatos) {
        Scanner entrada = new Scanner(System.in);
        this.candidatos = new Candidato[quantCandidatos];

        for (int i = 0; i != quantCandidatos; i++){
            System.out.println("digite o nome:");
            String nome = entrada.nextLine();

            System.out.println("digite o cpf:");
            String cpf = entrada.nextLine();

            System.out.println("digite a idade:");
            int idade = entrada.nextInt();
            entrada.nextLine();

            System.out.println("digite o numero:");
            String numero = entrada.nextLine();

            System.out.println("digite o partido:");
            String partido = entrada.nextLine();

            // tratamento (pode fazer melhor se achar ruim)
            if ( nome.isEmpty() || cpf.isEmpty() ) {
                i--;
            } else {
                this.candidatos[i] = new Candidato(nome, cpf, idade, numero, partido);
            }


        }

    }

    // falta colocar no diagrama
    public Eleitor[] getEleitores() {
        return eleitores;
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public void finalizarEleicao() {
        encerrado = true;
    }

    // cpf é um place holder pro titulo eleitoral
    public void registrarVoto(String cpf) {
        for (int i = 0; i < eleitores.length; i++) {
            if (eleitores[i].getCpf().equals(cpf)) {
                System.out.println("valido");
                break;
            }
        }
    }
}

