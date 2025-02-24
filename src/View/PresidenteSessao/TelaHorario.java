package View.PresidenteSessao;

import Eleicao.Eleicao;

import javax.swing.*;
import java.time.LocalTime;

public class TelaHorario extends InterfaceGenerica {

    public TelaHorario(Eleicao eleicao) {
        super(eleicao);
        this.texto.setText("Hora de finalizar\n(HH:MM)");
        this.botao.setText("Enviar");
        this.botao.addActionListener(e -> botaoHora());
    }

    private void botaoHora() {
        String textCampo = this.campoTexto.getText();

        if (textCampo != null) {
            try {
                int hora = Integer.parseInt(textCampo.substring(0, 2));
                int minutos = Integer.parseInt(textCampo.substring(3, 5));
                if (hora >= LocalTime.now().getHour() && minutos > LocalTime.now().getMinute()) {
                    eleicao.definirHorarioDeFechamento(hora, minutos);
                    eleicao.abrirEleicao();
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "✅ Votação Aberta!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ Insera um numero valido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "⚠️ Insera um numero valido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
