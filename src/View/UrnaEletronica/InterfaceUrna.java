package View.UrnaEletronica;

import Eleicao.Eleicao;

// setar classe teste para candidatos
// votos predifinidos (magicos)

public class InterfaceUrna {

    private Eleicao eleicao;
    private PainelTela painelTela;
    private JanelaUrna janelaUrna;
    private CampoNumero campoNumero;
    private TelaCadidato telaCandidato;
    private FotoCandidato fotoCandidato;
    private PainelBotAcoes painelBotAcoes;
    private TecladoNumerico tecladoNumerico;

    public InterfaceUrna(Eleicao eleicao) {
        this.eleicao = eleicao;


        // Configuração da Janela
        janelaUrna = new JanelaUrna();

        // Tela de exibição
        painelTela = new PainelTela();


        campoNumero = new CampoNumero();
        painelTela.add(campoNumero);

        telaCandidato = new TelaCadidato(this.eleicao);
        telaCandidato.trocarCargo();
        painelTela.add(telaCandidato);

        fotoCandidato = new FotoCandidato(this.eleicao);
        painelTela.add(fotoCandidato);

        janelaUrna.add(painelTela);

        // Teclado numérico
        tecladoNumerico = new TecladoNumerico(campoNumero, fotoCandidato, telaCandidato, this.eleicao);
        janelaUrna.add(tecladoNumerico);

        // Botões de ação
        painelBotAcoes = new PainelBotAcoes(telaCandidato, campoNumero, fotoCandidato, this.eleicao);
        janelaUrna.add(painelBotAcoes);
    }

    public void visivel(Boolean visibilidade) {
        this.janelaUrna.setVisible(visibilidade);
    }

}

