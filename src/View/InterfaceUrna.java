package View;

import javax.swing.*;

// setar classe teste para candidatos
// votos predifinidos (magicos)

public class InterfaceUrna {

    public JanelaUrna janelaUrna;
    private CampoNumero campoNumero;
    private JTextArea telaCandidato;
    private JLabel fotoCandidato;

    public InterfaceUrna() {
        // Configuração da Janela
        janelaUrna = new JanelaUrna();

        // Tela de exibição
        JPanel painelTela = new PainelTela();


        campoNumero = new CampoNumero();
        painelTela.add(campoNumero);

        telaCandidato = new TelaCadidato();
        painelTela.add(telaCandidato);

        fotoCandidato = new FotoCandidato();
        painelTela.add(fotoCandidato);

        janelaUrna.add(painelTela);

        // Teclado numérico
        JPanel painelNumerico = new TecladoNumerico(campoNumero);
        janelaUrna.add(painelNumerico);

        // Botões de ação
        JPanel painelAcoes = new PainelBotAcoes((TelaCadidato) telaCandidato, campoNumero, (FotoCandidato) fotoCandidato);
        janelaUrna.add(painelAcoes);

//        // tem que ver essa parte, pois os canditados vao ser usados em diversas partes
//        // provavelmente vamo colocar uma array de canditados e o tipo de eleicao no construtor dessa interface
    }

    public static void main(String[] args) {
        InterfaceUrna urna = new InterfaceUrna();
        urna.janelaUrna.setVisible(true);
    }
}

