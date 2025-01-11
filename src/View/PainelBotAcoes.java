package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class PainelBotAcoes extends JPanel {

    private CampoNumero campoNumero;
    private TelaCadidato telaCadidato;
    private FotoCandidato fotoCandidato;

    public PainelBotAcoes(TelaCadidato telaCadidato, CampoNumero campoNumero, FotoCandidato fotoCandidato) {
        this.setBounds(400, 350, 150, 300);
        this.setLayout(new GridLayout(3, 1, 10, 10));
        this.telaCadidato = telaCadidato;
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;

        this.fotoCandidato.configurarCandidatos();
        this.fotoCandidato.configurarFotos();

        JButton botaoBranco = criarBotaoAcao("BRANCO", Color.WHITE, Color.BLACK);
        botaoBranco.addActionListener(e -> votoBranco());
        this.add(botaoBranco);

        JButton botaoCorrige = criarBotaoAcao("CORRIGE", Color.ORANGE, Color.BLACK);
        botaoCorrige.addActionListener(e -> corrigirVoto());
        this.add(botaoCorrige);

        JButton botaoConfirma = criarBotaoAcao("CONFIRMA", Color.GREEN, Color.WHITE);
        botaoConfirma.addActionListener(e -> confirmarVoto());
        this.add(botaoConfirma);


    }

    private JButton criarBotaoAcao(String texto, Color corFundo, Color corTexto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 18));
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setFocusPainted(false);
        botao.setBorder(new LineBorder(Color.BLACK, 2));
        return botao;
    }

    private void votoBranco() {
        this.telaCadidato.setText("VOTO EM BRANCO REGISTRADO");
        campoNumero.setText("");
        fotoCandidato.setIcon(null);
    }

    private void corrigirVoto() {
        this.campoNumero.setText("");
        this.telaCadidato.setText("SEU VOTO PARA");
        this.fotoCandidato.setIcon(null);
    }

    private void confirmarVoto() {
        String numero = campoNumero.getText();
        if (numero.isEmpty()) {
            this.telaCadidato.setText("NÚMERO INVÁLIDO!");
            this.fotoCandidato.setIcon(null);
        }

        String candidato = fotoCandidato.candidatos.get(numero);
        String caminhoFoto = fotoCandidato.fotos.get(numero);

        if (candidato != null) {
            telaCadidato.setText("VOTO CONFIRMADO PARA:\n" + candidato);
            fotoCandidato.setIcon(new ImageIcon(new ImageIcon(caminhoFoto).getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
        } else {
            telaCadidato.setText("CANDIDATO INEXISTENTE!");
            fotoCandidato.setIcon(null);
        }

    }
}
