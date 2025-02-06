package View.PresidenteSessao;

import javax.swing.*;

public final class FuncoesPresidente {

    public void abrirVotacao() {
        JOptionPane.showMessageDialog(null, "✅ Votação Aberta!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void registrarVoto(String tituloEleitor) {
        if (tituloEleitor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "⚠️ Por favor, insira o título de eleitor.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "🗳️ Voto registrado para o título: " + tituloEleitor, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void finalizarEleicao() {
        JOptionPane.showMessageDialog(null, "🏁 Eleição Finalizada!", "Fim", JOptionPane.INFORMATION_MESSAGE);
    }

    public void registrarPessoa() {
        JOptionPane.showMessageDialog(null, "🏁 Ainda nada feito", "xii", JOptionPane.INFORMATION_MESSAGE);
    }
}
