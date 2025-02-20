package View.PresidenteSessao;

import Eleicao.Eleicao;

import javax.swing.*;
import java.awt.*;

// Interface gráfica
public class InterfacePresidente extends JFrame {
    private JTextField tituloEleitorField;
    private JButton abrirVotacaoButton;
    private JButton registrarButton;
    private JButton finalizarEleicaoButton;
    private JButton votosMagicosButton;
    private FuncoesPresidente funcoesPresidente;

    public InterfacePresidente(Eleicao eleicao) {
        this.funcoesPresidente = new FuncoesPresidente(eleicao, this);
        initUI();
    }

    private void initUI() {
        setTitle("🗳️ Sistema de Eleição");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        JLabel label = new JLabel("Título de Eleitor:");
        label.setFont(new Font(null, Font.BOLD, 20));

        tituloEleitorField = new JTextField(15);
        tituloEleitorField.setFont(new Font(null, Font.BOLD, 20));

        abrirVotacaoButton = new BotoesPresidente("📢 Abrir Eleição");
        registrarButton = new BotoesPresidente("🖊️ Registrar Voto");
        finalizarEleicaoButton = new BotoesPresidente("🏁 Finalizar Eleição");
        votosMagicosButton = new BotoesPresidente("✨ Votos Mágicos");


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 5, 5));

        JPanel botoesSuperiores = new JPanel(new GridLayout(3, 2, 5, 5));
        botoesSuperiores.add(label);
        botoesSuperiores.add(tituloEleitorField);

        botoesSuperiores.add(abrirVotacaoButton);
        botoesSuperiores.add(registrarButton);

        botoesSuperiores.add(finalizarEleicaoButton);
        botoesSuperiores.add(votosMagicosButton);

        panel.add(botoesSuperiores);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panel, gbc);

        abrirVotacaoButton.addActionListener(e -> funcoesPresidente.abrirVotacao());
        registrarButton.addActionListener(e -> funcoesPresidente.registrarVoto(tituloEleitorField.getText()));
        finalizarEleicaoButton.addActionListener(e -> funcoesPresidente.finalizarEleicao());
        votosMagicosButton.addActionListener(e -> funcoesPresidente.votosMagicosBut());
    }

}

