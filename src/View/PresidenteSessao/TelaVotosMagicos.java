package View.PresidenteSessao;

import Eleicao.Eleicao;

import javax.swing.*;

public class TelaVotosMagicos extends InterfaceGenerica{

    public TelaVotosMagicos(Eleicao eleicao) {
        super(eleicao);
        this.texto.setText("Quantidade de eleitores");
        this.botao.setText("Enviar");
        this.botao.addActionListener(e -> botaoMagico());
    }

    private void botaoMagico() {
        String textCampo = this.campoTexto.getText();

        if (textCampo != null) {
            try {
                int quantEleitores = Integer.parseInt(textCampo);
                eleicao.votosMagicos(quantEleitores);
                this.dispose();
                JOptionPane.showMessageDialog(null, "✅ Foram adicionados " + quantEleitores + "votos magicos.", "Informação", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "⚠️ Insera um numero valido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
