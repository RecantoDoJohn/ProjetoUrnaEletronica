package View;

import javax.swing.*;
import Eleicao.Eleicao;

// setar classe teste para candidatos
// votos predifinidos (magicos)

public class InterfaceUrna {

    private JanelaUrna janelaUrna;
    private CampoNumero campoNumero;
    private JTextArea telaCandidato;
    private JLabel fotoCandidato;
    protected Eleicao eleicao;

    public InterfaceUrna(Eleicao eleicao) {
        this.eleicao = eleicao;

        // Configuração da Janela
        janelaUrna = new JanelaUrna();

        // Tela de exibição
        JPanel painelTela = new PainelTela();


        campoNumero = new CampoNumero();
        painelTela.add(campoNumero);

        telaCandidato = new TelaCadidato();
        painelTela.add(telaCandidato);

        fotoCandidato = new FotoCandidato(eleicao);
        painelTela.add(fotoCandidato);

        janelaUrna.add(painelTela);

        // Teclado numérico
        JPanel painelNumerico = new TecladoNumerico(campoNumero);
        janelaUrna.add(painelNumerico);

        // Botões de ação
        JPanel painelAcoes = new PainelBotAcoes((TelaCadidato) telaCandidato, campoNumero, (FotoCandidato) fotoCandidato, eleicao);
        janelaUrna.add(painelAcoes);
    }

    public void visivel(Boolean visibilidade) {
        this.janelaUrna.setVisible(visibilidade);
    }

}

