import Pessoas.Candidato;
import Pessoas.Eleitor;

import java.util.ArrayList;

public class Eleicao {

    private ArrayList<Eleitor> eleitores = new ArrayList<>();
    private ArrayList<Candidato> candidatos = new ArrayList<>();
    private Boolean encerrado = false;


    public void cadastrarEleitor(Eleitor novoEleitor) {
        this.eleitores.add(novoEleitor);
    }

    public void cadastrarCandidato(Candidato novoCandidato) {
        this.candidatos.add(novoCandidato);
    }

    // falta colocar no diagrama
    public ArrayList<Eleitor> getEleitores() {
        return eleitores;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void finalizarEleicao() {
        encerrado = true;
    }

    // cpf é um place holder pro titulo eleitoral
    public void registrarVoto(String cpf) {
        for (int i = 0; i < eleitores.size(); i++) {
            Eleitor eleitor = eleitores.get(i);
            if (eleitor.getCpf().equals(cpf)) {
                System.out.println("valido");
                System.out.println(eleitor.getNome());
                // eleitor.votar(); // ainda n existe esse metodo :O

                eleitor.setJaVotou();

                break;
            }
        }
    }
}

