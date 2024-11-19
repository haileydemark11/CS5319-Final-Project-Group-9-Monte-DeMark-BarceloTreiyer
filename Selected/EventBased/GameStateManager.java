import java.util.List;
import java.util.ArrayList;

public class GameStateManager {

    GuessWordDisplay guess;
    WordManager wordManager;
    OutputManager output;
    
    private int remainingGuesses;
    private String wordToGuess;
    private boolean isGameOver;
    

    public GameStateManager() {
        wordManager = new WordManager();
        initiate();
    }

    public void initiate(){
        wordManager.reset();
        wordToGuess = wordManager.getFirstWord();
        guess = new GuessWordDisplay(wordToGuess);
        remainingGuesses = 6;
        isGameOver = false;
    }

    public String nextWord() {
        // Initialize game logic
        wordToGuess = wordManager.getNextWord();
        guess = new GuessWordDisplay(wordToGuess);
        remainingGuesses = 6;
        return wordToGuess;
    }

    public boolean guessLetter(char letter) {
        // Handle guess logic
        boolean result = guess.handleGuess(letter);
        if(!result){
            remainingGuesses -= 1;
            if(remainingGuesses == 0){
                isGameOver = true;
            }
        }
        return result;
    }

    public boolean checkGameStatus() {
        // Logic to check the game's status
        return isGameOver;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }
    public int getRemainingGuesses(){
        return remainingGuesses;
    }
}
