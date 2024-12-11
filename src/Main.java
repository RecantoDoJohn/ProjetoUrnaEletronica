import Pessoas.Candidato;
import Pessoas.Eleitor;
import Pessoas.Pessoa;

public class Main {
    public static void main(String[] arg) {


        Eleicao eleicao2024 = new Eleicao();

        eleicao2024.cadastrarCandidato(2);

        for (Candidato eleitor : eleicao2024.getCandidatos()) {
            System.out.printf("NOME: %s\n",eleitor.getNome());
            System.out.printf("cpf: %s\n",eleitor.getCpf());
            System.out.printf("idade: %d\n", eleitor.getIdade());
            System.out.printf("Partido: %s\n", eleitor.getPartido());
            System.out.printf("Numero: %s\n\n", eleitor.getNumero());
        }
    }
}
