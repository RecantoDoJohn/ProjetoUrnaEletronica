package Pessoas;

public class Eleitor extends Pessoa{
    private int zona;
    private int secao;
    private String municipio;
    private String uf;
    private String tituloEleitoral;
    private int ordemVotacao;


    public Eleitor(int zona, int secao, String municipio, String uf, String tituloEleitoral) {
        super(tituloEleitoral, municipio, secao);
        this.zona = zona;
        this.secao = secao;
        this.municipio = municipio;
        this.uf = uf;
        this.tituloEleitoral = tituloEleitoral;
        this.ordemVotacao = 0;

    }

    public Eleitor(String nome, String cpf, int idade, String tituloEleitoral) {
        super(nome, cpf, idade);
        this.tituloEleitoral = tituloEleitoral;
        this.ordemVotacao = 0;
    }

    public String getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void avancarVoto() {
        this.ordemVotacao++;
    }

    public int getOrdemVotacao() {
        return ordemVotacao;
    }



    public boolean verificarTitulo() {
        return false;
    }
}
