import javax.swing.*;
import java.awt.*;

public class BreakoutTest{
  public static void main(String [] args){
    JFrame app = new JFrame("Breakout_Lauren Pien");
    app.getContentPane().add(new Break());
    
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setSize(900, 800);
    app.setVisible(true);
  }
}
