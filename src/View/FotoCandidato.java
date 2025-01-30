package View;

import Eleicao.Eleicao;
import Pessoas.Candidato;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class FotoCandidato extends JLabel {

    private Eleicao eleicao;

    public FotoCandidato(Eleicao eleicao) {
        this.eleicao = eleicao;
        this.setBounds(150, 120, 200, 150);
        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    public void atualizarFoto(String numero) {

        Candidato candidato = eleicao.getCandidatos().get(numero);

        if (candidato != null && candidato.getOrdem() == eleicao.verificarEleitor("0477").getOrdemVotacao()) {
            this.setIcon(new ImageIcon(new ImageIcon(candidato.getLocalImagem()).getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
        }

    }

}
