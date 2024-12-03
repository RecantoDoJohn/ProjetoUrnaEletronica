import Pessoas.Pessoa;

public class Main {
    public static void main(String[] arg) {

        Pessoa[] listaInicial = Eleicao.cadastrarEleitor(1);

        for (Pessoa eleitor : listaInicial) {
            System.out.printf("NOME: %s\n",eleitor.getNome());
            System.out.printf("cpf: %s\n",eleitor.getCpf());
            System.out.printf("idade: %d\n\n", eleitor.getIdade());
        }
    }
}
