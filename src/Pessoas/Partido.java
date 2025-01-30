package Pessoas;

//
public class Partido {
    private String nomePartido;
    private String numeroPartido;
    private int qntVotos;

    public Partido(String nomePartido, String numeroPartido) {
        this.nomePartido = nomePartido;
        this.numeroPartido = numeroPartido;
    }

    public String getNome() {
        return nomePartido;
    }

    public void receberVoto() {
        qntVotos++;
    }
}
