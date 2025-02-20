package Pessoas;

public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }


    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public int getIdade() {
        return this.idade;
    }


}
