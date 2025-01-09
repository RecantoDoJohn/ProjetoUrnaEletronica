package View;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class InterfaceUrna {

    public janelaUrna janelaUrna;
    private campoNumero campoNumero;
    private JTextArea telaCandidato;
    private JLabel fotoCandidato;
    private HashMap<String, String> candidatos;
    private HashMap<String, String> fotos;

    public InterfaceUrna() {
        // Configuração da Janela
        janelaUrna = new janelaUrna();

        // Tela de exibição
        JPanel painelTela = new painelTela();


        campoNumero = new campoNumero();
        painelTela.add(campoNumero);

        telaCandidato = new telaCadidato();
        painelTela.add(telaCandidato);

        fotoCandidato = new fotoCandidato();
        painelTela.add(fotoCandidato);

        janelaUrna.add(painelTela);

        // Teclado numérico
        JPanel painelNumerico = new tecladoNumerico(campoNumero);
        janelaUrna.add(painelNumerico);

        // Botões de ação
        JPanel painelAcoes = new JPanel();
        painelAcoes.setBounds(400, 350, 150, 300);
        painelAcoes.setLayout(new GridLayout(3, 1, 10, 10));

        JButton botaoBranco = criarBotaoAcao("BRANCO", Color.WHITE, Color.BLACK);
        botaoBranco.addActionListener(e -> votoBranco());
        painelAcoes.add(botaoBranco);

        JButton botaoCorrige = criarBotaoAcao("CORRIGE", Color.ORANGE, Color.BLACK);
        botaoCorrige.addActionListener(e -> corrigirVoto());
        painelAcoes.add(botaoCorrige);

        JButton botaoConfirma = criarBotaoAcao("CONFIRMA", Color.GREEN, Color.WHITE);
        botaoConfirma.addActionListener(e -> confirmarVoto());
        painelAcoes.add(botaoConfirma);

        janelaUrna.add(painelAcoes);

        // Configuração dos candidatos e suas fotos
        configurarCandidatos();
        configurarFotos();
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
        telaCandidato.setText("VOTO EM BRANCO REGISTRADO");
        campoNumero.setText("");
        fotoCandidato.setIcon(null);
    }

    private void corrigirVoto() {
        campoNumero.setText("");
        telaCandidato.setText("SEU VOTO PARA");
        fotoCandidato.setIcon(null);
    }

    private void confirmarVoto() {
        String numero = campoNumero.getText();
        if (numero.isEmpty()) {
            telaCandidato.setText("NÚMERO INVÁLIDO!");
            fotoCandidato.setIcon(null);
            return;
        }

        String candidato = candidatos.get(numero);
        String caminhoFoto = fotos.get(numero);

        if (candidato != null ) {
            telaCandidato.setText("VOTO CONFIRMADO PARA:\n" + candidato);
            fotoCandidato.setIcon(new ImageIcon(new ImageIcon(caminhoFoto).getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
        } else {
            telaCandidato.setText("CANDIDATO INEXISTENTE!");
            fotoCandidato.setIcon(null);
        }

        campoNumero.setText("");
    }

    private void configurarCandidatos() {
        candidatos = new HashMap<>();
        candidatos.put("12", "Candidato Cactu - Partido X");
        candidatos.put("34", "Candidato Patati - Partido Y");
        candidatos.put("77", "Candidato Gustavo Lima - Partido Boteco");
    }

    private void configurarFotos() {
        fotos = new HashMap<>();
        fotos.put("12", "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\cactu.png");
        fotos.put("34", "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img.png");
        fotos.put("77", "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img_1.png");

    }

    public static void main(String[] args) {

            InterfaceUrna urna = new InterfaceUrna();
            urna.janelaUrna.setVisible(true);

    }
}

