import Eleicao.Eleicao;
import Pessoas.Cargos.*;
import Pessoas.Eleitor;
import Pessoas.Partido;
import View.MediadorInterface;

public class Main {
    public static void main(String[] arg) {
        Eleicao eleicao2024 = new Eleicao();


        // eleitores
        eleicao2024.cadastrarEleitor(new Eleitor("joao manuel", "009", 19, "0477"));
        eleicao2024.cadastrarEleitor(new Eleitor("bento kaue", "008", 19, "1234"));
        eleicao2024.cadastrarEleitor(new Eleitor("ananias carlos", "007", 54, "2783"));
        eleicao2024.cadastrarEleitor(new Eleitor("michel", "006", 19, "6421"));
        eleicao2024.cadastrarEleitor(new Eleitor("sidney", "005", 23, "5321"));
        eleicao2024.cadastrarEleitor(new Eleitor("hitallo", "002", 23, "0066"));


        // partidos
        Partido tchetcherere = new Partido("tchetcherere - tche", "77");
        eleicao2024.cadastrarPartido(tchetcherere);

        Partido capelao = new Partido("Capelão da Mata - CM", "13");
        eleicao2024.cadastrarPartido(capelao);

        Partido temaky = new Partido("Temakyy - TK", "22");
        eleicao2024.cadastrarPartido(temaky);


        // deputado federal
        DeputadoFederal paulo = new DeputadoFederal("Paulo Vitor", "123.456.789-99", 19, "1234", capelao,"C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\paulo.jpg");
        eleicao2024.cadastrarDeputadoFederal(paulo);

        DeputadoFederal galinha = new DeputadoFederal("Paulo das galinha", "123.456.789-99", 19, "1244", capelao,"C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\paulo.jpg");
        eleicao2024.cadastrarDeputadoFederal(galinha);

        DeputadoFederal lucas = new DeputadoFederal("José Lucas", "123.456.789-99", 22, "4321", temaky, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\lucas.jpg");
        eleicao2024.cadastrarDeputadoFederal(lucas);

        DeputadoFederal antoiDoMi = new DeputadoFederal("Antoi do mi", "123.456.789-99", 22, "4322", temaky, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\lucas.jpg");
        eleicao2024.cadastrarDeputadoFederal(antoiDoMi);

        DeputadoFederal candidato1 = new DeputadoFederal("João Silva", "123.456.789-00", 45, "7710", tchetcherere, "");
        eleicao2024.cadastrarDeputadoFederal(candidato1);

        DeputadoFederal candidatoDFederal1 = new DeputadoFederal("zezao", "123.456.789-00", 45, "7720", tchetcherere, "");
        eleicao2024.cadastrarDeputadoFederal(candidatoDFederal1);

        DeputadoFederal andre = new DeputadoFederal("André Souza", "987.654.321-88", 45, "1345", capelao, "");
        DeputadoFederal camila = new DeputadoFederal("Camila Ribeiro", "741.852.963-77", 38, "2256", temaky, "");
        DeputadoFederal fernando = new DeputadoFederal("Fernando Lima", "369.147.258-66", 50, "7789", tchetcherere, "");
        DeputadoFederal isabela = new DeputadoFederal("Isabela Martins", "159.753.486-55", 42, "1378", capelao, "");
        DeputadoFederal ricardo = new DeputadoFederal("Ricardo Almeida", "258.369.147-44", 36, "2212", temaky, "");
        DeputadoFederal juliana = new DeputadoFederal("Juliana Costa", "753.159.357-33", 47, "7745", tchetcherere, "");

        eleicao2024.cadastrarDeputadoFederal(andre);
        eleicao2024.cadastrarDeputadoFederal(camila);
        eleicao2024.cadastrarDeputadoFederal(fernando);
        eleicao2024.cadastrarDeputadoFederal(isabela);
        eleicao2024.cadastrarDeputadoFederal(ricardo);
        eleicao2024.cadastrarDeputadoFederal(juliana);




        // deputado estadual
        DeputadoEstadual davi= new DeputadoEstadual("Davi", "123.456.789-99", 83, "12345", capelao, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\davi.jpg");
        eleicao2024.cadastrarDeputadoEstatual(davi);

        DeputadoEstadual manuel = new DeputadoEstadual("João Manuel", "123.456.789-99", 20, "54321", temaky, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\jao.png");
        eleicao2024.cadastrarDeputadoEstatual(manuel);

        DeputadoEstadual candidato2 = new DeputadoEstadual("Maria Souza", "987.654.321-00", 39, "77110", tchetcherere, "");
        eleicao2024.cadastrarDeputadoEstatual(candidato2);

        DeputadoEstadual candidatoDEstadual = new DeputadoEstadual("Ze do porco", "987.654.321-00", 39, "77220", tchetcherere, "");
        eleicao2024.cadastrarDeputadoEstatual(candidatoDEstadual);

        DeputadoEstadual candidatoi = new DeputadoEstadual("João da Serra", "123.456.789-01", 42, "77111", tchetcherere, "");
        DeputadoEstadual candidatoii = new DeputadoEstadual("Maria do Carmo", "987.654.321-02", 38, "13222", capelao, "");
        DeputadoEstadual candidatoiii = new DeputadoEstadual("Carlos Mineiro", "456.789.123-03", 55, "22333", temaky, "");
        DeputadoEstadual candidatoiv = new DeputadoEstadual("Ana Paulista", "321.654.987-04", 47, "77444", tchetcherere, "");
        DeputadoEstadual candidato5 = new DeputadoEstadual("Fernando do Norte", "741.852.963-05", 51, "13555", capelao, "");
        DeputadoEstadual candidato6 = new DeputadoEstadual("Beatriz da Feira", "852.963.741-06", 36, "22666", temaky, "");

        eleicao2024.cadastrarDeputadoEstatual(candidatoi);
        eleicao2024.cadastrarDeputadoEstatual(candidatoii);
        eleicao2024.cadastrarDeputadoEstatual(candidatoiii);
        eleicao2024.cadastrarDeputadoEstatual(candidatoiv);
        eleicao2024.cadastrarDeputadoEstatual(candidato5);
        eleicao2024.cadastrarDeputadoEstatual(candidato6);

        // senador
        Senador rikelme = new Senador("Darlysson Rikelme", "123.456.789-99", 23, "123", temaky,"C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\riquelme.jpg");
        eleicao2024.cadastrarSenador(rikelme);

        Senador leo = new Senador("Leo Molotov", "123.456.789-99", 24, "321", capelao, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\leo.png");
        eleicao2024.cadastrarSenador(leo);

        Senador candidato3 = new Senador("Carlos Mendes", "555.666.777-88", 50, "3030", tchetcherere, "");
        eleicao2024.cadastrarSenador(candidato3);

        // governador
        Governador carlim = new Governador("Ananias Carlos", "123.456.789-99", 33, "12", capelao,"C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\carlim.jpg");
        eleicao2024.cadastrarGovernador(carlim);

        Governador sid = new Governador("Sidney Verstappen", "123.456.789-99", 20, "33", temaky, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\sid.png");
        eleicao2024.cadastrarGovernador(sid);

        Governador candidato4 = new Governador("Ana Pereira", "111.222.333-44", 42, "4040", tchetcherere, "");
        eleicao2024.cadastrarGovernador(candidato4);

        // presidente
        Presidente batman = new Presidente("Gustavo Lima", "999", 54, "77", tchetcherere,  "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img.png");
        eleicao2024.cadastrarPresidente(batman);

        Presidente lula = new Presidente("Luiz Inácio Lula da Silva", "123.456.789-99", 80, "13", capelao, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\lula.jpg");
        eleicao2024.cadastrarPresidente(lula);

        Presidente bolsonaro = new Presidente("Jair M. Bolsonaro", "123.456.789-99", 69, "22", temaky, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\bolso.jpg");
        eleicao2024.cadastrarPresidente(bolsonaro);


        MediadorInterface urna = new MediadorInterface(eleicao2024);
        urna.visibilidade(true);

    }

}
