package Pessoas;

// usar strategy
public abstract class Candidato extends Pessoa {
    private String numero;
    private Partido partido;
    private int qntVotos;
    private String localImagem;
    private int ordem;

    public Candidato(String nome, String cpf, int idade, String numero, Partido partido, String localImagem, int ordem) {
        super(nome, cpf, idade);
        this.numero = numero;
        this.partido = partido;
        this.qntVotos = 0;
        this.localImagem = localImagem;
        this.ordem = ordem;
    }

    public void receberVoto() {
        qntVotos++;
        this.partido.receberVoto(this.ordem);
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

    public String getLocalImagem() {
        return localImagem;
    }

    public int getOrdem() {
        return ordem;
    }


    public void zerarVotos() {
        this.qntVotos = 0;
    }
}
