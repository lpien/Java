import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Break extends JPanel{                       
  
  //General variables
  private final int panWidth = 900, panHeight = 800;
  private final int DELAY = 15;
  private final int size = 35;
  
  //Variables for bouncing ball
  private final int rad = 10;                 //Radius
  private int speedX = 4;                     //Speed along x-axis
  private int speedY = 3;                     //Speed along y-axis
  private int xBall;
  private int yBall;
  Point ballPosition;
  
  //initializing variables for paddle
  private int x, paddleW, paddleH, paddleX, paddleY;
  private int movePaddle;
  private Timer timer;
  Point restart;
  private Color DARKBLUE = new Color(54, 61, 138);
  private int pointPaddleX, pointPaddleY;
  
  //Variables for bricks
  private Color PURPLE = new Color(210, 109, 247);
  private int xPoint, yPoint;                             //x and y coordinate of brick
  private int brickW, brickH;                             //width and height variables of bricks
  private int i;
  private int p1y, p2y, p3y, p4y, p5y, p6y, p7y, p8y, p9y, p10y, p11y, p12y, p13y, p1x, p2x, p3x, p4x, p5x, p6x, p7x, p8x, p9x, p10x, p11x, p12x, p13x;
  private int g1y, g2y, g3y, g4y, g5y, g6y, g7y, g8y, g9y, g10y, g11y, g12y, g13y, g1x, g2x, g3x, g4x, g5x, g6x, g7x, g8x, g9x, g10x, g11x, g12x, g13x;
  private int y1y, y2y, y3y, y4y, y5y, y6y, y7y, y8y, y9y, y10y, y11y, y12y, y13y, y1x, y2x, y3x, y4x, y5x, y6x, y7x, y8x, y9x, y10x, y11x, y12x, y13x;
  private int r1y, r2y, r3y, r4y, r5y, r6y, r7y, r8y, r9y, r10y, r11y, r12y, r13y, r1x, r2x, r3x, r4x, r5x, r6x, r7x, r8x, r9x, r10x, r11x, r12x, r13x;
  
  public int score;
  public int lives;
  
  //Constructor
  public Break(){                                          
    timer = new Timer (DELAY, new Listener());
    
    lives = 3;
    
    paddleW = 75;    //paddle width
    paddleH = 15;    //paddle height
    x = 37;
    movePaddle = 40;
    paddleY = 650;
    restart = new Point(365, 628);     //placement of paddle
    
    //Brick variables
    brickW = 60;                  //Constant for brick width and height
    brickH = 20;
    
    //Purple brick variables
    p1x = 5;p2x = 73;p3x = 141;p4x = 209; p5x = 277;  p6x = 345;p7x = 413;p8x = 481;p9x = 549;p10x = 617;p11x = 685;p12x = 753;p13x = 821;
    p1y = 150;p2y = 150;p3y = 150;p4y = 150;p5y = 150;p6y = 150;p7y = 150;p8y = 150;p9y = 150;p10y = 150;p11y = 150;p12y = 150;p13y = 150;
    
    //Green brick variables
    g1x = 5;g2x = 73;g3x = 141;g4x = 209; g5x = 277;  g6x = 345;g7x = 413;g8x = 481;g9x = 549;g10x = 617;g11x = 685;g12x = 753;g13x = 821;
    g1y = 125;g2y = 125;g3y = 125;g4y = 125;g5y = 125;g6y = 125;g7y = 125;g8y = 125;g9y = 125;g10y = 125;g11y = 125;g12y = 125;g13y = 125;
    
    //Yellow brick variables
    y1x = 5;y2x = 73;y3x = 141;y4x = 209; y5x = 277;y6x = 345;y7x = 413;y8x = 481;y9x = 549;y10x = 617;y11x = 685;y12x = 753;y13x = 821;
    y1y = 100;y2y = 100;y3y = 100;y4y = 100;y5y = 100;y6y = 100;y7y = 100;y8y = 100;y9y = 100;y10y = 100;y11y = 100;y12y = 100;y13y = 100;
    
    //Red brick variables
    r1x = 5;r2x = 73;r3x = 141;r4x = 209; r5x = 277;r6x = 345;r7x = 413;r8x = 481;r9x = 549;r10x = 617;r11x = 685;r12x = 753;r13x = 821;
    r1y = 75;r2y = 75;r3y = 75;r4y = 75;r5y = 75;r6y = 75;r7y = 75;r8y = 75;r9y = 75;r10y = 75;r11y = 75;r12y = 75;r13y = 75;
    
    PaddleListener a = new PaddleListener();
    addKeyListener(a);
    setBackground(DARKBLUE);
    setPreferredSize(new Dimension(panWidth, panHeight));
    setFocusable(true);
    timer.start();
    
    //X and Y coordinates for beginning point of ball
    xBall = 20;
    yBall = 200;
  }
  
  public void paintComponent (Graphics g){              
    super.paintComponent(g);
    
    //Displays name, lives, score
    g.setFont(new Font(null, Font.PLAIN, 18));
    g.drawString("Score: " + score, 750, 725);
    g.drawString("Lives: " + lives, 675, 725);
    g.drawString("Lauren Pien, CSC171 The Science of Programming", 5, 725);

    //Color, dimensions, and position of paddle
    g.setColor(Color.GREEN);
    
    //Boundaries of paddle inside panel
    if(restart.x < 0){restart.x = 0;}
    if(restart.x >= 825){restart.x = 825;}
    g.fillRect(restart.x, paddleY, paddleW, paddleH);   //fills paddle so it moves at 650 on y-coordinate

    //Color, dimensions, and position of ball
    g.setColor(Color.RED);
    xBall = xBall + speedX;
    yBall = yBall + speedY;
    int xBallPos = xBall + rad;
    int yBallPos = yBall + rad;
    ballPosition = new Point(xBallPos, yBallPos);
    
    //Boundaries of ball inside panel
    if(xBall + rad >= panWidth - 30 || xBall + rad <= 1){speedX = -speedX;}       //Right and left side of panel
    if(yBall + rad <= 1){speedY = -speedY;}                                       //Top of panel
    
    if(yBall + rad >= panHeight - 20){                                            //Ball will restart unless all lives are lost
      timer.stop();                                                              //If all lives gone, 'GAME OVER' will appear
      lives--;                                                                    //And user will receive final score and enter name
      xBall = 20; yBall = 200; 
      timer.start();
      if(lives == 0){
        g.drawString("GAME OVER", 400, 400);
        timer.stop();
        String in;
        in = JOptionPane.showInputDialog("Your score is " + score + ". Enter name: ");
      }
    }          
    
    //Bounce ball off paddle
    if(ballPosition.x >= restart.x && ballPosition.x <= restart.x + 75 && ballPosition.y >= restart.y && ballPosition.y <= restart.y + 25){
      speedY = -speedY; 
    }
    g.fillOval((int)(xBallPos), (int)(yBallPos), (int)(2 * rad), (int)(2 * rad));      //Creates + fills circle
    
    //Creates colored bricks
    //Purple bricks ---------------------------------------------------------------------------------------
    Point p1 = new Point(p1x, p1y);
    g.setColor(PURPLE);
    g.fillRect(p1x, p1y, brickW, brickH);
    if(ballPosition.x >= p1.x && ballPosition.x <= p1.x + 60 && ballPosition.y >= p1.y && ballPosition.y <= p1.y + 20){
      speedY = -speedY;
      p1 = new Point (1000,1000);
      p1x = 1000;
      p1y = 1000;
      score += 5;
    }
    g.fillRect(p2x, p2y, brickW, brickH);
    Point p2 = new Point(p2x, p2y);
    if(ballPosition.x >= p2.x && ballPosition.x <= p2.x + 60 && ballPosition.y >= p2.y && ballPosition.y <= p2.y + 20){
      speedY = -speedY;
      p2 = new Point (1000,1000);
      p2x = 1000;
      p2y = 1000;
      score += 5;
    }
    g.fillRect(p3x, p3y, brickW, brickH);
    Point p3 = new Point(p3x, p3y);
    if(ballPosition.x >= p3.x && ballPosition.x <= p3.x + 60 && ballPosition.y >= p3.y && ballPosition.y <= p3.y + 20){
      speedY = -speedY;
      p3 = new Point(1000,1000);
      p3x = 1000;
      p3y = 1000;
      score += 5;
    }
    g.fillRect(p4x, p4y, brickW, brickH);
    Point p4 = new Point(p4x, p4y);
    if(ballPosition.x >= p4.x && ballPosition.x <= p4.x + 60 && ballPosition.y >= p4.y && ballPosition.y <= p4.y + 20){
      speedY = -speedY;
      p4 = new Point(1000,1000);
      p4x = 1000;
      p4y = 1000;
      score += 5;
    }
    g.fillRect(p5x, p5y, brickW, brickH);
    Point p5 = new Point(p5x, p5y);
    if(ballPosition.x >= p5.x && ballPosition.x <= p5.x + 60 && ballPosition.y >= p5.y && ballPosition.y <= p5.y + 20){
      speedY = -speedY;
      p5 = new Point(1000,000);
      p5x = 1000;
      p5y = 1000;
      score += 5;
      System.out.println("Score: " +score);
    }
    g.fillRect(p6x, p6y, brickW, brickH);
    Point p6 = new Point(p6x, p6y);
    if(ballPosition.x >= p6.x && ballPosition.x <= p6.x + 60 && ballPosition.y >= p6.y && ballPosition.y <= p6.y + 20){
      speedY = -speedY;
      p6 = new Point(1000,1000);
      p6x = 1000;
      p6y = 1000;
      score += 5;
      System.out.println("Score: " +score);
    }
    g.fillRect(p7x, p7y, brickW, brickH);
    Point p7 = new Point(p7x, p7y);
    if(ballPosition.x >= p7.x && ballPosition.x <= p7.x + 60 && ballPosition.y >= p7.y && ballPosition.y <= p7.y + 20){
      speedY = -speedY;
      p7 = new Point(1000,1000);
      p7x = 1000;
      p7y = 1000;
      score += 5;
      System.out.println("Score: " + score);
    }
    g.fillRect(p8x, p8y, brickW, brickH);
    Point p8 = new Point(p8x, p8y);
    if(ballPosition.x >= p8.x && ballPosition.x <= p8.x + 60 && ballPosition.y >= p8.y && ballPosition.y <= p8.y + 20){
      speedY = -speedY;
      p8 = new Point(1000,1000);
      p8x = 1000;
      p8y = 1000;
      score += 5;
      System.out.println("Score: " + score);
    }
    g.fillRect(p9x, p9y, brickW, brickH);
    Point p9 = new Point(p9x, p9y);
    if(ballPosition.x >= p9.x && ballPosition.x <= p9.x + 60 && ballPosition.y >= p9.y && ballPosition.y <= p9.y + 20){
      speedY = -speedY;
      p9 = new Point(1000,1000);
      p9x = 1000;
      p9y = 1000;
      score += 5;
      System.out.println("Score: " +score);
    }
    g.fillRect(p10x, p10y, brickW, brickH);
    Point p10 = new Point(p10x, p10y);
    if(ballPosition.x >= p10.x && ballPosition.x <= p10.x + 60 && ballPosition.y >= p10.y && ballPosition.y <= p10.y + 20){
      speedY = -speedY;
      p10 = new Point(1000,1000);
      p10x = 1000;
      p10y = 1000;
      score += 5;
      System.out.println("Score: " +score);
    }
    g.fillRect(p11x, p11y, brickW, brickH);
    Point p11 = new Point(p11x, p11y);
    if(ballPosition.x >= p11.x && ballPosition.x <= p11.x + 60 && ballPosition.y >= p11.y && ballPosition.y <= p11.y + 20){
      speedY = -speedY;
      p11 = new Point(1000,1000);
      p11x = 1000;
      p11y = 1000;
      score += 5;
      System.out.println("Score: " +score);
    }
    g.fillRect(p12x, p12y, brickW, brickH);
    Point p12 = new Point(p12x, p12y);
    if(ballPosition.x >= p12.x && ballPosition.x <= p12.x + 60 && ballPosition.y >= p12.y && ballPosition.y <= p12.y + 20){
      speedY = -speedY;
      p12 = new Point(1000,1000);
      p12x = 1000;
      p12y = 1000;
      score += 5;
      System.out.println("Score: " +score);
    }
    g.fillRect(p13x, p13y, brickW, brickH);
    Point p13 = new Point(p13x, p13y);
    if(ballPosition.x >= p13.x && ballPosition.x <= p13.x + 60 && ballPosition.y >= p13.y && ballPosition.y <= p13.y + 20){
      speedY = -speedY;
      p13 = new Point(1000,1000);
      p13x = 1000;
      p13y = 1000;
      score += 5;
    }
    //Green bricks ----------------------------------------------------------------------------------------------------
    Point g1 = new Point(g1x, g1y);
    g.setColor(Color.GREEN);
    g.fillRect(g1x, g1y, brickW, brickH);
    if(ballPosition.x >= g1.x && ballPosition.x <= g1.x + 60 && ballPosition.y >= g1.y && ballPosition.y <= g1.y + 20){
      speedY = -speedY;
      g1 = new Point (1000,1000);
      g1x = 1000;
      g1y = 1000;
      score += 5;
    }
    Point g2 = new Point(g2x, g2y);
    g.setColor(Color.GREEN);
    g.fillRect(g2x, g2y, brickW, brickH);
    if(ballPosition.x >= g2.x && ballPosition.x <= g2.x + 60 && ballPosition.y >= g2.y && ballPosition.y <= g2.y + 20){
      speedY = -speedY;
      g2 = new Point (1000,1000);
      g2x = 1000;
      g2y = 1000;
      score += 5;
    }
    Point g3 = new Point(g3x, g3y);
    g.setColor(Color.GREEN);
    g.fillRect(g3x, g3y, brickW, brickH);
    if(ballPosition.x >= g3.x && ballPosition.x <= g3.x + 60 && ballPosition.y >= g3.y && ballPosition.y <= g3.y + 20){
      speedY = -speedY;
      g3 = new Point (1000,1000);
      g3x = 1000;
      g3y = 1000;
      score += 5;
    }
    Point g4 = new Point(g4x, g4y);
    g.setColor(Color.GREEN);
    g.fillRect(g4x, g4y, brickW, brickH);
    if(ballPosition.x >= g4.x && ballPosition.x <= g4.x + 60 && ballPosition.y >= g4.y && ballPosition.y <= g4.y + 20){
      speedY = -speedY;
      g4 = new Point (1000,1000);
      g4x = 1000;
      g4y = 1000;
      score += 5;
    }
    Point g5 = new Point(g5x, g5y);
    g.setColor(Color.GREEN);
    g.fillRect(g5x, g5y, brickW, brickH);
    if(ballPosition.x >= g5.x && ballPosition.x <= g5.x + 60 && ballPosition.y >= g5.y && ballPosition.y <= g5.y + 20){
      speedY = -speedY;
      g5 = new Point (1000,1000);
      g5x = 1000;
      g5y = 1000;
      score += 5;
    }
    Point g6 = new Point(g6x, g6y);
    g.setColor(Color.GREEN);
    g.fillRect(g6x, g6y, brickW, brickH);
    if(ballPosition.x >= g6.x && ballPosition.x <= g6.x + 60 && ballPosition.y >= g6.y && ballPosition.y <= g6.y + 20){
      speedY = -speedY;
      g6 = new Point (1000,1000);
      g6x = 1000;
      g6y = 1000;
      score += 5;
    }
    Point g7 = new Point(g7x, g7y);
    g.setColor(Color.GREEN);
    g.fillRect(g7x, g7y, brickW, brickH);
    if(ballPosition.x >= g7.x && ballPosition.x <= g7.x + 60 && ballPosition.y >= g7.y && ballPosition.y <= g7.y + 20){
      speedY = -speedY;
      g7 = new Point (1000,1000);
      g7x = 1000;
      g7y = 1000;
      score += 5;
    }
    Point g8 = new Point(g8x, g8y);
    g.setColor(Color.GREEN);
    g.fillRect(g8x, g8y, brickW, brickH);
    if(ballPosition.x >= g8.x && ballPosition.x <= g8.x + 60 && ballPosition.y >= g8.y && ballPosition.y <= g8.y + 20){
      speedY = -speedY;
      g8 = new Point (1000,1000);
      g8x = 1000;
      g8y = 1000;
      score += 5;
    }
    Point g9 = new Point(g9x, g9y);
    g.setColor(Color.GREEN);
    g.fillRect(g9x, g9y, brickW, brickH);
    if(ballPosition.x >= g9.x && ballPosition.x <= g9.x + 60 && ballPosition.y >= g9.y && ballPosition.y <= g9.y + 20){
      speedY = -speedY;
      g9 = new Point (1000,1000);
      g9x = 1000;
      g9y = 1000;
      score += 5;
    }
    Point g10 = new Point(g10x, g10y);
    g.setColor(Color.GREEN);
    g.fillRect(g10x, g10y, brickW, brickH);
    if(ballPosition.x >= g10.x && ballPosition.x <= g10.x + 60 && ballPosition.y >= g10.y && ballPosition.y <= g10.y + 20){
      speedY = -speedY;
      g10 = new Point (1000,1000);
      g10x = 1000;
      g10y = 1000;
      score += 5;
    }
    Point g11 = new Point(g11x, g11y);
    g.setColor(Color.GREEN);
    g.fillRect(g11x, g11y, brickW, brickH);
    if(ballPosition.x >= g11.x && ballPosition.x <= g11.x + 60 && ballPosition.y >= g11.y && ballPosition.y <= g11.y + 20){
      speedY = -speedY;
      g11 = new Point (1000,1000);
      g11x = 1000;
      g11y = 1000;
      score += 5;
    }
    Point g12 = new Point(g12x, g12y);
    g.setColor(Color.GREEN);
    g.fillRect(g12x, g12y, brickW, brickH);
    if(ballPosition.x >= g12.x && ballPosition.x <= g12.x + 60 && ballPosition.y >= g12.y && ballPosition.y <= g12.y + 20){
      speedY = -speedY;
      g12 = new Point (1000,1000);
      g12x = 1000;
      g12y = 1000;
      score += 5;
    }
    Point g13 = new Point(g13x, g13y);
    g.setColor(Color.GREEN);
    g.fillRect(g13x, g13y, brickW, brickH);
    if(ballPosition.x >= g13.x && ballPosition.x <= g13.x + 60 && ballPosition.y >= g13.y && ballPosition.y <= g13.y + 20){
      speedY = -speedY;
      g13 = new Point (1000,1000);
      g13x = 1000;
      g13y = 1000;
      score += 5;
    }
    //Yellow bricks-------------------------------------------------------------------------------------------------------
    Point y1 = new Point(y1x, y1y);
    g.setColor(Color.YELLOW);
    g.fillRect(y1x, y1y, brickW, brickH);
    if(ballPosition.x >= y1.x && ballPosition.x <= y1.x + 60 && ballPosition.y >= y1.y && ballPosition.y <= y1.y + 20){
      speedY = -speedY;
      y1 = new Point (1000,1000);
      y1x = 1000;
      y1y = 1000;
      score += 5;
    }
    Point y2 = new Point(y2x, y2y);
    g.setColor(Color.YELLOW);
    g.fillRect(y2x, y2y, brickW, brickH);
    if(ballPosition.x >= y2.x && ballPosition.x <= y2.x + 60 && ballPosition.y >= y2.y && ballPosition.y <= y2.y + 20){
      speedY = -speedY;
      y2 = new Point (1000,1000);
      y2x = 1000;
      y2y = 1000;
      score += 5;
    }
    Point y3 = new Point(y3x, y3y);
    g.setColor(Color.YELLOW);
    g.fillRect(y3x, y3y, brickW, brickH);
    if(ballPosition.x >= y3.x && ballPosition.x <= y3.x + 60 && ballPosition.y >= y3.y && ballPosition.y <= y3.y + 20){
      speedY = -speedY;
      y3 = new Point (1000,1000);
      y3x = 1000;
      y3y = 1000;
      score += 5;
    }
    Point y4 = new Point(y4x, y4y);
    g.setColor(Color.YELLOW);
    g.fillRect(y4x, y4y, brickW, brickH);
    if(ballPosition.x >= y4.x && ballPosition.x <= y4.x + 60 && ballPosition.y >= y4.y && ballPosition.y <= y4.y + 20){
      speedY = -speedY;
      y4 = new Point (1000,1000);
      y4x = 1000;
      y4y = 1000;
      score += 5;
    }
    Point y5 = new Point(y5x, y5y);
    g.setColor(Color.YELLOW);
    g.fillRect(y5x, y5y, brickW, brickH);
    if(ballPosition.x >= y5.x && ballPosition.x <= y5.x + 60 && ballPosition.y >= y5.y && ballPosition.y <= y5.y + 20){
      speedY = -speedY;
      y5 = new Point (1000,1000);
      y5x = 1000;
      y5y = 1000;
      score += 5;
    }
    Point y6 = new Point(y6x, y6y);
    g.setColor(Color.YELLOW);
    g.fillRect(y6x, y6y, brickW, brickH);
    if(ballPosition.x >= y6.x && ballPosition.x <= y6.x + 60 && ballPosition.y >= y6.y && ballPosition.y <= y6.y + 20){
      speedY = -speedY;
      y6 = new Point (1000,1000);
      y6x = 1000;
      y6y = 1000;
      score += 5;
    }
    Point y7 = new Point(y7x, y7y);
    g.setColor(Color.YELLOW);
    g.fillRect(y7x, y7y, brickW, brickH);
    if(ballPosition.x >= y7.x && ballPosition.x <= y7.x + 60 && ballPosition.y >= y7.y && ballPosition.y <= y7.y + 20){
      speedY = -speedY;
      y7 = new Point (1000,1000);
      y7x = 1000;
      y7y = 1000;
      score += 5;
    }
    Point y8 = new Point(y8x, y8y);
    g.setColor(Color.YELLOW);
    g.fillRect(y8x, y8y, brickW, brickH);
    if(ballPosition.x >= y8.x && ballPosition.x <= y8.x + 60 && ballPosition.y >= y8.y && ballPosition.y <= y8.y + 20){
      speedY = -speedY;
      y8 = new Point (1000,1000);
      y8x = 1000;
      y8y = 1000;
      score += 5;
    }
    Point y9 = new Point(y9x, y9y);
    g.setColor(Color.YELLOW);
    g.fillRect(y9x, y9y, brickW, brickH);
    if(ballPosition.x >= y9.x && ballPosition.x <= y9.x + 60 && ballPosition.y >= y9.y && ballPosition.y <= y9.y + 20){
      speedY = -speedY;
      y9 = new Point (1000,1000);
      y9x = 1000;
      y9y = 1000;
      score += 5;
    }
    Point y10 = new Point(y10x, y10y);
    g.setColor(Color.YELLOW);
    g.fillRect(y10x, y10y, brickW, brickH);
    if(ballPosition.x >= y10.x && ballPosition.x <= y10.x + 60 && ballPosition.y >= y10.y && ballPosition.y <= y10.y + 20){
      speedY = -speedY;
      y10 = new Point (1000,1000);
      y10x = 1000;
      y10y = 1000;
      score += 5;
    }
    Point y11 = new Point(y11x, y11y);
    g.setColor(Color.YELLOW);
    g.fillRect(y11x, y11y, brickW, brickH);
    if(ballPosition.x >= y11.x && ballPosition.x <= y11.x + 60 && ballPosition.y >= y11.y && ballPosition.y <= y11.y + 20){
      speedY = -speedY;
      y11 = new Point (1000,1000);
      y11x = 1000;
      y11y = 1000;
      score += 5;
    }
    Point y12 = new Point(y12x, y12y);
    g.setColor(Color.YELLOW);
    g.fillRect(y12x, y12y, brickW, brickH);
    if(ballPosition.x >= y12.x && ballPosition.x <= y12.x + 60 && ballPosition.y >= y12.y && ballPosition.y <= y12.y + 20){
      speedY = -speedY;
      y12 = new Point (1000,1000);
      y12x = 1000;
      y12y = 1000;
      score += 5;
    }
    Point y13 = new Point(y13x, y13y);
    g.setColor(Color.YELLOW);
    g.fillRect(y13x, y13y, brickW, brickH);
    if(ballPosition.x >= y13.x && ballPosition.x <= y13.x + 60 && ballPosition.y >= y13.y && ballPosition.y <= y13.y + 20){
      speedY = -speedY;
      y13 = new Point (1000,1000);
      y13x = 1000;
      y13y = 1000;
      score += 5;
    }
    //Red bricks----------------------------------------------------------------------------------------------------------
    Point r1 = new Point(r1x, r1y);
    g.setColor(Color.RED);
    g.fillRect(r1x, r1y, brickW, brickH);
    if(ballPosition.x >= r1.x && ballPosition.x <= r1.x + 60 && ballPosition.y >= r1.y && ballPosition.y <= r1.y + 20){
      speedY = -speedY;
      r1 = new Point (1000,1000);
      r1x = 1000;
      r1y = 1000;
      score += 5;
    }
    Point r2 = new Point(r2x, r2y);
    g.setColor(Color.RED);
    g.fillRect(r2x, r2y, brickW, brickH);
    if(ballPosition.x >= r2.x && ballPosition.x <= r2.x + 60 && ballPosition.y >= r2.y && ballPosition.y <= r2.y + 20){
      speedY = -speedY;
      r2 = new Point (1000,1000);
      r2x = 1000;
      r2y = 1000;
      score += 5;
    }
    Point r3 = new Point(r3x, r3y);
    g.setColor(Color.RED);
    g.fillRect(r3x, r3y, brickW, brickH);
    if(ballPosition.x >= r3.x && ballPosition.x <= r3.x + 60 && ballPosition.y >= r3.y && ballPosition.y <= r3.y + 20){
      speedY = -speedY;
      r3 = new Point (1000,1000);
      r3x = 1000;
      r3y = 1000;
      score += 5;
    }
    Point r4 = new Point(r4x, r4y);
    g.setColor(Color.RED);
    g.fillRect(r4x, r4y, brickW, brickH);
    if(ballPosition.x >= r4.x && ballPosition.x <= r4.x + 60 && ballPosition.y >= r4.y && ballPosition.y <= r4.y + 20){
      speedY = -speedY;
      r4 = new Point (1000,1000);
      r4x = 1000;
      r4y = 1000;
      score += 5;
    }
    Point r5 = new Point(r5x, r5y);
    g.setColor(Color.RED);
    g.fillRect(r5x, r5y, brickW, brickH);
    if(ballPosition.x >= r5.x && ballPosition.x <= r5.x + 60 && ballPosition.y >= r5.y && ballPosition.y <= r5.y + 20){
      speedY = -speedY;
      r5 = new Point (1000,1000);
      r5x = 1000;
      r5y = 1000;
      score += 5;
    }
    Point r6 = new Point(r1x, r1y);
    g.setColor(Color.RED);
    g.fillRect(r6x, r6y, brickW, brickH);
    if(ballPosition.x >= r6.x && ballPosition.x <= r6.x + 60 && ballPosition.y >= r6.y && ballPosition.y <= r6.y + 20){
      speedY = -speedY;
      r6 = new Point (1000,1000);
      r6x = 1000;
      r6y = 1000;
      score += 5;
    }
    Point r7 = new Point(r7x, r7y);
    g.setColor(Color.RED);
    g.fillRect(r7x, r7y, brickW, brickH);
    if(ballPosition.x >= r7.x && ballPosition.x <= r7.x + 60 && ballPosition.y >= r7.y && ballPosition.y <= r7.y + 20){
      speedY = -speedY;
      r7 = new Point (1000,1000);
      r7x = 1000;
      r7y = 1000;
      score += 5;
    }
    Point r8 = new Point(r8x, r8y);
    g.setColor(Color.RED);
    g.fillRect(r8x, r8y, brickW, brickH);
    if(ballPosition.x >= r8.x && ballPosition.x <= r8.x + 60 && ballPosition.y >= r8.y && ballPosition.y <= r8.y + 20){
      speedY = -speedY;
      r8 = new Point (1000,1000);
      r8x = 1000;
      r8y = 1000;
      score += 5;
    }
    Point r9 = new Point(r9x, r9y);
    g.setColor(Color.RED);
    g.fillRect(r9x, r9y, brickW, brickH);
    if(ballPosition.x >= r9.x && ballPosition.x <= r9.x + 60 && ballPosition.y >= r9.y && ballPosition.y <= r9.y + 20){
      speedY = -speedY;
      r9 = new Point (1000,1000);
      r9x = 1000;
      r9y = 1000;
      score += 5;
    }
    Point r10 = new Point(r10x, r10y);
    g.setColor(Color.RED);
    g.fillRect(r10x, r10y, brickW, brickH);
    if(ballPosition.x >= r10.x && ballPosition.x <= r10.x + 60 && ballPosition.y >= r10.y && ballPosition.y <= r10.y + 20){
      speedY = -speedY;
      r10 = new Point (1000,1000);
      r10x = 1000;
      r10y = 1000;
      score += 5;
    }
    Point r11 = new Point(r11x, r11y);
    g.setColor(Color.RED);
    g.fillRect(r11x, r11y, brickW, brickH);
    if(ballPosition.x >= r11.x && ballPosition.x <= r11.x + 60 && ballPosition.y >= r11.y && ballPosition.y <= r11.y + 20){
      speedY = -speedY;
      r11 = new Point (1000,1000);
      r11x = 1000;
      r11y = 1000;
      score += 5;
    }
    Point r12 = new Point(r12x, r12y);
    g.setColor(Color.RED);
    g.fillRect(r12x, r12y, brickW, brickH);
    if(ballPosition.x >= r12.x && ballPosition.x <= r12.x + 60 && ballPosition.y >= r12.y && ballPosition.y <= r12.y + 20){
      speedY = -speedY;
      r12 = new Point (1000,1000);
      r12x = 1000;
      r12y = 1000;
      score += 5;
    }
    Point r13 = new Point(r13x, r13y);
    g.setColor(Color.RED);
    g.fillRect(r13x, r13y, brickW, brickH);
    if(ballPosition.x >= r13.x && ballPosition.x <= r13.x + 60 && ballPosition.y >= r13.y && ballPosition.y <= r13.y + 20){
      speedY = -speedY;
      r13 = new Point (1000,1000);
      r13x = 1000;
      r13y = 1000;
      score += 5;
    }
  }
  
  private class Listener implements ActionListener{   
    public void actionPerformed (ActionEvent e){
      repaint();
    }
  }
  
  //Implements movement of paddle using keypad
  private class PaddleListener implements KeyListener{ 
    public void keyPressed (KeyEvent e){
      switch(e.getKeyCode()){
        case KeyEvent.VK_RIGHT:
          restart.x += 25;               
          break;
        case KeyEvent.VK_LEFT:
          restart.x -= 25;
          break;
        case KeyEvent.VK_S:                 //S key stops timer
          timer.stop();
          break;
        case KeyEvent.VK_G:                //G key makes timer go
          timer.start();
          break;
      }
      repaint();
    }
    public void keyTyped (KeyEvent e){}
    public void keyReleased(KeyEvent e){}
  }
}    
