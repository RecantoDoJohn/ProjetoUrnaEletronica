import Pessoas.Candidato;
import Pessoas.Eleitor;

public class Main {
    public static void main(String[] arg) {


        Eleicao eleicao2024 = new Eleicao();

        eleicao2024.cadastrarEleitor(new Eleitor("joao manuel", "009", 19));
        eleicao2024.cadastrarEleitor(new Eleitor("bento kaue", "008", 19));
        eleicao2024.cadastrarEleitor(new Eleitor("ananias carlos", "007", 54));
        eleicao2024.cadastrarEleitor(new Eleitor("michel", "006", 19));
        eleicao2024.cadastrarEleitor(new Eleitor("sidney", "005", 23));

        eleicao2024.cadastrarCandidato(new Candidato("Batman", "999", 54, "24", "Liga da justica"));
        eleicao2024.cadastrarCandidato(new Candidato("Naruto", "777", 45, "55", "Konoha"));

        eleicao2024.registrarVoto("123");
        eleicao2024.registrarVoto("009");
        eleicao2024.registrarVoto("009");

    }
}
