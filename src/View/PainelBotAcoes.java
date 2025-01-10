//package View;
//
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import java.awt.*;
//import java.util.HashMap;
//
//public class PainelBotAcoes extends JPanel {
//
//    private CampoNumero campoNumero;
//    private TelaCadidato telaCadidato;
//    private FotoCandidato fotoCandidato;
//    private HashMap<String, String> candidatos;
//    private HashMap<String, String> fotos;
//
//    public PainelBotAcoes() {
//        this.setBounds(400, 350, 150, 300);
//        this.setLayout(new GridLayout(3, 1, 10, 10));
//
//        JButton botaoBranco = criarBotaoAcao("BRANCO", Color.WHITE, Color.BLACK);
//        botaoBranco.addActionListener(e -> votoBranco());
//        this.add(botaoBranco);
//
//        JButton botaoCorrige = criarBotaoAcao("CORRIGE", Color.ORANGE, Color.BLACK);
//        botaoCorrige.addActionListener(e -> corrigirVoto());
//        this.add(botaoCorrige);
//
//        JButton botaoConfirma = criarBotaoAcao("CONFIRMA", Color.GREEN, Color.WHITE);
//        botaoConfirma.addActionListener(e -> confirmarVoto());
//        this.add(botaoConfirma);
//    }
//
//    private JButton criarBotaoAcao(String texto, Color corFundo, Color corTexto) {
//        JButton botao = new JButton(texto);
//        botao.setFont(new Font("Arial", Font.BOLD, 18));
//        botao.setBackground(corFundo);
//        botao.setForeground(corTexto);
//        botao.setFocusPainted(false);
//        botao.setBorder(new LineBorder(Color.BLACK, 2));
//        return botao;
//    }
//
//    private void votoBranco() {
//        this.telaCadidato.setText("VOTO EM BRANCO REGISTRADO");
//        campoNumero.setText("");
//        fotoCandidato.setIcon(null);
//    }
//
//    private void corrigirVoto() {
//        campoNumero.setText("");
//        telaCandidato.setText("SEU VOTO PARA");
//        fotoCandidato.setIcon(null);
//    }
//
//    private void confirmarVoto() {
//        String numero = campoNumero.getText();
//        if (numero.isEmpty()) {
//            telaCandidato.setText("NÚMERO INVÁLIDO!");
//            fotoCandidato.setIcon(null);
//        }
//
//        String candidato = candidatos.get(numero);
//        String caminhoFoto = fotos.get(numero);
//
//        if (candidato != null ) {
//            telaCandidato.setText("VOTO CONFIRMADO PARA:\n" + candidato);
//            fotoCandidato.setIcon(new ImageIcon(new ImageIcon(caminhoFoto).getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
//        } else {
//            telaCandidato.setText("CANDIDATO INEXISTENTE!");
//            fotoCandidato.setIcon(null);
//        }
//
//
//}
