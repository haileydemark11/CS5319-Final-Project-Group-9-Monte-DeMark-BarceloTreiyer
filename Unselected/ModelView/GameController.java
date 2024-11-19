public class GameController {
  private GameState gameState;
  private WordManager wordManager;
  private HangmanView hangmanView;
  private InputHandler inputHandler;
  private int currentLevel = 1;  // starts at level 1

  // GameController constructor
  public GameController() {
    wordManager = new WordManager();
    inputHandler = new InputHandler(this);
    hangmanView = new HangmanView(inputHandler);  
    hangmanView.showStartScreen();   
  }

  public void startGame() {
    System.out.println("Starting game for level: " + currentLevel);  // levels were off -- TEST
    hangmanView.resetKeyboard();  
    String word = wordManager.chooseRandomWord(currentLevel);   // selects random word from level in WordManager 
    // testing for errors 
    if (word == null) {
      throw new IllegalStateException("No word found for level: " + currentLevel);
    }
  
    gameState = new GameState(word, this);  // creates new GameState with chosen word 
    hangmanView.showGameScreen();  
    hangmanView.updateTheme(getLevelTheme(currentLevel));   // updates theme by the level user is on 
    updateGameScreen();
  }

  public void handleUserGuess(char guess) {
    boolean correct = gameState.processGuess(guess);
    hangmanView.disableGuessed(guess);
    updateGameScreen();  

    if (gameState.isGameOver()) {
      // check if word is complete or if guesses have run out
      if (gameState.isWordComplete()) {
        System.out.println("Word complete, advance to next level...");
        winStreak(); // user guessed the word correctly
      } else {
        System.out.println("Out of guesses, game over..."); 
        loseStreak(); // user ran out of guesses
      }
    }
  }

   // refreshes game screen to current status  
   private void updateGameScreen() {
    System.out.println("Updating game screen...");   // testing - output to console if screen is displayed properly (wasn't running UI properly)
    hangmanView.updateGameScreen(
        gameState.getDisplayWord(),
        gameState.getGuessedLetters(),
        gameState.getGuessesLeft()
    );
    hangmanView.updateWrongGuesses(gameState.getWrongGuesses());
  }

  public void resetToLevelOne() {
    // refresh game to level one 
    currentLevel = 1;  
    startGame(); 
  }

  public void winStreak() {
    // if another level comes nexy 
    if (wordManager.hasNextLevel(currentLevel)) {
      System.out.println("Advancing to level: " + (currentLevel + 1));  // testing to console 
      String theme = getLevelTheme(currentLevel + 1);  // get theme for next level

      // win screen displayed 
      hangmanView.showWinScreen("Congratulations! You guessed the word: " + gameState.getWord() + "! Level " 
      + (currentLevel+1) + "...");
      //currentLevel++; // DON'T ITERATE HERE ...it throws off the levels 
    } else {
        // all levels completed
        hangmanView.showEndScreen("Congratulations! You've completed all levels!");
    }
  }

  public void incrementLevelAndStart() {
    currentLevel++; // now you can increment level 
    System.out.println("Incrementing to level: " + currentLevel);  // testing 
    startGame();   
  }

  public void loseStreak() {
    // display losing screen 
    hangmanView.showEndScreen("Game Over! The word was: " + gameState.getWord());
  }

  private String getLevelTheme(int level) {
    if (level == 1) return "Fruits"; 
    else if (level == 2) return "Animals"; 
    else if (level == 3) return "Flowers"; 
    else if (level == 4) return "Movies"; 
    else if (level == 5) return "Countries"; 
    else return "Unknown Theme"; 
  }

  // getter 
  //public GameState getGameState() { return gameState; }
  public int getCurrentLevel() { return currentLevel; }

  // main method to run the program
  public static void main(String[] args) {
      new GameController();
  }
}