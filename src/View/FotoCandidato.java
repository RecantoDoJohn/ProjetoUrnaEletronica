package View;

import Eleicao.Eleicao;
import Pessoas.Candidato;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class FotoCandidato extends JLabel {

    public HashMap<String, Candidato> candidatos;
    public HashMap<String, String> fotos;
    private Eleicao eleicao;


    public FotoCandidato(Eleicao eleicao) {
        this.eleicao = eleicao;

        this.setBounds(150, 120, 200, 150);
        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.setHorizontalAlignment(JLabel.CENTER);
    }

}
