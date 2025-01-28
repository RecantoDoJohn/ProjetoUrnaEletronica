package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeclaNum extends JButton implements ActionListener {

    private String numero;
    private CampoNumero campoNumero;
    private FotoCandidato fotoCandidato;

    public TeclaNum(String numero, CampoNumero campoNumero, FotoCandidato fotoCandidato) {
        super(numero);

        this.numero = numero;
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;

        this.setFont(new Font("Arial", Font.BOLD, 24));
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusPainted(false);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numeroTela = campoNumero.getText() + numero;
        System.out.println(numeroTela);
        campoNumero.setText(numeroTela);
        fotoCandidato.atualizarFoto(numeroTela);
    }
}
