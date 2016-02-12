import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class paint extends JPanel{
  
  private static Color PURPLE = new Color(128, 0, 128);
  private Color [] colors = {Color.WHITE, Color.BLUE, Color.GREEN, Color.CYAN, PURPLE};
  private Color fillColor;
  private final int move = 5;     //increment for shape movement
  private int x, y, i;

  //Constructor
  public paint(){
    setBackground(Color.YELLOW);     //Sets background color
    addKeyListener (new Listener());
    x = 150;
    y = 150;
    i = 0;             
    fillColor = colors[i];           //fills shape with colors inside array
    setFocusable(true);
  }

  //paintComponent method draws image
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(fillColor);
    g.fillRect(x, y, 60, 60);
  }
  
  //private class represents listener for keyboard using 'implements KeyListener'
  private class Listener implements KeyListener{
    public void keyPressed(KeyEvent event){
      switch (event.getKeyCode()){
        case KeyEvent.VK_RIGHT:
          x = x + move;
          break;
        case KeyEvent.VK_LEFT:
          x = x - move;
          break;
        case KeyEvent.VK_UP:
          y = y - move;
          break;
        case KeyEvent.VK_DOWN:
          y = y + move;
          break;
      }
      int ent = event.getKeyCode();
      if(ent == KeyEvent.VK_ENTER){
        i++;
        if(i == 5){
          i = 0;
        }
        fillColor = colors[i];
      }
      repaint();
    }
    public void keyTyped (KeyEvent event){}
    public void keyReleased (KeyEvent event) {}
  }
}
