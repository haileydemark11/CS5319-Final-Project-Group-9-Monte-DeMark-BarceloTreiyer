import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class InputHandler implements ActionListener {
  private GameController gameController;

  // InputHandler constructor 
  public InputHandler(GameController gameController) {
      this.gameController = gameController;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // directs user interactions with the buttons 
    if (e.getSource() instanceof JButton button) {
      String text = button.getText();

      if (text.length() == 1 && Character.isLetter(text.charAt(0))) {
        gameController.handleUserGuess(text.charAt(0));
      } 
      else {
        switch(text) {
          case "Start Game" -> gameController.startGame(); 
          case "Next Level" -> gameController.incrementLevelAndStart(); 
          case "Play Again" -> gameController.resetToLevelOne(); 
          default -> { /* no button so ignore */ }
        }
      }
    }
  }
}