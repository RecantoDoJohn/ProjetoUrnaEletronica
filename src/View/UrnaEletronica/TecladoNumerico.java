package View.UrnaEletronica;

import Eleicao.Eleicao;

import javax.swing.*;
import java.awt.*;


public class TecladoNumerico extends JPanel {
    private CampoNumero campoNumero;
    private String numero;
    private FotoCandidato fotoCandidato;
    private TelaCadidato telaCadidato;
    private Eleicao eleicao;

    public TecladoNumerico(CampoNumero campoNumero, FotoCandidato fotoCandidato, TelaCadidato telaCadidato, Eleicao eleicao) {
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;
        this.telaCadidato = telaCadidato;
        this.eleicao = eleicao;

        this.setBounds(50, 350, 300, 300);
        this.setLayout(new GridLayout(4, 3, 10, 10));

        for (int i = 1; i <= 9; i++) {
            addBotaoNumerico(this, String.valueOf(i));
        }
        this.add(new JLabel());
        addBotaoNumerico(this, "0");
        this.add(new JLabel());
    }

    private void addBotaoNumerico(JPanel painel, String numero) {
        TeclaNum botao = new TeclaNum(numero, campoNumero, fotoCandidato, telaCadidato, eleicao);
        painel.add(botao);
    }


}
