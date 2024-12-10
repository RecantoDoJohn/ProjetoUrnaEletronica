import Pessoas.Eleitor;
import Pessoas.Pessoa;

public class Main {
    public static void main(String[] arg) {


        Eleicao eleicao2024 = new Eleicao();

        eleicao2024.cadastrarEleitor(2);

        for (Pessoa eleitor : eleicao2024.getEleitores()) {
            System.out.printf("NOME: %s\n",eleitor.getNome());
            System.out.printf("cpf: %s\n",eleitor.getCpf());
            System.out.printf("idade: %d\n\n", eleitor.getIdade());
        }
    }
}
