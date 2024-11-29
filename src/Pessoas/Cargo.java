package Pessoas;

public class Cargo extends Pessoa {
    private String numero;
    private String partido;
    private int qntVotos;
    private boolean eleicaoProporcional;

    public Cargo(String numero, String partido, int qntVotos, boolean eleicaoProporcional) {
        super(numero, partido, qntVotos);
        this.numero = numero;
        this.partido = partido;
        this.qntVotos = qntVotos;
        this.eleicaoProporcional = false;
    }

}
