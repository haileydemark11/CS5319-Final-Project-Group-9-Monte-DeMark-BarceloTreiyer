//import java.awt.FlowLayout;
//import javax.swing.*;
//import java.awt.GridLayout;
//import java.awt.BorderLayout;
//import java.awt.Font;
//
//public class UserInterface extends JFrame{
//    public static final String[] ALPHABET = {
//        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
//        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
//    };
//
//    private JLabel hangManImage;
//    private JLabel guesserLabel;
//    private JPanel buttonPanel;
//    GameStateManager GameState;
//    OutputManager Output;
//
//    public UserInterface() {
//        // names the window
//        super("Hangman - CS 5319");
//
//        // sets window size
//        setSize(300, 200);
//
//        // makes sure clicking x closes the application
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Create Objects
//        GameState = new GameStateManager();
//        Output = new OutputManager(this);
//
//        // Creates action listener
//        EventListener listener = new EventListener(this);
//
//        // Create the Hangman image
//        hangManImage = new JLabel();
//
//        // Create the guesser label
//        String firstWord = GameState.guess.getGuessWordDisplay();
//        guesserLabel = new JLabel(firstWord);
//        guesserLabel.setFont(new Font("Arial", Font.PLAIN, 24));
//
//        // Creates a panel of alphabet buttons
//        buttonPanel = new JPanel();
//
//        // Makes a grid
//        buttonPanel.setLayout(new GridLayout(4, 7, 5, 5));
//
//        // creates buttons for each letter in alphabet
//        for (String letter : ALPHABET) {
//            JButton button = new JButton(letter);
//            button.setActionCommand(letter);
//            button.addActionListener(listener);
//            buttonPanel.add(button);
//        }
//
//        add(guesserLabel, BorderLayout.LINE_END);
//        add(buttonPanel, BorderLayout.LINE_END);
//        Output.displayInstructions();
//    }
//}
