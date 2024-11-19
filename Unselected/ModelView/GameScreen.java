import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

public class GameScreen extends JPanel {
    private DrawHangman hangmanDrawingPanel;
    private JLabel wordLabel;
    private JLabel guessedLettersLabel;
    private JLabel remainingGuessesLabel;
    private JLabel themeLabel;
    private JButton[] letterButtons;
    private Set<Character> guessedSet;  // keyboard not disabling guessed letters...see if set can fix  

    public GameScreen(ActionListener inputHandler) {
      setLayout(new BorderLayout());
      
      guessedSet = new HashSet<>();

      // information panel
      JPanel infoPanel = new JPanel();
      infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

      // theme label
      themeLabel = new JLabel("Theme: ");   
      themeLabel.setFont(new Font("Arial", Font.BOLD, 16)); // theme is bolded
      infoPanel.add(themeLabel);
      infoPanel.add(Box.createVerticalStrut(5)); // adds spacing between theme and word (cleaner UI for user)  

      // word label
      wordLabel = new JLabel("Word: ");  
      wordLabel.setFont(new Font("Arial", Font.BOLD, 16));  // bolded
      infoPanel.add(wordLabel);
      infoPanel.add(Box.createVerticalStrut(15));  // adds more space between word and number of guesses left

      // guessed letters label  
      guessedLettersLabel = new JLabel("Guessed Letters: ");  
      guessedLettersLabel.setFont(new Font("Arial", Font.PLAIN, 16));   // no bold 
      infoPanel.add(guessedLettersLabel);

      // remaining guesses label
      remainingGuessesLabel = new JLabel("Remaining Guesses: ");  
      remainingGuessesLabel.setFont(new Font("Arial", Font.PLAIN, 16));  // unbolded text
      infoPanel.add(remainingGuessesLabel);

      // centers info panel
      JPanel infoContainer = new JPanel(new GridBagLayout());
      infoContainer.add(infoPanel); 
      add(infoContainer, BorderLayout.CENTER);  // displayed at center of GUI 

      // hangman drawing panel
      hangmanDrawingPanel = new DrawHangman();
      hangmanDrawingPanel.setPreferredSize(new Dimension(350, 300)); 
      add(hangmanDrawingPanel, BorderLayout.WEST);  // displayed left of GUI 

      // keyboard buttons
      JPanel alphabetPanel = new JPanel(new GridLayout(2, 13, 3, 3)); // sets 2 rows for the keys, 13 columns, and the spacing in between each key
      letterButtons = new JButton[26];  // 26 buttons for each letter 
      for (int i = 0; i < 26; i++) {
          char letter = (char) ('A' + i);
          letterButtons[i] = new JButton(String.valueOf(letter));
          letterButtons[i].setFont(new Font("Arial", Font.BOLD, 14)); // bolds each key
          letterButtons[i].setPreferredSize(new Dimension(40, 40)); // keys are square 
          letterButtons[i].setBackground(Color.LIGHT_GRAY);  // color each key light gray 
          letterButtons[i].addActionListener(inputHandler);
          alphabetPanel.add(letterButtons[i]);
      }
      add(alphabetPanel, BorderLayout.SOUTH);  // displayed at bottom of GUI 
    }

    // updates game screen 
    public void updateDisplay(String word, Set<Character> guessedLetters, int remainingGuesses) {
      // FIXED: error -- test to see if the display is getting updated 
      System.out.println("GameScreen Updated: Word: " + word);  // print "game screen updated" and the word to the console to test functionality 
      wordLabel.setText("Word: " + word);  // updates word 
      guessedLettersLabel.setText("Guessed Letters: " + guessedLetters.toString());  // updates guessed letters 
      remainingGuessesLabel.setText("Remaining Guesses: " + remainingGuesses);  // updates remaining guesses 
      hangmanDrawingPanel.repaint(); // makes sure drawing is repainted to update with incorrect guesses 
    }

    // added to disable guessed letters (fixed!)
    public void disableGuessed(char letter) {
      int index = Character.toUpperCase(letter) - 'A'; 
      if (index >= 0 && index < 26) {
        letterButtons[index].setEnabled(false); 
        guessedSet.add(Character.toUpperCase(letter)); 
      }
    }

    // updates drawing based on the wrong guesses 
    public void updateWrongGuesses(int incorrectGuesses) {
      // FIXED: error -- test if this function is being reached 
      System.out.println("Incorrect guesses: " + incorrectGuesses);  // testing - if function is reached, prints the updated incorrect guesses to terminal 
      hangmanDrawingPanel.setWrongGuesses(incorrectGuesses);
    }

    // resets keyboard buttons after player wins/loses round so they can use all letters to guess next word 
    public void resetKeyboard() {
      for (int i = 0; i < 26; i++) {
        letterButtons[i].setEnabled(true); 
      }
      guessedSet.clear(); 
    }

    // updates the theme for each level 
    public void updateTheme(String theme) {
      themeLabel.setText("Theme: " + theme);
    }
}
