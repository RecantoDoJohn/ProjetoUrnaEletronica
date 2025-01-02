package Pessoas;

public class Candidato extends Pessoa {
    private String numero;
    private Partido partido;
    private int qntVotos;
    private boolean eleicaoProporcional;

    public Candidato(String nome, String cpf, int idade, String numero, Partido partido, boolean eleicaoProporcional) {
        super(nome, cpf, idade);
        this.numero = numero;
        this.partido = partido;
        this.eleicaoProporcional = eleicaoProporcional;
        this.qntVotos = 0;
    }

    public void receberVoto() {
        qntVotos++;
    }

    public String getNumero() {
        return numero;
    }

    public Partido getPartido() {
        return partido;
    }

    public int getQntVotos() {
        return qntVotos;
    }
}
