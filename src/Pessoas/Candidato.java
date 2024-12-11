package Pessoas;

public class Candidato extends Pessoa {
    private String numero;
    private String partido;
    private int qntVotos = 0;
    private boolean eleicaoProporcional;

    public Candidato(String nome, String cpf, int idade, String numero, String partido) {
        super(nome, cpf, idade);
        this.numero = numero;
        this.partido = partido;

//        n sei como pega booleano no scaner :p na real sei mas mo preguiça
//        this.eleicaoProporcional = eleicaoProporcional;
    }

    public String getNumero() {
        return numero;
    }

    public String getPartido() {
        return partido;
    }
}
