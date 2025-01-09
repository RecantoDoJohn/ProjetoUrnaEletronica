package View;

import javax.swing.*;
import java.awt.*;

public class campoNumero extends JTextField {

    public campoNumero() {

        this.setFont(new Font("Arial",Font.BOLD, 35));
        this.setEditable(false);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setBounds(100, 60, 300, 50);
        this.setBackground(Color.WHITE);
        this.setBorder(null);
    }

}
