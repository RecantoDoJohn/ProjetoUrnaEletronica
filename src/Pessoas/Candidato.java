package Pessoas;

public class Candidato extends Pessoa {
    private String numero;
    private String partido;
    private int qntVotos;
    private boolean eleicaoProporcional;

    public Candidato(String numero, String partido, int qntVotos, boolean eleicaoProporcional) {
        super(numero, partido, qntVotos);
        this.numero = numero;
        this.partido = partido;
        this.qntVotos = qntVotos;
        this.eleicaoProporcional = false;
    }

}
