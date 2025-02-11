package View.UrnaEletronica;

import Eleicao.Eleicao;

public class FuncoesUrna {
    private CampoNumero campoNumero;
    private FotoCandidato fotoCandidato;
    private Eleicao eleicao;
    private InterfaceUrna interfaceUrna;
    private TelaCadidato telaCadidato;


    public FuncoesUrna(TelaCadidato telaCadidato, CampoNumero campoNumero, FotoCandidato fotoCandidato, Eleicao eleicao, InterfaceUrna interfaceUrna) {
        this.telaCadidato = telaCadidato;
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;
        this.eleicao = eleicao;
        this.interfaceUrna = interfaceUrna;
    }

    public void votoBranco() {
        campoNumero.setText("");
        fotoCandidato.setIcon(null);
        eleicao.addVotoBranco();
        this.telaCadidato.trocarCargo();

        if(eleicao.getEleitorDoMomento().getOrdemVotacao() > 4) {
            interfaceUrna.destruirTela();
        }
    }

    public void corrigirVoto() {
        this.campoNumero.setText("");
        this.telaCadidato.trocarCargo();
        this.fotoCandidato.setIcon(null);
    }

    public void confirmarVoto() {
        String numero = campoNumero.getText();

        if (numero.isEmpty()) {
            this.telaCadidato.setText("NÚMERO INVÁLIDO!");
            this.fotoCandidato.setIcon(null);
        }

        // nao ta vazio
        else {
            eleicao.registrarVoto(numero);
            fotoCandidato.setIcon(null);
            this.campoNumero.setText("");
            telaCadidato.trocarCargo();

            if(eleicao.getEleitorDoMomento().getOrdemVotacao() > 4) {
                interfaceUrna.destruirTela();
            }
        }
    }
}
