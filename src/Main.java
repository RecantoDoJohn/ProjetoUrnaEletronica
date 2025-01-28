import Eleicao.Eleicao;
import Pessoas.Candidato;
import Pessoas.Cargos.*;
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
        Partido tchetcherere = new Partido("tchetcherere", "54");
        Partido sorrireBrincar = new Partido("Sorrir e Brincar", "45");



        // candidatos
        Presidente batman = new Presidente("Gustavo Lima", "999", 54, "77", tchetcherere, false, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img_1.png");
        eleicao2024.cadastrarPresidente(batman);

        Presidente naruto = new Presidente("Patati e patata", "777", 45, "54", sorrireBrincar, false, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img.png");
        eleicao2024.cadastrarPresidente(naruto);

        DeputadoEstadual chatgpt = new DeputadoEstadual("ChatGPT estadual", "12345", 3, "12345", tchetcherere, true,"oi");
        eleicao2024.cadastrarDeputadoEstatual(chatgpt);

        DeputadoFederal chatgptferderal = new DeputadoFederal("ChatGPT federal", "1234", 3, "1234", tchetcherere, true,"oi");
        eleicao2024.cadastrarDeputadoFederal(chatgptferderal);

        Senador chatgptsenador = new Senador("ChatGPT sennadir", "1223", 3, "123", tchetcherere, true,"oi");
        eleicao2024.cadastrarSenador(chatgptsenador);

        Governador chatgptGoverbador = new Governador("ChatGPT governador", "1223", 3, "12", tchetcherere, true,"oi");
        eleicao2024.cadastrarGovernador(chatgptGoverbador);

//        eleicao2024.registrarVoto("1234", "0477");
//        eleicao2024.registrarVoto("12345", "0477");
//        eleicao2024.registrarVoto("123", "0477");
//        eleicao2024.registrarVoto("12", "0477");
//        eleicao2024.registrarVoto("77", "0477");
//        eleicao2024.registrarVoto("77", "0477");

        eleicao2024.gerarRelatorio();


        InterfaceUrna urna = new InterfaceUrna(eleicao2024);
        urna.visivel(true);
    }
}
