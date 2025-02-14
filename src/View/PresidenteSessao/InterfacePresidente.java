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
    private JButton registrarPessoa;
    private JButton votosMagicos;
    private FuncoesPresidente funcoesPresidente;

    public InterfacePresidente(Eleicao eleicao) {
        this.funcoesPresidente = new FuncoesPresidente(eleicao);
        initUI();
    }

    private void initUI() {
        setTitle("🗳️ Sistema de Eleição");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel("Título de Eleitor:");
        label.setFont(new Font(null, Font.BOLD, 20));

        tituloEleitorField = new JTextField(15);
        tituloEleitorField.setFont(new Font(null, Font.BOLD, 20));

        abrirVotacaoButton = new BotoesPresidente("📢 Abrir Eleição");
        registrarButton = new BotoesPresidente("🖊️ Registrar Voto");
        finalizarEleicaoButton = new BotoesPresidente("🏁 Finalizar Eleição");
        registrarPessoa = new BotoesPresidente("\uD83D\uDCD6 Registrar Pessoa");
        votosMagicos = new BotoesPresidente("✨ Votos Mágicos");


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 5, 5));
        panel.add(label);
        panel.add(tituloEleitorField);

        JPanel botoesSuperiores = new JPanel(new GridLayout(2, 2, 5, 5));
        botoesSuperiores.add(abrirVotacaoButton);
        botoesSuperiores.add(registrarButton);
        botoesSuperiores.add(finalizarEleicaoButton);
        botoesSuperiores.add(registrarPessoa);

        panel.add(botoesSuperiores);
        panel.add(votosMagicos);

        add(panel);

        abrirVotacaoButton.addActionListener(e -> funcoesPresidente.abrirVotacao());
        registrarButton.addActionListener(e -> funcoesPresidente.registrarVoto(tituloEleitorField.getText()));
        finalizarEleicaoButton.addActionListener(e -> funcoesPresidente.finalizarEleicao());
        registrarPessoa.addActionListener(e -> funcoesPresidente.registrarPessoa());
    }

}

