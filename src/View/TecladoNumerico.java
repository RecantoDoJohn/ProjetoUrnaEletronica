package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TecladoNumerico extends JPanel {
    private CampoNumero campoNumero;
    private String numero;
    private FotoCandidato fotoCandidato;

    public TecladoNumerico(CampoNumero campoNumero, FotoCandidato fotoCandidato) {
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;

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
        TeclaNum botao = new TeclaNum(numero, campoNumero, fotoCandidato);
        painel.add(botao);
    }


}
