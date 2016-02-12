/*Main.java
 * 
 * Lauren Pien
 * 
 * CSC171 The Science of Programming
 * 
 * Lab14
 * 
 * Lab TR 11:05-12:20
 * 
 * TA: Shuopeng
 */ 

import javax.swing.JFrame;

public class main{
  public static void main(String [] args){
    JFrame app = new JFrame("Lab14");                    //Creates JFrame to hold Panel
    app.getContentPane().add(new paint());
    
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setSize(400, 400);
    app.setVisible(true);
  }
}
