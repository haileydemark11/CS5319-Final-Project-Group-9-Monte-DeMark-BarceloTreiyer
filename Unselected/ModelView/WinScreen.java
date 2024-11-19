import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WinScreen extends JPanel {
    private JLabel messageLabel;

    public WinScreen(ActionListener nextLevelListener) {
      setLayout(new BorderLayout());

      // winning message label
      messageLabel = new JLabel("", SwingConstants.CENTER);
      messageLabel.setFont(new Font("Arial", Font.BOLD, 16));  // bolded 
      add(messageLabel, BorderLayout.CENTER);  // center of GUI 

      // next level button
      JButton nextLevelButton = new JButton("Next Level");
      nextLevelButton.setFont(new Font("Arial", Font.PLAIN, 14));  // not bolded, smaller text 
      nextLevelButton.addActionListener(nextLevelListener);
      add(nextLevelButton, BorderLayout.SOUTH);  // bottom of GUI 
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }
}
