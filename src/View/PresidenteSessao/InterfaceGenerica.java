package View.PresidenteSessao;

import javax.swing.*;
import java.awt.*;

class InterfaceGenerica extends JPanel {
    public InterfaceGenerica() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel("Texto:");
        label.setFont(new Font(null, Font.BOLD, 20));

        JTextField textField = new JTextField(30);
        textField.setFont(new Font(null, Font.BOLD, 20));
        textField.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(textField, gbc);

        JButton button = new BotoesPresidente("Enviar");
        button.setFont(new Font(null, Font.BOLD, 20));
        button.setPreferredSize(new Dimension(80, 25));

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(button, gbc);
    }

        public static void main(String[] arg) {
            JFrame frame = new JFrame("Interface Simples");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            // Cria um painel e organiza os componentes
            InterfaceGenerica panel = new InterfaceGenerica();
            frame.add(panel);

            frame.setVisible(true);
        }
}



