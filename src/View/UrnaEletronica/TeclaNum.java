package View.UrnaEletronica;

import Eleicao.Eleicao;
import Pessoas.Candidato;
import View.Audio;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TeclaNum extends JButton implements ActionListener {

    private String numero;
    private CampoNumero campoNumero;
    private FotoCandidato fotoCandidato;
    private TelaCadidato telaCadidato;
    private Eleicao eleicao;
    private Audio audioBip;

    public TeclaNum(String numero, CampoNumero campoNumero, FotoCandidato fotoCandidato, TelaCadidato telaCandidato, Eleicao eleicao, String caminhoAudio) {
        super(numero);

        this.eleicao = eleicao;
        this.numero = numero;
        this.campoNumero = campoNumero;
        this.fotoCandidato = fotoCandidato;
        this.telaCadidato = telaCandidato;

        this.setFont(new Font("Arial", Font.BOLD, 24));
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusPainted(false);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        this.addActionListener(this);

        this.audioBip = new Audio(caminhoAudio);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String numeroTela = campoNumero.getText() + numero;

        Candidato candidato = eleicao.getCandidatos().get(numeroTela);

        campoNumero.setText(numeroTela);

        new Thread(() -> {
            audioBip.tocar();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();

        if (candidato != null && candidato.getOrdem() == eleicao.getEleitorDoMomento().getOrdemVotacao()) {
            fotoCandidato.atualizarFoto(candidato);
            telaCadidato.textoVotoCandidato(candidato);

        } else {
            fotoCandidato.setIcon(null);
            telaCadidato.trocarCargo();
        }

    }
}
