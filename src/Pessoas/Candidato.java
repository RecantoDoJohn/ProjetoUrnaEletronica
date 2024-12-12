package Pessoas;

public class Candidato extends Pessoa {
    private String numero;
    private String partido;
    private int qntVotos;
    private boolean eleicaoProporcional;

    public Candidato(String nome, String cpf, int idade, String numero, String partido, boolean eleicaoProporcional) {
        super(nome, cpf, idade);
        this.numero = numero;
        this.partido = partido;
        this.eleicaoProporcional = eleicaoProporcional;
        this.qntVotos = 0;

//        n sei como pega booleano no scaner :p na real sei mas mo preguiça
//        this.eleicaoProporcional = eleicaoProporcional;
    }

    public void receberVoto() {
        qntVotos++;
    }

    public String getNumero() {
        return numero;
    }

    public String getPartido() {
        return partido;
    }
}
