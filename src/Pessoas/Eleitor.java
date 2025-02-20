package Pessoas;

public class Eleitor extends Pessoa{
    private int zona;
    private int secao;
    private String municipio;
    private String uf;
    private String tituloEleitoral;
    protected int ordemVotacao;



    public Eleitor(String nome, String cpf, int idade, String tituloEleitoral) {
        super(nome, cpf, idade);
        this.tituloEleitoral = tituloEleitoral;
        this.ordemVotacao = 0;
    }

    public String getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void avancarVoto() {
        if (this.ordemVotacao != 4) {
            this.ordemVotacao++;
        }
    }

    public int getOrdemVotacao() {
        return ordemVotacao;
    }

}
