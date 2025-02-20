package View.PresidenteSessao;

import Eleicao.Eleicao;
import View.UrnaEletronica.InterfaceUrna;

import javax.swing.*;

public final class FuncoesPresidente {
    private Eleicao eleicao;
    private InterfaceUrna interfaceUrna;
    private InterfacePresidente interfacePresidente;

    public FuncoesPresidente(Eleicao eleicao, InterfacePresidente interfacePresidente) {
        this.eleicao = eleicao;
        this.interfacePresidente = interfacePresidente;
    }

    public void abrirVotacao() {
        new TelaHorario(eleicao).setVisible(true);
    }

    public  void registrarVoto(String tituloEleitor) {

        eleicao.verificarEleitoresRestantes();
        eleicao.verificarHorario();
        if (eleicao.selecionarEleitor(tituloEleitor) && eleicao.getAberto()) {
            interfaceUrna = new InterfaceUrna(eleicao);
            interfaceUrna.visivel(true);
        } else {
            JOptionPane.showMessageDialog(null, "⚠️ Nao é possivel votar no momento.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void finalizarEleicao() {
        JOptionPane.showMessageDialog(null, "🏁 Eleição Finalizada!", "Fim", JOptionPane.INFORMATION_MESSAGE);
        eleicao.finalizarEleicao();
        interfacePresidente.dispose();

    }

    public void votosMagicosBut() {
        if (eleicao.getAberto()){
            new TelaVotosMagicos(eleicao).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "⚠️ Nao é possivel votar no momento.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


}
