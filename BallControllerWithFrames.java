package BallGame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class BallControllerWithFrames here.
 * 
 * @author (Benjamin Jex) 
 * @version (v1)
 */
public class BallControllerWithFrames extends JFrame
{
    JFrame field;
    Canvas myCanvas = new Canvas();
    
    int ballXloc = 10, ballYloc = 10;
    int xMax = 700, yMax = 700;
    int xDirection, yDirection;
    boolean done = false;

    public BallControllerWithFrames()
    {
        field = new JFrame();
        field.getContentPane().add(myCanvas);
        field.setBounds(400, 100, xMax, yMax);
        field.setVisible(true);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        runProgram();
    }
    //if more than 360 in heading -360
    public void runProgram()
    {
        roll(625, 1, 90);//tLtR
        roll(600, 1, 180);//tRbR
        roll(625, 1, 270);//bRbL
        roll(625, 1, 360);//bLtL
        roll(625, 1, 135);//tLbR
        roll(625, 1, 0);//bRtR
        roll(625, 1, 225);//tRbL
    }

    
    public void roll(int duration, int speed, int heading){
        int xDirection = 0, yDirection=0;
        
        switch(heading){
            case 0  :   xDirection = 0;
                        yDirection = -1;
                        break;

            case 45 :   xDirection = 1;
                        yDirection = -1;
                        break;
                        
            case 90 :   xDirection = 1; 
                        yDirection = 0; 
                        break;
                        
            case 135 :  xDirection = 1;
                        yDirection = 1;
                        break;
                        
            case 180 :  xDirection = 0;
                        yDirection = 1;
                        break;
                        
            case 225 :  xDirection = -1;
                        yDirection = 1;
                        break;
                        
            case 270 :  xDirection = -1;
                        yDirection = 0;
                        break;
                        
            case 315 :  xDirection = -1;
                        yDirection = -1;
                        break;            
                        
            case 360 :  xDirection = 0;
                        yDirection = -1;
                        break;
                     
            default : System.out.println("\u000c");
            System.out.println("Heading error!!\n\n");
        }
        
        for (int i = 0; i < duration; i++)
        {
            ballXloc = ballXloc + xDirection;
            ballYloc = ballYloc + yDirection;
            myCanvas.repaint();
            pause(speed);
        }
    }
    
    public void pause(int speed)
    {
        try {
            Thread.sleep(speed);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    //inner class (could be implemented outside of BallControllerWithFrames)
    
        class Canvas extends JPanel
        {
            public void paintComponent(Graphics g)
            {
                //writing over the background to give animation effect
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.red);
                //g.drawString("Hello", 20, 40);
                
                //ball
                int R = (int) (Math.random( )*256);
                int G = (int) (Math.random( )*256);
                int B = (int) (Math.random( )*256);        
                Color randomColor = new Color(R, G, B);
                g.setColor(randomColor);
                //g.setColor(Color.ORANGE);
                g.fillOval(ballXloc, ballYloc, 60, 60);
        }
    }
}