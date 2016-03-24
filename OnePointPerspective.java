package CoordinatePlane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OnePointPerspective extends JFrame implements KeyListener
{
    JFrame field;
    Canvas myCanvas = new Canvas();
   
    int xSize, ySize;
    int xPosnRect, yPosnRect;
    int xDirection, yDirection;
    int rectWidth, rectHeight;
    int step;
    int xPosnBack, yPosnBack;
    int xBack, yBack;
    double pf = 0.8;
    boolean done =false;

    
    public OnePointPerspective()
    {
        xSize = 800;
        ySize = 600;
        
        field = new JFrame();
        field.getContentPane().add(myCanvas);
        field.setBounds(500, 10, xSize, ySize+27); 
        field.setVisible(true);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.addKeyListener(this);
        field.setFocusable(true);
        myCanvas.addKeyListener(this);
        myCanvas.setFocusable(true);
        
        
        xPosnRect = 0;
        yPosnRect = 0;
        rectWidth = 100;
        rectHeight = 50;
        step = 10;
        
           
        while (!done)
        {
            runProgram();
        }
    } 
      
    public void runProgram()
    {
        field.setTitle("Coordinate Plane with One Point Perspective");
        myCanvas.repaint();
    }
    
    public void checkBounds()
    {
        if(xPosnRect<=-1) xPosnRect = xPosnRect+20;
        if(xPosnRect>=xSize+1) xPosnRect = xPosnRect -20;
        if(yPosnRect<=0-1) yPosnRect = yPosnRect+20;
        if (yPosnRect >= ySize-26)yPosnRect = yPosnRect - 20;
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
            yPosnRect = yPosnRect + yDirection;
        }
        if((k.getKeyCode() == KeyEvent.VK_S)||(k.getKeyCode() == KeyEvent.VK_DOWN))
        {
            yDirection = 0;
            yPosnRect = yPosnRect + yDirection;
        }
        if((k.getKeyCode() == KeyEvent.VK_A)||(k.getKeyCode() == KeyEvent.VK_LEFT))
        {
            xDirection = 0;
            xPosnRect = xPosnRect + xDirection;
        }
        if((k.getKeyCode() == KeyEvent.VK_D)||(k.getKeyCode() == KeyEvent.VK_RIGHT))
        {
            xDirection = 0;
            xPosnRect = xPosnRect + xDirection;
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
            yDirection = -step;
            yPosnRect = yPosnRect + yDirection;
            checkBounds();
        }
        if((k.getKeyCode() == KeyEvent.VK_S)||(k.getKeyCode() == KeyEvent.VK_DOWN))
        {
            yDirection = step;
            yPosnRect = yPosnRect + yDirection;
            checkBounds();
        }
        if((k.getKeyCode() == KeyEvent.VK_A)||(k.getKeyCode() == KeyEvent.VK_LEFT))
        {
            xDirection = -step;
            xPosnRect = xPosnRect + xDirection;
            checkBounds();
        }
        if((k.getKeyCode() == KeyEvent.VK_D)||(k.getKeyCode() == KeyEvent.VK_RIGHT))
        {
            xDirection = step;
            xPosnRect = xPosnRect + xDirection;
            checkBounds();
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
            //background
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLACK);
            
            //change font and size
            int fontSize = 20;
            Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
            g.setFont(f);
            
            //axes
            //drawXAxis(g);
            //drawYAxis(g);
            
            //lines of perspective
            //drawLinesOfPerspective(g);
            
            //draw box
            drawRectangle(g);
            
            
            field.setFocusable(true);
            myCanvas.setFocusable(true);

        }
        
        public void drawXAxis(Graphics g)
        {
            g.drawLine(0, ySize/2, xSize, ySize/2);
            g.drawLine(0, ySize/2, 10, ySize/2-10);//arrow
            g.drawLine(0, ySize/2, 10, ySize/2+10);
            g.drawLine(xSize, ySize/2, xSize-10, ySize/2-10);
            g.drawLine(xSize, ySize/2, xSize-10, ySize/2+10);
            g.drawString("x", xSize-20, ySize/2+20);
        }
        
        public void drawYAxis(Graphics g)
        {
            g.drawLine(xSize/2, 0, xSize/2, ySize);
            g.drawLine(xSize/2, 0, xSize/2-10, 10);//arrow
            g.drawLine(xSize/2, 0, xSize/2+10, 10);
            g.drawLine(xSize/2, ySize, xSize-10, ySize-10);
            g.drawLine(xSize/2, ySize, xSize+10, ySize-10);
            g.drawString("y", xSize/2-20, 20);
        }
        
        public void drawRectangle(Graphics g)
        {
            int xCoords = ySize / 2 - xPosnRect;
            int yCoords = ySize / 2 - yPosnRect;
            yCoords = -yCoords;
            
            g.setColor(Color.BLUE);
            g.drawRect(xPosnRect, yPosnRect, rectWidth, rectHeight);
            g.drawString("("+xCoords+","+yCoords+")", xPosnRect+3, yPosnRect+30);

            xPosnBack = (int) ((xCoords * pf) + 0.5);
            yPosnBack = (int) ((yCoords * pf) + 0.5);
            xBack = (int) ((rectWidth * pf) + 0.5);
            yBack = (int) ((rectHeight * pf) + 0.5);
            
            yPosnBack = ySize/2 - yPosnBack;
            xPosnBack = xPosnBack+xSize / 2;
            g.drawRect(xPosnBack, yPosnBack, xBack, yBack);
            
            g.drawLine(xPosnRect, yPosnRect, xPosnBack, yPosnBack);
            g.drawLine(xPosnRect+rectWidth, yPosnRect+rectHeight, xPosnBack+xBack, yPosnBack+yBack);
            g.drawLine(xPosnRect+rectWidth, yPosnRect, xPosnBack+xBack, yPosnBack);
            g.drawLine(xPosnRect, yPosnRect+rectHeight, xPosnBack, yPosnBack+yBack);
        }
        
        public void drawLinesOfPerspective(Graphics g)
        {
            g.setColor(Color.RED);
            g.drawLine(xPosnRect, yPosnRect, 400, 300);
            g.drawLine(xPosnRect, yPosnRect+50, 400, 300);
            g.drawLine(xPosnRect+100, yPosnRect, 400, 300);
            g.drawLine(xPosnRect+100, yPosnRect+50, 400, 300);
        }
        }
    }
