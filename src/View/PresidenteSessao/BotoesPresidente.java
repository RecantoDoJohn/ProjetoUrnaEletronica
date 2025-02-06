package View.PresidenteSessao;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BotoesPresidente extends JButton {
    public BotoesPresidente (String titulo) {
        super(titulo);
        this.setFont(new Font(null, Font.BOLD, 20));
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusPainted(false);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 1));
    }
}
