package View.UrnaEletronica;

import Eleicao.Eleicao;
import View.Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class FuncoesUrna {
    private CampoNumero campoNumero;
    private FotoCandidato fotoCandidato;
    private Eleicao eleicao;
    private InterfaceUrna interfaceUrna;
    private TelaCadidato telaCadidato;
    private Audio audioConfirmar;


    public FuncoesUrna(TelaCadidato telaCadidato, CampoNumero campoNumero, FotoCandidato fotoCandidato, Eleicao eleicao, InterfaceUrna interfaceUrna) {
        this.telaCadidato = telaCadidato;
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;
        this.eleicao = eleicao;
        this.interfaceUrna = interfaceUrna;
        this.audioConfirmar = new Audio("C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\audio\\confirmar.wav");
    }

    public void votoBranco() {

        if(eleicao.getEleitorDoMomento().getOrdemVotacao() == 4) {
            interfaceUrna.destruirTela();
        }
        campoNumero.setText("");
        fotoCandidato.setIcon(null);
        eleicao.addVotoBranco();
        this.telaCadidato.trocarCargo();
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

        else {
            audioConfirmar.tocar();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(eleicao.getEleitorDoMomento().getOrdemVotacao() == 4) {
                interfaceUrna.destruirTela();
            }
            eleicao.registrarVoto(numero);
            fotoCandidato.setIcon(null);
            this.campoNumero.setText("");
            telaCadidato.trocarCargo();
        }
    }
}
