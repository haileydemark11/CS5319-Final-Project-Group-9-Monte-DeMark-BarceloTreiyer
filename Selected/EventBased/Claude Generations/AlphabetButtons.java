import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlphabetButtons extends JFrame implements ActionListener {
    private static final String[] ALPHABET = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    public AlphabetButtons() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Alphabet Buttons");
        setLayout(new GridLayout(4, 7, 5, 5));

        for (String letter : ALPHABET) {
            JButton button = new JButton(letter);
            button.setActionCommand(letter);
            button.addActionListener(this);
            add(button);
        }

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println("Button clicked: " + command);
        // Perform actions based on the clicked button's action command
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AlphabetButtons example = new AlphabetButtons();
            example.setVisible(true);
        });
    }
}