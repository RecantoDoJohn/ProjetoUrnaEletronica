package View.UrnaEletronica;

import Eleicao.Eleicao;
import Pessoas.Candidato;

import javax.swing.*;
import java.awt.*;

public class TelaCadidato extends JTextArea {

    private Eleicao eleicao;
    public TelaCadidato(Eleicao eleicao) {
        this.eleicao = eleicao;
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setBounds(10, 10, 480, 100);
    }

    public void trocarCargo() {
        this.setText("SEU VOTO PARA " + eleicao.getNomeCargo(eleicao.getEleitorDoMomento().getOrdemVotacao()));
    }

    public void textoVotoCandidato(Candidato candidato) {
        this.setText("VOTO CONFIRMADO PARA:\n" + candidato.getNome() + " - "+ candidato.getPartido().getNome());
    }
}
