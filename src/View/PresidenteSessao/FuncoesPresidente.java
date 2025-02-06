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
        JOptionPane.showMessageDialog(null, "✅ Votação Aberta!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        eleicao.abrirEleicao();
    }

    public  void registrarVoto(String tituloEleitor) {
        if (eleicao.selecionarEleitor(tituloEleitor) && eleicao.getAberto()) {
//            JOptionPane.showMessageDialog(null, "🗳️ Voto registrado para o título: " + tituloEleitor, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            InterfaceUrna urna = new InterfaceUrna(eleicao);
            urna.visivel(true);
        } else {
            JOptionPane.showMessageDialog(null, "⚠️ Por favor, insira o título de eleitor.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public  void finalizarEleicao() {
        JOptionPane.showMessageDialog(null, "🏁 Eleição Finalizada!", "Fim", JOptionPane.INFORMATION_MESSAGE);
        eleicao.finalizarEleicao();
        eleicao.gerarRelatorio();
    }

    public void registrarPessoa() {
        JOptionPane.showMessageDialog(null, "🏁 Ainda nada feito", "xii", JOptionPane.INFORMATION_MESSAGE);
    }

}
