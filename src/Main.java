import Eleicao.Eleicao;
import Pessoas.Candidato;
import Pessoas.Cargos.Presidente;
import Pessoas.Eleitor;
import Pessoas.Partido;
import View.InterfaceUrna;

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
        Candidato batman = new Presidente("Gustavo Lima", "999", 54, "77", ligaDaJustica, false, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img_1.png");
        eleicao2024.cadastrarCandidato(batman);

        Candidato naruto = new Presidente("Patati e patata", "777", 45, "55", konoha, false, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img.png");
        eleicao2024.cadastrarCandidato(naruto);


        InterfaceUrna urna = new InterfaceUrna(eleicao2024);
        urna.visivel(true);
    }
}
