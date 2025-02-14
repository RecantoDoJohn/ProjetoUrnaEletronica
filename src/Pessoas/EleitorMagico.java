package Pessoas;

public class EleitorMagico extends Eleitor{

    public EleitorMagico(String nome, String cpf, int idade, String tituloEleitoral) {
        super(nome, cpf, idade, tituloEleitoral);
    }

    @Override
    public void avancarVoto() {
        if (this.ordemVotacao != 4) {
            this.ordemVotacao++;
        } else {
            this.ordemVotacao = 0;
        }
    }
}
