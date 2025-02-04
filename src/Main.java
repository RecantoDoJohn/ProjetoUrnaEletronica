import Eleicao.Eleicao;
import Pessoas.Cargos.*;
import Pessoas.Eleitor;
import Pessoas.Partido;
import View.UrnaEletronica.InterfaceUrna;

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
        Partido pT = new Partido("Partido Dos Trabalhadores - PT", "45");
        Partido pL = new Partido("Partido Liberal - PL", "45");


        // deputado federal
        DeputadoFederal paulo = new DeputadoFederal("Paulo Vitor", "123.456.789-99", 19, "1234", pT,"C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\paulo.jpg");
        eleicao2024.cadastrarDeputadoFederal(paulo);

        DeputadoFederal lucas = new DeputadoFederal("José Lucas", "123.456.789-99", 22, "4321", pL, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\lucas.jpg");
        eleicao2024.cadastrarDeputadoFederal(lucas);


        // deputado estadual
        DeputadoEstadual davi= new DeputadoEstadual("Davi", "123.456.789-99", 83, "12345", pT, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\davi.jpg");
        eleicao2024.cadastrarDeputadoEstatual(davi);

        DeputadoEstadual manuel = new DeputadoEstadual("João Manuel", "123.456.789-99", 20, "54321", pL, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\jao.png");
        eleicao2024.cadastrarDeputadoEstatual(manuel);

        // senador
        Senador rikelme = new Senador("Darlysson Rikelme", "123.456.789-99", 23, "123", pL,"C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\riquelme.jpg");
        eleicao2024.cadastrarSenador(rikelme);

        Senador leo = new Senador("Leo Molotov", "123.456.789-99", 24, "321", pL, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\leo.jpg");
        eleicao2024.cadastrarSenador(leo);

        // governador
        Governador carlim = new Governador("Ananias Carlos", "123.456.789-99", 33, "12", pT,"C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\carlim.jpg");
        eleicao2024.cadastrarGovernador(carlim);

        Governador sid = new Governador("Sidney Verstappen", "123.456.789-99", 20, "33", pL, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\sid.jpg");
        eleicao2024.cadastrarGovernador(sid);

        // presidente
        Presidente batman = new Presidente("Gustavo Lima", "999", 54, "77", tchetcherere,  "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img_1.png");
        eleicao2024.cadastrarPresidente(batman);

        Presidente lula = new Presidente("Luiz Inácio Lula da Silva", "123.456.789-99", 80, "13", pT, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\lula.jpg");
        eleicao2024.cadastrarPresidente(lula);

        Presidente bolsonaro = new Presidente("Jair M. Bolsonaro", "123.456.789-99", 69, "22", pL, "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\bolso.jpg");
        eleicao2024.cadastrarPresidente(bolsonaro);


        eleicao2024.selecionarEleitor("0477");
        InterfaceUrna urna = new InterfaceUrna(eleicao2024);
        urna.visivel(true);
    }
}
