package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TecladoNumerico extends JPanel {
    private CampoNumero campoNumero;

    public TecladoNumerico(CampoNumero campoNumero) {
        this.campoNumero = campoNumero;
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
        JButton botao = new JButton(numero);
        botao.setFont(new Font("Arial", Font.BOLD, 24));
        botao.setBackground(Color.LIGHT_GRAY);
        botao.setFocusPainted(false);
        botao.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        botao.addActionListener(e -> campoNumero.setText(campoNumero.getText() + numero));
        painel.add(botao);
    }
}
