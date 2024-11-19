import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventManager implements ActionListener{

    protected IntellijUserInterface UI;

    // OutputManager
    protected OutputManager outputManager;

    // GameStateManager
    protected GameStateManager gameStateManager;

    // Draw object
    protected Draw draw;

  // Constructor
  EventManager(IntellijUserInterface UI){
    this.UI = UI;
    this.draw = new Draw();
    outputManager = new OutputManager(UI, this);
    gameStateManager = new GameStateManager();
  }

  public void actionPerformed(ActionEvent event){
      char theLetter = event.getActionCommand().charAt(0);

      // Guess the letter and get the result
      boolean result = gameStateManager.guessLetter(theLetter);

      // take that letter off the display
      UI.disableLetterButton(theLetter);

      // check if result is correct and display letters if not
      // draw part of the hang man otherwise and augment strikes
      if(result){
          String currentDisplay = gameStateManager.guess.getGuessWordDisplay();
          UI.changeBigTextDisplay(currentDisplay);
      }
      else{
          int remainingGuesses = gameStateManager.getRemainingGuesses();
          UI.changeHangManImage(draw.drawNextPart(remainingGuesses));
          UI.changeIncorrectGuessesTextDisplay(remainingGuesses);
      }

      // Check if the game is over
      if(gameStateManager.checkGameStatus()){
          outputManager.displayGameOver();
      }

      // Check if word guessed
      if(gameStateManager.guess.isWordGuessed()){
          outputManager.progressMessage();
      }
    }
}