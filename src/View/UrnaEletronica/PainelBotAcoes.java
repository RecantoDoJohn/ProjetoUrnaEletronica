package View.UrnaEletronica;

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
    private InterfaceUrna interfaceUrna;

    public PainelBotAcoes(TelaCadidato telaCadidato, CampoNumero campoNumero, FotoCandidato fotoCandidato, Eleicao eleicao, InterfaceUrna interfaceUrna) {
        this.setBounds(400, 350, 150, 300);
        this.setLayout(new GridLayout(3, 1, 10, 10));
        this.telaCadidato = telaCadidato;
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;
        this.eleicao = eleicao;
        this.interfaceUrna = interfaceUrna;



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
        campoNumero.setText("");
        fotoCandidato.setIcon(null);
        eleicao.addVotoBranco();
        this.telaCadidato.trocarCargo();

        if(eleicao.getEleitorDoMomento().getOrdemVotacao() > 4) {
            interfaceUrna.destruirTela();
        }
    }

    private void corrigirVoto() {
        this.campoNumero.setText("");
        this.telaCadidato.trocarCargo();
        this.fotoCandidato.setIcon(null);
    }

    private void confirmarVoto() {
        String numero = campoNumero.getText();

        if (numero.isEmpty()) {
            this.telaCadidato.setText("NÚMERO INVÁLIDO!");
            this.fotoCandidato.setIcon(null);
        }

        // nao ta vazio
        else {
            eleicao.registrarVoto(numero);
            fotoCandidato.setIcon(null);
            this.campoNumero.setText("");
            telaCadidato.trocarCargo();

            if(eleicao.getEleitorDoMomento().getOrdemVotacao() > 4) {
                interfaceUrna.destruirTela();
            }
        }
    }
}
