package View.UrnaEletronica;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PainelTela extends JPanel {
    public PainelTela() {
        this.setBounds(50, 20, 500, 300);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.BLACK, 3));
        this.setLayout(null);
    }
}
