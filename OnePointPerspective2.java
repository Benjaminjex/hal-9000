import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math.*;

public class OnePointPerspective2 extends JFrame implements KeyListener
{
    JFrame field;
    Canvas myCanvas = new Canvas();
    Math m;
    
    //
    int xCenter, yCenter, numVertices;
    int[] xCoord; int[] yCoord; int[] zCoord;
    int zBack;
    double pf;
    int xSize, ySize;
    int xDirection, yDirection;
    int step;
    double angle;
    
    int [] translatedX;
    int [] translatedY;
  
    boolean done;
    
    
    public OnePointPerspective2()
    {
        xSize = 800;
        ySize = 600;
        field = new JFrame();
        field.getContentPane().add(myCanvas);
        field.setBounds(400, 100, xSize, ySize+27); 
        field.setVisible(true);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.addKeyListener(this);
        field.setFocusable(true);
        myCanvas.addKeyListener(this);
        myCanvas.setFocusable(true);
                   
        initSolid();

        translatedX = new int[numVertices];
        translatedY = new int[numVertices];
        
        step = 10;
        angle = 0.0;
        zBack = 0;
        done = false;
        
        while (!done)
        {
            runProgram();    
        }
    } 
      
    
    public void initSolid()
    {
        numVertices = 8;
        xCenter = xSize/2;
        yCenter = ySize/2;
        
        xCoord = new int[numVertices];
        yCoord = new int[numVertices];
        zCoord = new int[numVertices];

        xCoord[0] = 0; yCoord[0] = 0; zCoord[0] = 0;
        xCoord[1] = 0; yCoord[1] = 100; zCoord[1] = 0;
        xCoord[2] = 200; yCoord[2] = 100; zCoord[2] = 0;
        xCoord[3] = 200; yCoord[3] = 0; zCoord[3] = 0;
        xCoord[4] = 0; yCoord[4] = 0; zCoord[4] = 0;
        xCoord[5] = 0; yCoord[5] = 0; zCoord[5] = 0;
        xCoord[6] = 0; yCoord[6] = 0; zCoord[6] = 0;
        xCoord[7] = 0; yCoord[7] = 0; zCoord[7] = 0;
        
    }
    
    public void runProgram()
    {
        
        myCanvas.repaint();
    }

   
    //All of the following keyEvents -- keyReleased()
    //keyPressed(), keyTyped() --must be included 
    //even if they are not used.
    
    //when a key is released
    public void keyReleased(KeyEvent k)
    {
        //not checked at this time 
        k.getKeyCode();
    } 
                        
    //when a key is pressed
    public void keyPressed(KeyEvent k)
    {   
        if (!done)
        {
            xDirection = 0;
            yDirection = 0;
            
            if(k.getKeyCode() == KeyEvent.VK_R) 
            { 
                initSolid();
            } 
            
            if(k.getKeyCode() == KeyEvent.VK_D) 
            { 
                xDirection = step;
            } 
               
            if(k.getKeyCode() == KeyEvent.VK_A) 
            { 
                xDirection = -step;
            }
               
            if(k.getKeyCode() == KeyEvent.VK_W) 
            { 
                yDirection = -step;
            }
               
            if(k.getKeyCode() == KeyEvent.VK_S) 
            { 
                yDirection = step;
            }

            if(k.getKeyCode() == KeyEvent.VK_E) 
            { 
                int translateX, translateY;
                
                angle = m.toRadians(-15);
                //xCoord = lastTranslatedX;
                //yCoord = lastTranslatedY;
                for (int i = 0; i < numVertices; i++)
                {
                    translateX = xCoord[i] - xCenter;
                    translateY = yCenter - yCoord[i];
                
                    xCoord[i] = (int) ((translateX * m.cos(angle)) - (translateY * m.sin(angle)) + 0.49);
                    yCoord[i] = (int) ((translateX * m.sin(angle)) + (translateY * m.cos(angle)) + 0.49);
                    
                    xCoord[i] = xCoord[i] + xCenter;
                    yCoord[i] = yCenter - yCoord[i];
                }
                xDirection = 0; yDirection = 0;
            }
            if(k.getKeyCode() == KeyEvent.VK_Q) 
            { 
                int translateX, translateY;
                
                angle = m.toRadians(15);
                //xCoord = lastTranslatedX;
                //yCoord = lastTranslatedY;
                for (int i = 0; i < numVertices; i++)
                {
                    translateX = xCoord[i] - xCenter;
                    translateY = yCenter - yCoord[i];
                
                    xCoord[i] = (int) ((translateX * m.cos(angle)) - (translateY * m.sin(angle)) + 0.49);
                    yCoord[i] = (int) ((translateX * m.sin(angle)) + (translateY * m.cos(angle)) + 0.49);
                    
                    xCoord[i] = xCoord[i] + xCenter;
                    yCoord[i] = yCenter - yCoord[i];
                }
                xDirection = 0; yDirection = 0;
            }
            
            
            if(k.getKeyCode() == KeyEvent.VK_1) 
            { 
                done = true;
                field.setTitle("Goodbye!!");
            }
        }
        
        for (int i = 0; i<numVertices; i++)
        {
            xCoord[i] = xCoord[i] + xDirection;
            yCoord[i] = yCoord[i] + yDirection;
        }
        
        myCanvas.repaint();
    
    }
         
    //when a key is typed
    public void keyTyped(KeyEvent k)
    {
        //not checked at this time   
    } 
   
    
    //inner class
    class Canvas extends JPanel  
    {
        public void paintComponent( Graphics g ) 
        {
            // writing over the background to give animation effect
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());  
            g.setColor(Color.BLACK);

            //change font and size
            int fontSize = 20;
            Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
            g.setFont(f);
            
            //x-axis
            drawXAxis(g);
            
            //y-axis
            drawYAxis(g);
            
            //lines of perspective
            drawLinesOfPerspective(g);
            
            //draw rectangle
            drawSolid(g);
            
            field.setFocusable(true);
            myCanvas.setFocusable(true);
        }
        
        public void drawXAxis(Graphics g)
        {
            g.drawLine(0, yCenter, xSize, yCenter);
            g.drawLine(0, yCenter, 10, yCenter-10);//arrow
            g.drawLine(0, yCenter, 10, yCenter+10);//arrow
            g.drawLine(xSize, yCenter, xSize-10, yCenter-10);//arrow
            g.drawLine(xSize, yCenter, xSize-10, yCenter+10);//arrow
            g.drawString("x", xSize-20, yCenter+20);
        }
        
        public void drawYAxis(Graphics g)
        {
            g.drawLine(xCenter, 0, xCenter, ySize);
            g.drawLine(xCenter, 0, xCenter-10, 10);//arrow
            g.drawLine(xCenter, 0, xCenter+10, 10);//arrow
            g.drawLine(xCenter, ySize, xCenter-10, ySize-10);//arrow
            g.drawLine(xCenter, ySize, xCenter+10, ySize-10);//arrow
            g.drawString("y", xCenter-20, 20);
        } 
        
        public void drawSolid(Graphics g)
        {
            int translateX, translateY;
            
            pf = 0.8;
            for (int i = 0; i < numVertices/2; i++)
            {
                translateX = xCoord[i] - xCenter;
                translateY = yCenter - yCoord[i];
                
                xCoord[i+4] = (int)((translateX * pf) + 0.5);
                yCoord[i+4] = (int)((translateY * pf) + 0.5);
                
                xCoord[i+4] = xCoord[i+4] + xCenter;
                yCoord[i+4] = yCenter - yCoord[i+4];
            }
            
            g.setColor(Color.BLUE);
            g.drawLine(xCoord[0], yCoord[0], xCoord[1], yCoord[1]);
            g.drawLine(xCoord[1], yCoord[1], xCoord[2], yCoord[2]);
            g.drawLine(xCoord[2], yCoord[2], xCoord[3], yCoord[3]);
            g.drawLine(xCoord[3], yCoord[3], xCoord[0], yCoord[0]);
            g.drawLine(xCoord[4], yCoord[4], xCoord[5], yCoord[5]);
            g.drawLine(xCoord[5], yCoord[5], xCoord[6], yCoord[6]);
            g.drawLine(xCoord[6], yCoord[6], xCoord[7], yCoord[7]);
            g.drawLine(xCoord[7], yCoord[7], xCoord[4], yCoord[4]);
            
            for(int i = 0; i < numVertices/2; i++)
            {
                g.drawLine(xCoord[i], yCoord[i], xCoord[i+4], yCoord[i+4]);
            }
            
            g.setColor(Color.BLUE);
            g.drawString("("+ (xCoord[0]-xCenter) +","+ (yCenter-yCoord[0]) +")", xCoord[0]+3, yCoord[0]+30);
        
        }
        
        
        public void drawLinesOfPerspective(Graphics g)
        {
            g.setColor(Color.RED);
            //include code to draw the lines of perspective
            g.drawLine(xCenter, yCenter, xCoord[0], yCoord[0]);
            g.drawLine(xCenter, yCenter, xCoord[1], yCoord[1]);
            g.drawLine(xCenter, yCenter, xCoord[2], yCoord[2]);
            g.drawLine(xCenter, yCenter, xCoord[3], yCoord[3]);    
        }
                    
    }//end of inner class
    
}