import Pessoas.Candidato;
import Pessoas.Cargos.Presidente;
import Pessoas.Eleitor;
import Pessoas.Partido;

public class Main {
    public static void main(String[] arg) {


        Eleicao eleicao2024 = new Eleicao(false);


        // eleitores
        eleicao2024.cadastrarEleitor(new Eleitor("joao manuel", "009", 19, "0477"));
        eleicao2024.cadastrarEleitor(new Eleitor("bento kaue", "008", 19, "1234"));
        eleicao2024.cadastrarEleitor(new Eleitor("ananias carlos", "007", 54, "2783"));
        eleicao2024.cadastrarEleitor(new Eleitor("michel", "006", 19, "6421"));
        eleicao2024.cadastrarEleitor(new Eleitor("sidney", "005", 23, "5321"));


        // partidos
        Partido ligaDaJustica = new Partido("Liga da Justiça", "54");
        Partido konoha = new Partido("Konoha", "45");



        // candidatos
        Candidato batman = new Presidente("Batman", "999", 54, "24", ligaDaJustica, false);
        eleicao2024.cadastrarCandidato(batman);

        Candidato naruto = new Presidente("Naruto", "777", 45, "55", konoha, false);
        eleicao2024.cadastrarCandidato(naruto);

        // votar
        eleicao2024.registrarVoto("0477");
        eleicao2024.registrarVoto("1234");
        eleicao2024.registrarVoto("2783");
        eleicao2024.registrarVoto("5321");
        eleicao2024.registrarVoto("6421");


        eleicao2024.getVotos();
    }
}
