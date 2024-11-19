import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartScreen extends JPanel {
    public StartScreen(ActionListener startGameListener) {
        setLayout(new BorderLayout());

        // create a label for the title on the opening screen 
        JLabel titleLabel = new JLabel("Welcome to Hangman!" , SwingConstants.CENTER);  // center title text 
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));  // sets the font, bolds the text, and sizes to 20
        add(titleLabel, BorderLayout.CENTER);  // displayed at the center of the GUI 

        // create a button so user can click to start the game 
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(startGameListener);
        add(startButton, BorderLayout.SOUTH);  // displayed at the bottom of the GUI 
    }
}
