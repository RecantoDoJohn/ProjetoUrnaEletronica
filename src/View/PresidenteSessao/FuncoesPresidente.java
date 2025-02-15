package View.PresidenteSessao;

import Eleicao.Eleicao;
import View.UrnaEletronica.InterfaceUrna;

import javax.swing.*;

public final class FuncoesPresidente {
    private Eleicao eleicao;

    public FuncoesPresidente(Eleicao eleicao) {
        this.eleicao = eleicao;
    }

    public void abrirVotacao() {
        new TelaHorario(eleicao).setVisible(true);
    }

    public  void registrarVoto(String tituloEleitor) {

        eleicao.verificarHorario();
        if (eleicao.selecionarEleitor(tituloEleitor) && eleicao.getAberto()) {
            InterfaceUrna urna = new InterfaceUrna(eleicao);
            urna.visivel(true);
        } else {
            JOptionPane.showMessageDialog(null, "⚠️ Nao é possivel votar no momento.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public  void finalizarEleicao() {
        JOptionPane.showMessageDialog(null, "🏁 Eleição Finalizada!", "Fim", JOptionPane.INFORMATION_MESSAGE);
        eleicao.finalizarEleicao();
        eleicao.gerarRelatorio();
    }

    public void votosMagicosBut() {
        if (eleicao.getAberto()){
            new TelaVotosMagicos(eleicao).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "⚠️ Nao é possivel votar no momento.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
