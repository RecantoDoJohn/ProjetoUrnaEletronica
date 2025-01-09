package View;

import javax.swing.*;
import java.awt.*;

public class telaCadidato extends JTextArea {
    public telaCadidato() {
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEditable(false);
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setText("SEU VOTO PARA");
        this.setBounds(10, 10, 480, 100);
    }
}
