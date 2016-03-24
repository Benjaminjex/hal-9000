import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class QuadrantCoords extends JFrame implements KeyListener
{
    JFrame field;
    Canvas myCanvas = new Canvas();
   
    int xSize, ySize;
    int xBox = 10, yBox = 10;
    int xDirection, yDirection;
    int speed = 3;
    boolean done =false;

    
    public QuadrantCoords()
    {
        xSize = 500;
        ySize = 500;
        field = new JFrame();
        field.getContentPane().add(myCanvas);
        field.setBounds(500, 10, xSize, ySize); 
        field.setVisible(true);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.addKeyListener(this);
           
        while (!done)
        {
            runProgram();
        }
    } 
      
    public void runProgram()
    {
        field.setTitle("Coordinate Plane");
        checkBounds();
        xBox = xBox + xDirection;
        yBox = yBox + yDirection;
        
        myCanvas.repaint();
        pause(speed);
    }
    
    public void checkBounds()
    {
        if(xBox >= 480) xDirection = -1;
        if(xBox <= 0) xDirection = 1;
        if(yBox >= 457) yDirection = -1;
        if(yBox <= 0) yDirection = 1;
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

   
    //All of the following keyEvents -- keyReleased()
    //keyPressed(), keyTyped() --must be included 
    //even if they are not used.
    
    //when a key is released
    public void keyReleased(KeyEvent k)
    {
        if((k.getKeyCode() == KeyEvent.VK_W)||(k.getKeyCode() == KeyEvent.VK_UP))
        {
            yDirection = 0;
        }
        if((k.getKeyCode() == KeyEvent.VK_S)||(k.getKeyCode() == KeyEvent.VK_DOWN))
        {
            yDirection = 0;
        }
        if((k.getKeyCode() == KeyEvent.VK_A)||(k.getKeyCode() == KeyEvent.VK_LEFT))
        {
            xDirection = 0;
        }
        if((k.getKeyCode() == KeyEvent.VK_D)||(k.getKeyCode() == KeyEvent.VK_RIGHT))
        {
            xDirection = 0;
        }                   
    } 
                        
    //when a key is pressed
    public void keyPressed(KeyEvent k)
    {   
        if(k.getKeyCode() == KeyEvent.VK_Q) 
        { 
            done = true;
        }
        if((k.getKeyCode() == KeyEvent.VK_W)||(k.getKeyCode() == KeyEvent.VK_UP))
        {
            yDirection = yDirection - 1;
        }
        if((k.getKeyCode() == KeyEvent.VK_S)||(k.getKeyCode() == KeyEvent.VK_DOWN))
        {
            yDirection = yDirection + 1;
        }
        if((k.getKeyCode() == KeyEvent.VK_A)||(k.getKeyCode() == KeyEvent.VK_LEFT))
        {
            xDirection = xDirection - 1;
        }
        if((k.getKeyCode() == KeyEvent.VK_D)||(k.getKeyCode() == KeyEvent.VK_RIGHT))
        {
            xDirection = xDirection + 1;
        }
    } 
         
    //when a key is typed
    public void keyTyped(KeyEvent k)
    {
        //not checked at this time   
    } 
   
    
    //inner class (could be implemented outside of BallControllerWithFrames)
    class Canvas extends JPanel  
    {
        public void paintComponent( Graphics g ) 
        {         
            //Grid
            g.setColor(Color.GRAY);
            for (int i = 10; i <= 500; i = i + 20)
            {
                g.drawLine(i,0,i,477);
            }
            for (int i = 10; i <= 500; i= i + 20)
            {
                g.drawLine(0,i,500,i);
            }
            //Axes
            g.setColor(Color.RED);//y-Axis
            g.drawLine(250, 0, 250, 477);
            g.drawLine(250, 0, 260, 10);//arrows
            g.drawLine(250, 0, 240, 10);//arrows
            g.drawLine(250, 477, 260, 467);//arrows
            g.drawLine(250, 477, 240, 467);//arrows
            g.drawLine(0, 250, 500, 250);//x-Axis
            g.drawLine(0, 250, 10, 260);//arrows
            g.drawLine(0, 250, 10, 240);//arrows
            g.drawLine(500, 250, 490, 260);//arrows
            g.drawLine(500, 250, 490, 240);//arrows
            //moving box
            g.setColor(Color.BLACK);
            g.drawRect(xBox, yBox, 20, 20);
            g.fillRect(xBox, yBox, 20, 20);
        }
    }//end of inner class
}
