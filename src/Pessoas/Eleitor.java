package Pessoas;

public class Eleitor extends Pessoa{
    private int zona;
    private int secao;
    private String municipio;
    private String uf;
    private String tituloEleitoral;
    private boolean jaVotou;


    public Eleitor(int zona, int secao, String municipio, String uf, String tituloEleitoral, boolean jaVotou) {
        super(tituloEleitoral, municipio, secao);
        this.zona = zona;
        this.secao = secao;
        this.municipio = municipio;
        this.uf = uf;
        this.tituloEleitoral = tituloEleitoral;
        this.jaVotou = false;

    }

    public void setJaVotou() {

    }

    public void votar() {

    }

    public boolean verificarTitulo() {
        return false;
    }
}
