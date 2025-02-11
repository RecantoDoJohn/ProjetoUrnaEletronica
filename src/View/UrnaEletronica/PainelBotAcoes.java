package View.UrnaEletronica;

import Eleicao.Eleicao;
import Pessoas.Candidato;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class PainelBotAcoes extends JPanel {


    private FuncoesUrna funcoesUrna;

    public PainelBotAcoes(FuncoesUrna funcoesUrna) {
        this.setBounds(400, 350, 150, 300);
        this.setLayout(new GridLayout(3, 1, 10, 10));
        this.funcoesUrna = funcoesUrna;

        JButton botaoBranco = criarBotaoAcao("BRANCO", Color.WHITE, Color.BLACK);
        botaoBranco.addActionListener(e -> funcoesUrna.votoBranco());
        this.add(botaoBranco);

        JButton botaoCorrige = criarBotaoAcao("CORRIGE", Color.ORANGE, Color.BLACK);
        botaoCorrige.addActionListener(e -> funcoesUrna.corrigirVoto());
        this.add(botaoCorrige);

        JButton botaoConfirma = criarBotaoAcao("CONFIRMA", Color.GREEN, Color.WHITE);
        botaoConfirma.addActionListener(e -> funcoesUrna.confirmarVoto());
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
}
