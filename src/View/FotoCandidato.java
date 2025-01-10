package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FotoCandidato extends JLabel {
    public FotoCandidato() {
        this.setBounds(150, 120, 200, 150);
        this.setBorder(new LineBorder(Color.BLACK, 2));
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
