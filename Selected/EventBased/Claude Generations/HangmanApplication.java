import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangmanApplication extends JFrame implements ActionListener {
    private static final String[] WORDS = {
        "APPLE", "BANANA", "CHERRY", "DRAGONFRUIT", "ELDERBERRY",
        "FIG", "GRAPEFRUIT", "HONEYDEW", "KIWI", "LEMON",
        "MANGO", "NECTARINE", "ORANGE", "PAPAYA", "QUINCE",
        "RASPBERRY", "STRAWBERRY", "TANGERINE", "WATERMELON"
    };

    private static final int MAX_GUESSES = 6;

    private String word;
    private List<Character> guessedLetters;
    private int remainingGuesses;
    private JLabel wordLabel;
    private JLabel guessesLabel;
    private JPanel buttonPanel;

    public HangmanApplication() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hangman");
        setLayout(new BorderLayout());

        wordLabel = new JLabel();
        wordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(wordLabel, BorderLayout.NORTH);

        guessesLabel = new JLabel();
        guessesLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        guessesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(guessesLabel, BorderLayout.SOUTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 7, 5, 5));
        String[] alphabet = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        for (String letter : alphabet) {
            JButton button = new JButton(letter);
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);

        startNewGame();
        pack();
        setLocationRelativeTo(null);
    }

    private void startNewGame() {
        word = getRandomWord();
        guessedLetters = new ArrayList<>();
        remainingGuesses = MAX_GUESSES;
        updateWordLabel();
        updateGuessesLabel();
        enableButtons();
    }

    private String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);
        return WORDS[index];
    }

    private void updateWordLabel() {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guessedLetters.contains(c)) {
                sb.append(c);
            } else {
                sb.append("_");
            }
            sb.append(" ");
        }
        wordLabel.setText(sb.toString());
    }

    private void updateGuessesLabel() {
        guessesLabel.setText("Remaining Guesses: " + remainingGuesses);
    }

    private void enableButtons() {
        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(true);
            }
        }
    }

    private void disableButtons() {
        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                component.setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String letter = button.getText();
        button.setEnabled(false);

        if (word.contains(letter)) {
            guessedLetters.add(letter.charAt(0));
            updateWordLabel();
            if (word.equals(wordLabel.getText().replace(" ", ""))) {
                JOptionPane.showMessageDialog(this, "Congratulations! You won!");
                startNewGame();
            }
        } else {
            remainingGuesses--;
            updateGuessesLabel();
            if (remainingGuesses == 0) {
                JOptionPane.showMessageDialog(this, "Game Over! The word was: " + word);
                startNewGame();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HangmanApplication game = new HangmanApplication();
            game.setVisible(true);
        });
    }
}