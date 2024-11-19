import java.util.ArrayList;
import java.util.List;

public class GuessWordDisplay {

    private String guessWord;
    private StringBuilder guessWordDisplay;
    private int lengthOfWord;
    private List<Character> unguessedLetters;
    private List<Character> guessedLetters;
    

    public GuessWordDisplay(String word) {
        guessWord = word;
        StringBuilder sb = new StringBuilder();
        unguessedLetters = new ArrayList<>();
        guessedLetters = new ArrayList<>();
        lengthOfWord = word.length();

        for(int i = 0; i < word.length(); i++){
          sb.append("_");
          unguessedLetters.add(guessWord.charAt(i));
        }

        guessWordDisplay = sb;
    }

    public boolean handleGuess(char letter) {
      // Logic to handle a guess
      if(unguessedLetters.contains(letter)){
        // reveal in guessWordDisplay
        revealLetter(letter);

        // Remove from unguessed letters if it is in there
        unguessedLetters.removeIf(let -> let == letter);

        // add to guessed letters
        guessedLetters.add(letter);
        return true;
      }
      guessedLetters.add(letter);
      return false;
    }

    private void revealLetter(char letter) {
      // Logic to reveal the letter
      for(int i = 0; i < lengthOfWord; i++){
        if(guessWord.charAt(i) == letter){
          guessWordDisplay.setCharAt(i, letter);
        }
      }
    }

    public String getGuessWordDisplay(){
        // convert to string
        String displayWord = guessWordDisplay.toString();

        // new string builder
        StringBuilder sb = new StringBuilder();

        // Iterate through each character of the string
        for (int i = 0; i < displayWord.length(); i++) {
            sb.append(displayWord.charAt(i)); // Append the current character
            if (i < displayWord.length() - 1) {
                sb.append(" "); // Append a space except after the last character
            }
        }
        return sb.toString();
    }

    public boolean isWordGuessed(){
        return (guessWord.equals(guessWordDisplay.toString()));
    }
}
