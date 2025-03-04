package View.UrnaEletronica;

import Eleicao.Eleicao;

// setar classe teste para candidatos
// votos predifinidos (magicos)

public class InterfaceUrna {

    private Eleicao eleicao;
    private PainelTela painelTela;
    private JanelaUrna janelaUrna;
    private FuncoesUrna funcoesUrna;
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

        // funcoes da urna
        funcoesUrna = new FuncoesUrna(telaCandidato, campoNumero, fotoCandidato, eleicao, this);

        // Botões de ação
        painelBotAcoes = new PainelBotAcoes(funcoesUrna);
        janelaUrna.add(painelBotAcoes);
    }

    public void visivel(Boolean visibilidade) {
        this.janelaUrna.setVisible(visibilidade);
    }

    public void destruirTela() {
        this.janelaUrna.dispose();
    }

}

