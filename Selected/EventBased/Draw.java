import java.net.URL;

public class Draw {

  // return type is java.net.URL because that is what swing's JLabel.setIcon() expects
  public java.net.URL drawNextPart(int remainingGuesses) {
      // Logic to draw the next part of the hangman
      if(remainingGuesses == 5){
        return  getClass().getResource("/hangman_images/1.png");
      }
      else if (remainingGuesses == 4) {
        return getClass().getResource("/hangman_images/2.png");
      }
      else if (remainingGuesses == 3) {
        return getClass().getResource("/hangman_images/3.png");
      }
      else if (remainingGuesses == 2) {
        return getClass().getResource("/hangman_images/4.png");
      }
      else if (remainingGuesses == 1) {
        return getClass().getResource("/hangman_images/5.png");
      }
      else{
        return getClass().getResource("/hangman_images/6.png");
      }
  }

  public java.net.URL resetDrawing() {
      // Logic to reset drawing
      return getClass().getResource("/hangman_images/0.png");
  }
}

