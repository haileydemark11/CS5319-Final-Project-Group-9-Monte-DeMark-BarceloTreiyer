import java.awt.*;
import java.util.Set;
import javax.swing.*;

public class HangmanView extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private StartScreen startScreen;
    private GameScreen gameScreen;
    private EndScreen endScreen;
    private WinScreen winScreen;

    public HangmanView(InputHandler inputHandler) {
      setTitle("Hangman Game");   
      setSize(700, 500);   // GUI size dimensions 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
      cardLayout = new CardLayout();
      mainPanel = new JPanel(cardLayout);
  
      // testing -- check input handler working to play
      if (inputHandler == null) {
        throw new IllegalArgumentException("InputHandler can't be null");
      }

      // initialize screens
      startScreen = new StartScreen(inputHandler);
      gameScreen = new GameScreen(inputHandler);
      endScreen = new EndScreen(inputHandler);
      winScreen = new WinScreen(inputHandler);

      // screens added to main panel
      mainPanel.add(startScreen, "StartScreen");
      mainPanel.add(gameScreen, "GameScreen");
      mainPanel.add(endScreen, "EndScreen");
      mainPanel.add(winScreen, "WinScreen");

      add(mainPanel);
      setVisible(true);
    }
  
    public void showStartScreen() {
      cardLayout.show(mainPanel, "StartScreen");
    }

    public void showGameScreen() {
      // fixme -- errors with display -- test with output statement 
      System.out.println("Switching to GameScreen...");  // outputs to terminal if game screen is reached 
      cardLayout.show(mainPanel, "GameScreen");
    }

    public void showWinScreen(String message) {
      winScreen.setMessage(message);  // display winning message once player wins 
      cardLayout.show(mainPanel, "WinScreen");
    }
  
    public void showEndScreen(String message) {
      endScreen.setMessage(message);  // display loosing message when player loses 
      cardLayout.show(mainPanel, "EndScreen");
    }

    public void disableGuessed(char letter) {
      gameScreen.disableGuessed(letter); 
    }

    public void updateTheme(String theme) {
      gameScreen.updateTheme(theme);  // update game theme for levels
    }

    public void updateWrongGuesses(int wrongGuesses) {
      gameScreen.updateWrongGuesses(wrongGuesses); // fixed 
    }
  
    public void updateGameScreen(String word, Set<Character> guessedLetters, int remainingGuesses) {
      // FIXED: error -- game screen not updating with levels 
      // test to see if game screen is updated by displaying word, letters guessed, remaining guesses to terminal when user interacts 
      System.out.println("Updating GameScreen: Word: " + word + ", Guessed: " + guessedLetters + ", Remaining: " + remainingGuesses);
      gameScreen.updateDisplay(word, guessedLetters, remainingGuesses);
    }

    // resets the keyboard so letters aren't blocked out after being guessed on previoud levels 
    public void resetKeyboard() {
      gameScreen.resetKeyboard();
    }
}
