package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class FotoCandidato extends JLabel {

    public HashMap<String, String> candidatos;
    public HashMap<String, String> fotos;

    public FotoCandidato() {
        this.setBounds(150, 120, 200, 150);
        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    // na minha humilde opiniao isso deveria ficar na classe dos candidatos, dps nos ve isso toscaneto
    public void configurarCandidatos() {
        candidatos = new HashMap<>();
        candidatos.put("12", "Candidato Cactu - Partido X");
        candidatos.put("34", "Candidato Patati - Partido Y");
        candidatos.put("77", "Candidato Gustavo Lima - Partido Boteco");
    }

    public void configurarFotos() {
        fotos = new HashMap<>();
        fotos.put("12", "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\cactu.png");
        fotos.put("34", "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img.png");
        fotos.put("77", "C:\\Users\\teres\\Documents\\Java\\ProjetoUrna\\ProjetoUrnaEletronica\\src\\View\\img\\img_1.png");

    }
}
