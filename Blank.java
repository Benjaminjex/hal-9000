package CoordinatePlane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Blank extends JFrame implements KeyListener
{
    JFrame field;
    Canvas myCanvas = new Canvas();
   
    int xSize, ySize;
    boolean done =false;

    
    public Blank()
    {
        xSize = 100;
        ySize = 200;
        field = new JFrame();
        field.getContentPane().add(myCanvas);
        field.setBounds(200, 10, xSize, ySize); 
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
        field.setTitle("Program Running!!!");
        
        myCanvas.repaint();
    
    }

   
    //All of the following keyEvents -- keyReleased()
    //keyPressed(), keyTyped() --must be included 
    //even if they are not used.
    
    //when a key is released
    public void keyReleased(KeyEvent k)
    {
        //not checked at this time                    
    } 
                        
    //when a key is pressed
    public void keyPressed(KeyEvent k)
    {   
        if(k.getKeyCode() == KeyEvent.VK_Q) 
        { 
            done = true;
            field.setTitle("Program Done!!!!");
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
            // writing over the background to give animation effect
            g.setColor(Color.BLUE);
        }
    }//end of inner class
}
