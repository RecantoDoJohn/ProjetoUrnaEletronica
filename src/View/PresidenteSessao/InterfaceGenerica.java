package View.PresidenteSessao;

import Eleicao.Eleicao;

import javax.swing.*;
import java.awt.*;

public abstract class InterfaceGenerica extends JFrame {
    protected JTextField campoTexto;
    protected JPanel painel;
    protected JLabel texto;
    protected JButton botao;
    protected Eleicao eleicao;

    public InterfaceGenerica(Eleicao eleicao) {
        this.eleicao = eleicao;

        setTitle("📢 Iniciar Eleição");
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        this.texto = new JLabel();
        texto.setFont(new Font(null, Font.BOLD, 15));

        this.campoTexto = new JTextField();
        campoTexto.setFont(new Font(null, Font.BOLD, 20));
        campoTexto.setSize(100, 50);

        this.botao = new BotoesPresidente();


        this.painel = new JPanel();
        painel.setLayout(new GridLayout(2, 1, 5, 5));

        JPanel caixaEntrada = new JPanel(new GridLayout(1, 2, 5, 5));
        caixaEntrada.add(texto);
        caixaEntrada.add(campoTexto);

        painel.add(caixaEntrada);
        painel.add(botao);


        add(painel);

    }
}


