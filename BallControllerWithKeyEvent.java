package BallGame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Play some PONG.
 * 
 * @author (Benjamin Jex)
 * @version (a)
 */
public class BallControllerWithKeyEvent extends JFrame implements KeyListener
{
    JFrame field;
    Canvas myCanvas = new Canvas();
    //instance variables
    
    //screen
    int xMax = 600, yMax = 400; //used for screen drawing and calcs
    int lScore = 0, rScore = 0; //scoreboard values
    
    //paddle
    int lpDirection = 0, rpDirection = 0; //paddle movement
    int lPaddleY = 200, rPaddleY = 200, lPaddleYTop, rPaddleYTop; //paddle location
    int lPaddleDisplayFix, rPaddleDisplayFix; //used for the display paddle
    
    //ball
    int ballXloc = 295, ballYloc = 200; //tracks ball; used for drawing and calculations
    int xDirection = -1, yDirection = -1; //ball direction
    int speed = 3; //ball speed
    
    //program
    boolean done = false;
    
    //class constructor
    public BallControllerWithKeyEvent()
    {
        //draw screen boundaries
        field = new JFrame();
        field.getContentPane().add(myCanvas);
        field.setBounds(400, 200, xMax, yMax); //location & boundaries
        field.setVisible(true);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.addKeyListener(this); //KeyEvent
        
        //class
        while (!done)
        {
            coords();
            paddle();
            checkBounds();
            scoreboard();
            myCanvas.repaint();
            pause(speed);
        }
    }
    
    //classes
    public void coords() //handles coordinate movement
    {
        //paddle location
        lPaddleY = lPaddleY + lpDirection;//bottom of paddle
        rPaddleY = rPaddleY + rpDirection;
        lPaddleYTop = lPaddleY - 75; //top of paddle
        rPaddleYTop = rPaddleY - 75;
        //ball location
        ballXloc = ballXloc + xDirection;
        ballYloc = ballYloc + yDirection;
        //draw paddle
        lPaddleDisplayFix = lPaddleY - 75;
        rPaddleDisplayFix = rPaddleY - 75;
    }
    
    //paddle boundaries
    public void paddle()
    {
        if ( (ballYloc >= lPaddleYTop) && (ballYloc <= lPaddleY) )
        {
            if ( (ballXloc <= 60) && (ballXloc >= 50) )
            {
                xDirection = xDirection * -1;
                ballXloc = 61;
                if (lpDirection == -1) yDirection = -1;
                else if (lpDirection == 1) yDirection = 1;
            }
        }
        if ( (ballYloc >= rPaddleYTop) && (ballYloc <= rPaddleY) )
        {
            if ( (ballXloc <= 550) && (ballXloc >= 540) )
            {
                xDirection = xDirection * -1;
                ballXloc = 539;
                if (rpDirection == -1) yDirection = -1;
                else if (rpDirection == 1) yDirection = 1;
            }
        }
    }
    
    //boundaries of the court
    public void checkBounds()
    {
        if ( (ballXloc > 700) || (ballXloc < -100) )//resets 
        {
            xDirection = xDirection * -1; 
            ballXloc = 295;
            ballYloc = 200;
        }
        if ( (ballYloc < 0) || (ballYloc > 350) ) yDirection = yDirection * -1;
        if (lPaddleY < 75) lPaddleY = 75;
        if (lPaddleY > 375) lPaddleY = 375; //stops paddle going offscreen
        if (rPaddleY < 75) rPaddleY = 75;
        if(rPaddleY > 375) rPaddleY = 375;
    }
    
    //scoreboard
    public void scoreboard()
    {
        if (ballXloc > 699) lScore = lScore + 1;//adds one to left player's score
        if (ballXloc < -99) rScore = rScore + 1;//adds one to Right Player's Score
    }
    
    //somehow this sets stuff with the speed, I don't know what it does.
    public void pause(int speed)
    {
        try {
            Thread.sleep(speed);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    //KeyListener detects key movement, used to control paddles
    public void keyReleased(KeyEvent k){ //if a key is released it stops the paddles from moving
        if(k.getKeyCode()==KeyEvent.VK_UP)
        {
              rpDirection = 0;
        }    
        if(k.getKeyCode()==KeyEvent.VK_DOWN)
        {
           rpDirection = 0;
        }
        if(k.getKeyCode()==KeyEvent.VK_W)
        {
                lpDirection = 0;
        }   
        if(k.getKeyCode()==KeyEvent.VK_S)
        {
            lpDirection = 0;
        }
    }
    
    public void keyPressed(KeyEvent k)//if a key is pressed it moves the paddle in that direction
    {
        if(!done)
        {
            field.setTitle("PONG");
            if(k.getKeyCode()==KeyEvent.VK_UP)
            {
                rpDirection = -2;
            }
            if(k.getKeyCode()==KeyEvent.VK_DOWN)
            {
                //yDirection = 1;
                rpDirection = 2;
            }
            if(k.getKeyCode()==KeyEvent.VK_W)
            {
                //yDirection = -1;
                lpDirection = -2;
            }
            if(k.getKeyCode()==KeyEvent.VK_S)
            {
                //yDirection = 1;
                lpDirection = 2;
            }
            if(k.getKeyCode()==KeyEvent.VK_O)
            {
                done = true;
                field.setTitle("Goodbye!!");
            }
        }
    }
    
    public void keyTyped(KeyEvent k){}//not checked yet
    //inner class (could be implemented outside of BallControllerWithFrames)
    
        class Canvas extends JPanel //readjust for screen sizes
        {
            public void paintComponent(Graphics g)
            {
                //background & scoreboard
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.WHITE);
                g.drawString(""+lScore, 250, 40);
                g.drawString(""+rScore, 350, 40);
                
                //net
                g.setColor(Color.WHITE);
                g.fillRect(300, 0, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 25, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 50, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 75, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 100, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 125, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 150, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 175, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 200, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 225, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 250, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 275, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 300, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 325, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 350, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 375, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 400, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 425, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 450, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 475, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 500, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 525, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 550, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 575, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 600, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 625, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 650, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 675, 4, 10);
                g.setColor(Color.WHITE);
                g.fillRect(300, 700, 4, 10);
                
                //ball
                g.setColor(Color.WHITE);
                g.fillRect(ballXloc, ballYloc, 15, 15);
                
                //left paddle
                g.setColor(Color.WHITE);
                g.fillRect(55, lPaddleDisplayFix, 15, 75);
                
                //right paddle
                g.setColor(Color.WHITE);
                g.fillRect(545, rPaddleDisplayFix, 15, 75);
        }
    }
}