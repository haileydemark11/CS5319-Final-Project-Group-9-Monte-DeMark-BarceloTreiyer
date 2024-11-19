import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EndScreen extends JPanel {
    private JLabel messageLabel;

    public EndScreen(ActionListener inputHandler) {
      setLayout(new BorderLayout());

      // game over label 
      messageLabel = new JLabel("", SwingConstants.CENTER);  // message centered (game over message)
      messageLabel.setFont(new Font("Arial", Font.BOLD, 16));  // bolded text
      add(messageLabel, BorderLayout.CENTER);  // center of GUI 

      // play again button 
      JButton playAgainButton = new JButton("Play Again");
      playAgainButton.addActionListener(inputHandler);
      add(playAgainButton, BorderLayout.SOUTH);  // buttom of the GUI 
    }

    public void setMessage(String message) {
      messageLabel.setText(message);
    }
}