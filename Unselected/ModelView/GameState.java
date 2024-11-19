import java.util.HashSet;
import java.util.Set;

public class GameState {
  private String word;  
  private int maxGuesses = 6;  
  private int guessesLeft; 
  private int wrongGuesses; 
  private Set<Character> guessedLetters;  
  private String showWord;  // word updated as player guesses (shows correct letter or '_')

  private GameController gameController; 

  // GameState constructor 
  public GameState(String word, GameController gameController) {
    this.word = word.toLowerCase();
    this.gameController = gameController; 
    this.guessesLeft = maxGuesses;  // initializes guesses left = max guesses  
    this.guessedLetters = new HashSet<>();  // empty hash set to store user guessed letters
    this.showWord = "_".repeat(word.length());  // string of '_' with the same number of '_' as letters in word 
  }

  public boolean processGuess(char guess) {
    // System.out.println("Guess: " + guess + ", Current Word: " + showWord);
    guess = Character.toLowerCase(guess);
    // if letter already guessed, return false 
    if (guessedLetters.contains(guess)) {
        return false; 
    }
    guessedLetters.add(guess);  // adds guessed letter to hash set 

    // if the guess is in the word, updates showWord 
    if (word.indexOf(guess) >= 0) {
        updateShowWord(guess);
        if (isWordComplete()) {
          gameController.winStreak(); 
        }
        return true; // correct guess, returns true  
    } else {
        wrongGuesses++;  
        guessesLeft--; 
        if (isGameOver()) {
          gameController.loseStreak(); 
        } 
        return false;   
    }
  }

  // updates showWord to show the correct letter after user guesses it
  private void updateShowWord(char guess) {
     for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == guess) {
        // replace underscore with correct letter
        showWord = showWord.substring(0, i) + guess + showWord.substring(i + 1);
      }
    }
    System.out.println("Updated word: " + showWord);  // testing if showWord is updated 
  }

  public boolean isGameOver() {
    return guessesLeft <= 0 || isWordComplete();
  }

  public boolean isWordComplete() {
    System.out.println("Checking if word is complete: " + showWord);  // testing to console 
    for (int i = 0; i < showWord.length(); i++) {
      if (showWord.charAt(i) == '_') {
        return false;   // if '_' found, word not done 
      }        
    }
    return true; // no '_', word revealed 
  }

  // getters
  public int getGuessesLeft() { return guessesLeft; }
  public Set<Character> getGuessedLetters() { return guessedLetters; }
  public int getWrongGuesses() { return wrongGuesses; }
  public String getDisplayWord() { return String.join(" ", showWord.split("")); }  // adds spacing in between '_' for word characters
  public String getWord() { return word; }
}
