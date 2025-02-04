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
        String texto = "'";

        switch (eleicao.getEleitorDoMomento().getOrdemVotacao()) {
            case 0:
                texto = "DEPUTADO FEDERAL";
                break;
            case 1:
                texto = "DEPUTADO ESTADUAL";
                break;
            case 2:
                texto = "SENADOR";
                break;
            case 3:
                texto = "GOVERNADOR";
                break;
            case 4:
                texto = "PRESIDENTE";
                break;
        }

        this.setText("SEU VOTO PARA " + texto);
    }


    public void textoVotoCandidato(Candidato candidato) {
        this.setText("VOTO CONFIRMADO PARA:\n" + candidato.getNome() + " - "+ candidato.getPartido().getNome());
    }
}
