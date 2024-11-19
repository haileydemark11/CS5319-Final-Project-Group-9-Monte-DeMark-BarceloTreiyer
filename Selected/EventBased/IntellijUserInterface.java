import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Locale;

public class IntellijUserInterface extends JFrame {
    // All the Swing GUI objects

    private JPanel MainWindow;

    // Letter Design Panel
    private JPanel LetterDesign;

    private JPanel FirstRow;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JButton gButton;
    private JButton hButton;

    private JPanel SecondRow;
    private JButton jButton;
    private JButton kButton;
    private JButton lButton;
    private JButton mButton;
    private JButton nButton;
    private JButton oButton;
    private JButton pButton;
    private JButton qButton;
    private JButton iButton;
    private JButton rButton;

    private JPanel ThirdRow;
    private JButton sButton;
    private JButton tButton;
    private JButton uButton;
    private JButton vButton;
    private JButton wButton;
    private JButton xButton;
    private JButton yButton;
    private JButton zButton;

    // Guess Part of the UI
    private JPanel GuessHolder;
    private JLabel BigText;
    private JLabel CategoryText;
    private JLabel IncorectGuessesText;

    // Hangman Image Part of the UI
    private JPanel HangManHolder;
    private JLabel HangManImage;

    // ActionListener
    protected EventManager manager;

    // Draw object
    protected Draw draw;

    public IntellijUserInterface() {
        setTitle("Hangman - CS 5319 Final Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // This initializes all the fields when straight into java instead of binary, sets it up how I have it in Intellij IDEA UI designer tool
        // $$$setupUI$$$();

        // Initializes the manager
        manager = new EventManager(this);

        // Important to making sure the window is seen
        setContentPane(MainWindow);

        setupButtons();

        setupInitialConditions();

        pack();
    }

    private void setupButtons() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            try {
                // Construct the variable name, e.g., "aButton"
                String fieldName = letter + "Button";

                // Access the field by name from the class
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                // Get the JButton object and set its ActionCommand to the letter, as well as adding listener
                JButton button = (JButton) field.get(this);
                button.setActionCommand(String.valueOf(letter));
                button.addActionListener(manager);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void setupInitialConditions() {
        manager.outputManager.displayInstructions();

        // set first guess word
        String word = manager.gameStateManager.guess.getGuessWordDisplay();
        BigText.setText(word);

        // set first Category
        CategoryText.setText("Category: " + manager.gameStateManager.wordManager.getLevelCategory());

        // no strikes at beginnning
        IncorectGuessesText.setText("Incorect Guesses: 0/6");

        // picture 0 of hangman
        HangManImage.setIcon(new ImageIcon(manager.draw.resetDrawing()));
    }

    protected void disableLetterButton(char theLetter) {
        try {
            // Construct the variable name, e.g., "aButton"
            String fieldName = theLetter + "Button";

            // Access the field by name from the class
            Field field = this.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            // disable that button
            JButton button = (JButton) field.get(this);
            button.setEnabled(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Handle case where the field doesn't exist, or cannot be accessed
            e.printStackTrace();
        }
    }

    protected void resetLetterButtons() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            try {
                // Construct the variable name, e.g., "aButton"
                String fieldName = letter + "Button";

                // Access the field by name from the class
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                // Re-enables each button
                JButton button = (JButton) field.get(this);
                button.setEnabled(true);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    protected void changeBigTextDisplay(String word) {
        BigText.setText(word);
    }

    protected void changeCategoryTextDisplay(String category) {
        CategoryText.setText("Category: " + category);
    }

    protected void changeIncorrectGuessesTextDisplay(int remainingGuesses) {
        int amountOfGuessesLeft = 6 - remainingGuesses;
        IncorectGuessesText.setText("Incorect Guesses: " + Integer.toString(amountOfGuessesLeft) + "/" + Integer.toString(6));
    }

    protected void changeHangManImage(URL hangmanImage) {
        HangManImage.setIcon(new ImageIcon(hangmanImage));
    }

    public static void main(String[] args) {
        IntellijUserInterface frame = new IntellijUserInterface();
        frame.setVisible(true);
    }

}