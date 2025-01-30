package View;

import Eleicao.Eleicao;
import Pessoas.Candidato;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class PainelBotAcoes extends JPanel {

    private CampoNumero campoNumero;
    private TelaCadidato telaCadidato;
    private FotoCandidato fotoCandidato;
    private Eleicao eleicao;
    private int confirmar;

    public PainelBotAcoes(TelaCadidato telaCadidato, CampoNumero campoNumero, FotoCandidato fotoCandidato, Eleicao eleicao) {
        this.setBounds(400, 350, 150, 300);
        this.setLayout(new GridLayout(3, 1, 10, 10));
        this.telaCadidato = telaCadidato;
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;
        this.eleicao = eleicao;
        this.confirmar = 0;


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
        eleicao.addVotoBranco();
    }

    private void corrigirVoto() {
        this.campoNumero.setText("");
        this.telaCadidato.trocarCargo();
        this.fotoCandidato.setIcon(null);
        eleicao.gerarRelatorio();
        confirmar = 0;
    }

    private void confirmarVoto() {
        String numero = campoNumero.getText();

        if (numero.isEmpty()) {
            this.telaCadidato.setText("NÚMERO INVÁLIDO!");
            this.fotoCandidato.setIcon(null);
        }

        Candidato candidato = eleicao.getCandidatos().get(numero);

        // deu certo e passa
        if (candidato != null) {

            if (confirmar == 0 && candidato.getOrdem() == eleicao.verificarEleitor("0477").getOrdemVotacao()) {
                confirmar = 1;
                telaCadidato.setText("VOTO CONFIRMADO PARA:\n" + candidato.getNome() + " - "+ candidato.getPartido().getNome());
            } else if (confirmar == 1 ) {
                eleicao.registrarVoto(candidato.getNumero(), "0477");
                telaCadidato.trocarCargo();
                this.campoNumero.setText("");
                confirmar = 0;
            }

        } else {
            eleicao.addVotoNulo();
            telaCadidato.setText("VOTO NULO");
            fotoCandidato.setIcon(null);
        }

    }
}
