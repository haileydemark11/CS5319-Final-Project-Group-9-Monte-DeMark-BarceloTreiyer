import java.awt.*;  // graphics and graphics 2D classes for UI 
import javax.swing.*;  // swing containers for UI 

// JPanel allows for drawing 
public class DrawHangman extends JPanel {
  private int wrongGuesses;

  // DrawHangman constructor 
  public DrawHangman() {
    this.wrongGuesses = 0; 
  }

  public void setWrongGuesses(int incorrectGuesses) {
    this.wrongGuesses = incorrectGuesses;
    repaint(); // redraws panel with updated guesses
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);  // clears previous panel content 
    // test output to check if function is being reached 
    System.out.println("Redrawing hangman for " + wrongGuesses + " incorrect guesses.");  // testing: outputs to the console 
    Graphics2D g2d = (Graphics2D) g;

    // center drawing based on panel size 
    int panelWidth = getWidth();
    int panelHeight = getHeight();

    // x and y dimensions for the drawing - set to the left hand side
    int baseX = panelWidth / 2 - 75; 
    int baseY = panelHeight / 2 - 100; 

    g2d.setStroke(new BasicStroke(3));  // sets the gallow and hangman structures to be bold (thicker stroke looks darker)

    // draws the gallow for the hangman 
    g2d.drawLine(baseX, baseY + 200, baseX + 100, baseY + 200); // line for the floor 
    g2d.drawLine(baseX + 50, baseY + 200, baseX + 50, baseY);   // line for the pole 
    g2d.drawLine(baseX + 50, baseY, baseX + 100, baseY);        // line for the top 
    g2d.drawLine(baseX + 100, baseY, baseX + 100, baseY + 40);  // line representing rope 

    // draws hangman body in order for incorrect guesses 
    if (wrongGuesses >= 1) g2d.drawOval(baseX + 90, baseY + 40, 20, 20); // head drawn - first wrong guess 
    if (wrongGuesses >= 2) g2d.drawLine(baseX + 100, baseY + 60, baseX + 100, baseY + 120); // body drawn - second wrong guess 
    if (wrongGuesses >= 3) g2d.drawLine(baseX + 100, baseY + 80, baseX + 110, baseY + 100); // right arm drawn - third wrong guess 
    if (wrongGuesses >= 4) g2d.drawLine(baseX + 100, baseY + 80, baseX + 90, baseY + 100);  // left arm drawn - fourth wrong guess 
    if (wrongGuesses >= 5) g2d.drawLine(baseX + 100, baseY + 120, baseX + 110, baseY + 140); // right leg drawn = fifth wrong guess 
    if (wrongGuesses >= 6) g2d.drawLine(baseX + 100, baseY + 120, baseX + 90, baseY + 140);  // left leg drawn - sixth wrong guess 
  }
}
