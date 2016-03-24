import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class BallControllerWithFrames here.
 * 
 * @author (Benjamin Jex) 
 * @version (v2)
 */
public class aBallControllerWithKeyEvent extends JFrame implements KeyListener
{
    JFrame field;
    Canvas myCanvas = new Canvas();
    
    int ballXloc = 295, ballYloc = 250;
    int xMax = 600, yMax = 400;
    int xDirection = -1, yDirection = 1;
    int lpDirection, rpDirection;
    int speed = 2;
    boolean done = false;
    int lScore = 0, rScore = 0;
    int lPaddleY = 200, rPaddleY = 200;
    int lPaddleYTop, rPaddleYTop;
    int lPaddleDisplayFix, rPaddleDisplayFix;

    public aBallControllerWithKeyEvent()
    {
        field = new JFrame();
        field.getContentPane().add(myCanvas);
        field.setBounds(400, 200, xMax, yMax);
        field.setVisible(true);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.addKeyListener(this);
        
        while(!done) runProgram();
    }
    
    public void runProgram()
    {
        coords();
        paddle();
        checkBounds();
        scoreboard();
        myCanvas.repaint();
        pause(speed);
    }
    public void coords(){
        lPaddleDisplayFix = lPaddleY - 75;
        lPaddleYTop = (lPaddleY - 75);
        rPaddleY = rPaddleY + rpDirection;
        rPaddleYTop = (rPaddleY - 75);
        rPaddleDisplayFix = rPaddleY - 75;
        ballXloc = ballXloc + xDirection;
        ballYloc = ballYloc + yDirection;
        lPaddleY = lPaddleY + lpDirection;

    }
    public void paddle(){
        if ((ballYloc >= lPaddleYTop)&&(ballYloc <= lPaddleY)){
                if((ballXloc <= 60)&&(ballXloc >=50)){xDirection = xDirection * -1;
                yDirection = yDirection * -1;}}
        if((ballYloc >= rPaddleYTop)&&(ballYloc <= rPaddleY))
                if((ballXloc <= 550)&&(ballXloc >=540)){xDirection = xDirection * -1;
                yDirection = yDirection * -1;}
    }

    public void checkBounds(){
        if((ballXloc > 700)||(ballXloc < -100)){xDirection = xDirection*-1; ballXloc = 295; ballYloc = 300;}
        if((ballYloc < 0)||(ballYloc > 350)){yDirection = yDirection*-1;}
        if(lPaddleY < 75)lPaddleY = 75;
        if(lPaddleY > 400)lPaddleY = 400;
        if(rPaddleY < 75)rPaddleY = 75;
        if(rPaddleY > 400)rPaddleY = 400;
    }

    public void scoreboard()
    {
        if(ballXloc > 699){lScore = lScore+1;}
        else if (ballXloc < -99){rScore = rScore+1;}
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
    
    public void keyReleased(KeyEvent k){
         if(k.getKeyCode()==KeyEvent.VK_UP)
            {
                //yDirection = -1;
                rpDirection = 0;
            }
            
            if(k.getKeyCode()==KeyEvent.VK_DOWN)
            {
                //yDirection = 1;
                rpDirection = 0;
            }
        
        if(k.getKeyCode()==KeyEvent.VK_W)
            {
                //yDirection = -1;
                lpDirection = 0;
            }
            
        if(k.getKeyCode()==KeyEvent.VK_S)
        {
            //yDirection = 1;
            lpDirection = 0;
        }
    }//not checked yet
    
    public void keyPressed(KeyEvent k)//set boundaries
    {
        if(!done)
        {
            field.setTitle("PONG");
//            if(k.getKeyCode()==KeyEvent.VK_RIGHT)
  //          {
    //            xDirection = 1;
     //       }
            
       //     if(k.getKeyCode()==KeyEvent.VK_LEFT)
         //   {
           //     xDirection = -1;
            //}
            
            if(k.getKeyCode()==KeyEvent.VK_UP)
            {
                //yDirection = -1;
                rpDirection = -2;
            }
            
            if(k.getKeyCode()==KeyEvent.VK_DOWN)
            {
                //yDirection = 1;
                rpDirection = 2;
            }
            
            /*if(k.getKeyCode()==KeyEvent.VK_D)
            {
                xDirection = 1;
            }*/
            
            /*if(k.getKeyCode()==KeyEvent.VK_A)
            {
                xDirection = -1;
            }*/
            
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
    
        class Canvas extends JPanel
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
        }//1395
    }
}
