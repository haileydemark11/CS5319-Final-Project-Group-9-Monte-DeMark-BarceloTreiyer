import javax.swing.JOptionPane;

public class OutputManager {

    protected IntellijUserInterface UI;
    protected EventManager eventManager;

    public OutputManager(IntellijUserInterface UI, EventManager eventManager) {
        this.UI = UI;
        this.eventManager = eventManager;
    }

    public void progressMessage() {
        // Logic to display a message

        // Get the word before updating
        String lastWord = eventManager.gameStateManager.getWordToGuess();

        if(eventManager.gameStateManager.wordManager.isNextLevelUp()){
            // Update so this can have the next category
            String nextWord = eventManager.gameStateManager.nextWord();
            if(nextWord.equals("Game Complete")){
                JOptionPane.showMessageDialog(null, "Congratulations! You won the game!" +
                                                                            "\nhttps://matiasbarcelo.neocities.org/");
                return;
            }

            JOptionPane.showMessageDialog(null, "Level UP! Your word was " + lastWord + "!" +
                                                                        "\nNext category: " + eventManager.gameStateManager.wordManager.getLevelCategory());
            UI.changeHangManImage(eventManager.draw.resetDrawing());
            UI.changeIncorrectGuessesTextDisplay(eventManager.gameStateManager.getRemainingGuesses());
            UI.changeCategoryTextDisplay(eventManager.gameStateManager.wordManager.getLevelCategory());
            UI.changeBigTextDisplay(eventManager.gameStateManager.guess.getGuessWordDisplay());
            UI.resetLetterButtons();
        }
        else{
            // Update so this can have the next category
            String nextWord = eventManager.gameStateManager.nextWord();

            JOptionPane.showMessageDialog(null, "Nice! Your word was " + lastWord + "!");
            UI.changeHangManImage(eventManager.draw.resetDrawing());
            UI.changeIncorrectGuessesTextDisplay(eventManager.gameStateManager.getRemainingGuesses());
            UI.changeBigTextDisplay(eventManager.gameStateManager.guess.getGuessWordDisplay());
            UI.resetLetterButtons();
        }
    }

    public void displayInstructions() {
        // Logic to display instructions
        String instructionMessage = "How to play:\n" +
                "Guess a word that corresponds to the category. If you don't\n" +
                "guess the word before the stick figure is hung, you lose!";

        JOptionPane.showMessageDialog(null, instructionMessage);
    }

    public void displayGameOver() {
        JOptionPane.showMessageDialog(null, "Game Over!\nThe correct word was: " + eventManager.gameStateManager.getWordToGuess());
        eventManager.gameStateManager.initiate();
        UI.changeHangManImage(eventManager.draw.resetDrawing());
        UI.changeIncorrectGuessesTextDisplay(eventManager.gameStateManager.getRemainingGuesses());
        UI.changeCategoryTextDisplay(eventManager.gameStateManager.wordManager.getLevelCategory());
        UI.changeBigTextDisplay(eventManager.gameStateManager.guess.getGuessWordDisplay());
        UI.resetLetterButtons();

    }
}
