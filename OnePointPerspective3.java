import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math.*;

public class OnePointPerspective3 extends JFrame implements KeyListener
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
    
    int [] lastTranslatedX;
    int [] lastTranslatedY;
  
    boolean done;
    
    
    public OnePointPerspective3()
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

        lastTranslatedX = new int[numVertices];
        lastTranslatedY = new int[numVertices];
        
        step = 10;
        angle = 0.0;
        zBack = 0;
        pf = 0.8;
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
            
            if(k.getKeyCode() == KeyEvent.VK_RIGHT) 
            { 
                field.setTitle("Moving RIGHT");
                xDirection = step;
            } 
               
            if(k.getKeyCode() == KeyEvent.VK_LEFT) 
            { 
                field.setTitle("Moving LEFT");
                xDirection = -step;
            }
               
            if(k.getKeyCode() == KeyEvent.VK_UP) 
            { 
                field.setTitle("Moving UP");
                yDirection = -step;
            }
               
            if(k.getKeyCode() == KeyEvent.VK_DOWN) 
            { 
                field.setTitle("Moving DOWN");
                yDirection = step;
            }

            
            if(k.getKeyCode() == KeyEvent.VK_P) 
            { 
                int translateX, translateY;
                
                field.setTitle("Rotate POSITIVE");
                angle = m.toRadians(15);
                for (int i = 0; i < numVertices; i++)
                {
                    translateX = xCoord[i] - xCenter;
                    translateY = yCenter - yCoord[i];
                
                    xCoord[i] = (int) ((translateX * m.cos(angle)) - (translateY * m.sin(angle)) + 0.5);
                    yCoord[i] = (int) ((translateX * m.sin(angle)) + (translateY * m.cos(angle)) + 0.5);
                    
                    xCoord[i] = xCoord[i] + xCenter;
                    yCoord[i] = yCenter - yCoord[i];
                }
                xDirection = 0; yDirection = 0;
            }
            
            if(k.getKeyCode() == KeyEvent.VK_N) 
            { 
                int translateX, translateY;
                
                field.setTitle("Rotate NEGATIVE");
                angle = m.toRadians(-15);
                for (int i = 0; i < numVertices; i++)
                {
                    translateX = xCoord[i] - xCenter;
                    translateY = yCenter - yCoord[i];
                
                    xCoord[i] = (int) ((translateX * m.cos(angle)) - (translateY * m.sin(angle)) + 0.5);
                    yCoord[i] = (int) ((translateX * m.sin(angle)) + (translateY * m.cos(angle)) + 0.5);
                    
                    xCoord[i] = xCoord[i] + xCenter;
                    yCoord[i] = yCenter - yCoord[i];
                }
                xDirection = 0; yDirection = 0;
            } 
           
            if(k.getKeyCode() == KeyEvent.VK_R) 
            {
                //reset key
                field.setTitle("RESET");
                initSolid();
                for (int i = 0; i < numVertices/2; i++)
                {
                    xCoord[i] = xCoord[i] + xCenter + 15;
                    yCoord[i] = yCenter - yCoord[i] - 25;
                }   
            }
            
            if(k.getKeyCode() == KeyEvent.VK_F) 
            {
                int translateX, translateY;
                double d = 1.1;
                
                
                field.setTitle("Moving FORWARD");
                for (int i = 0; i < numVertices; i++)
                {
                    translateX = xCoord[i] - xCenter;
                    translateY = yCenter - yCoord[i];
                
                    xCoord[i] = (int) ((translateX * d));
                    yCoord[i] = (int) ((translateY * d));
                    
                    xCoord[i] = xCoord[i] + xCenter;
                    yCoord[i] = yCenter - yCoord[i];
                }
                pf = pf - 0.02;
            }
            
            if(k.getKeyCode() == KeyEvent.VK_B) 
            {
                int translateX, translateY;
                double d = 0.9;
                
                field.setTitle("Moving BACKWARD");
                for (int i = 0; i < numVertices; i++)
                {
                    translateX = xCoord[i] - xCenter;
                    translateY = yCenter - yCoord[i];
                
                    xCoord[i] = (int) ((translateX * d));
                    yCoord[i] = (int) ((translateY * d));
                    
                    xCoord[i] = xCoord[i] + xCenter;
                    yCoord[i] = yCenter - yCoord[i];
                }
                pf = pf + 0.02;
            }
            
            
            if(k.getKeyCode() == KeyEvent.VK_Q) 
            { 
                done = true;
                field.setTitle("Program Done!!!!");
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
            //Image img;
            //img = new ImageIcon("Earthrise.jpg").getImage();
            //g.drawImage(img, getWidth(), getHeight(), this);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());  
            g.setColor(Color.BLACK);

            //change font and size
            int fontSize = 20;
            Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
            g.setFont(f);
            
            Image img = new ImageIcon("Earthrise.JPG").getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            
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
            translateX = 0;
            translateY = 0;
            
            //pf = 0.6;
            for (int i = 0; i < numVertices/2; i++)
            {
                translateX = xCoord[i] - xCenter;
                translateY = yCenter - yCoord[i];
                
                xCoord[i+4] = (int)((translateX * pf) + 0.5);
                yCoord[i+4] = (int)((translateY * pf) + 0.5);
                
                xCoord[i+4] = xCoord[i+4] + xCenter;
                yCoord[i+4] = yCenter - yCoord[i+4];
            }
            
            boolean firstQuad, secondQuad, thirdQuad, fourthQuad;
            /*
            firstQuad = false; secondQuad = false; thirdQuad = false; fourthQuad = false;
            while(translateX > 1 && translateY > 1)
            {
                firstQuad = true;
            }
            while(translateX < -1 && translateY > 1)
            {
                secondQuad = true;
            }
            while(translateX < -1 && translateY < -1)
            {
                thirdQuad = true;
            }
            while(translateX > 1 && translateY < -1)
            {
                fourthQuad = true;
            }
            */
            firstQuad = translateX > 1 && translateY > 1;
            secondQuad = translateX < -1 && translateY > 1;
            thirdQuad = translateX < -1 && translateY < -1;
            fourthQuad = translateX > 1 && translateY < -1;
            
            if (firstQuad = true)
            {
                int [] leftX, leftY;
                leftX = new int[4];
                leftY = new int[4];
                g.setColor(Color.CYAN);
                leftX[0] = xCoord[0]; leftY [0] = yCoord[0];
                leftX[1] = xCoord[1]; leftY [1] = yCoord[1];
                leftX[2] = xCoord[5]; leftY [2] = yCoord[5];
                leftX[3] = xCoord[4]; leftY [3] = yCoord[4];
                g.fillPolygon(leftX, leftY, 4);
                
                int [] bottomX, bottomY;
                bottomX = new int[4];
                bottomY = new int[4];
                g.setColor(Color.YELLOW);
                bottomX[0] = xCoord[1]; bottomY[0] = yCoord[1];
                bottomX[1] = xCoord[5]; bottomY[1] = yCoord[5];
                bottomX[2] = xCoord[6]; bottomY[2] = yCoord[6];
                bottomX[3] = xCoord[2]; bottomY[3] = yCoord[2];
                g.fillPolygon(bottomX, bottomY, 4);
                
                int [] frontX, frontY;
                frontX = new int[4];
                frontY = new int[4];
                g.setColor(Color.GREEN);
                frontX[0] = xCoord[0]; frontY[0] = yCoord[0];
                frontX[1] = xCoord[3]; frontY[1] = yCoord[3];
                frontX[2] = xCoord[2]; frontY[2] = yCoord[2];
                frontX[3] = xCoord[1]; frontY[3] = yCoord[1];
                g.fillPolygon(frontX, frontY, 4);
                
                firstQuad = false;
            }
            
            if (secondQuad = true)
            {
                int [] rightX, rightY;
                rightX = new int[4];
                rightY = new int[4];
                g.setColor(Color.CYAN);
                rightX[0] = xCoord[3]; rightY[0] = yCoord[3];
                rightX[1] = xCoord[2]; rightY[1] = yCoord[2];
                rightX[2] = xCoord[6]; rightY[2] = yCoord[6];
                rightX[3] = xCoord[7]; rightY[3] = yCoord[7];
                g.fillPolygon(rightX, rightY, 4);
                
                int [] bottomX, bottomY;
                bottomX = new int[4];
                bottomY = new int[4];
                g.setColor(Color.YELLOW);
                bottomX[0] = xCoord[1]; bottomY[0] = yCoord[1];
                bottomX[1] = xCoord[5]; bottomY[1] = yCoord[5];
                bottomX[2] = xCoord[6]; bottomY[2] = yCoord[6];
                bottomX[3] = xCoord[2]; bottomY[3] = yCoord[2];
                g.fillPolygon(bottomX, bottomY, 4);
                
                int [] frontX, frontY;
                frontX = new int[4];
                frontY = new int[4];
                g.setColor(Color.GREEN);
                frontX[0] = xCoord[0]; frontY[0] = yCoord[0];
                frontX[1] = xCoord[3]; frontY[1] = yCoord[3];
                frontX[2] = xCoord[2]; frontY[2] = yCoord[2];
                frontX[3] = xCoord[1]; frontY[3] = yCoord[1];
                g.fillPolygon(frontX, frontY, 4);
                
                secondQuad = false;
            }
            
            if (thirdQuad = true)
            {   
                int [] topX, topY;
                topX = new int[4];
                topY = new int[4];
                g.setColor(Color.YELLOW);
                topX[0] = xCoord[0]; topY[0] = yCoord[0];
                topX[1] = xCoord[4]; topY[1] = yCoord[4];
                topX[2] = xCoord[7]; topY[2] = yCoord[7];
                topX[3] = xCoord[3]; topY[3] = yCoord[3];
                g.fillPolygon(topX, topY, 4);
                
                int [] rightX, rightY;
                rightX = new int[4];
                rightY = new int[4];
                g.setColor(Color.CYAN);
                rightX[0] = xCoord[3]; rightY[0] = yCoord[3];
                rightX[1] = xCoord[2]; rightY[1] = yCoord[2];
                rightX[2] = xCoord[6]; rightY[2] = yCoord[6];
                rightX[3] = xCoord[7]; rightY[3] = yCoord[7];
                g.fillPolygon(rightX, rightY, 4);
                
                int [] frontX, frontY;
                frontX = new int[4];
                frontY = new int[4];
                g.setColor(Color.GREEN);
                frontX[0] = xCoord[0]; frontY[0] = yCoord[0];
                frontX[1] = xCoord[3]; frontY[1] = yCoord[3];
                frontX[2] = xCoord[2]; frontY[2] = yCoord[2];
                frontX[3] = xCoord[1]; frontY[3] = yCoord[1];
                g.fillPolygon(frontX, frontY, 4);
                
                thirdQuad = false;
            }
            
            if (fourthQuad = true)
            {
                int [] topX, topY;
                topX = new int[4];
                topY = new int[4];
                g.setColor(Color.YELLOW);
                topX[0] = xCoord[0]; topY[0] = yCoord[0];
                topX[1] = xCoord[4]; topY[1] = yCoord[4];
                topX[2] = xCoord[7]; topY[2] = yCoord[7];
                topX[3] = xCoord[3]; topY[3] = yCoord[3];
                g.fillPolygon(topX, topY, 4);
                
                int [] leftX, leftY;
                leftX = new int[4];
                leftY = new int[4];
                g.setColor(Color.CYAN);
                leftX[0] = xCoord[0]; leftY [0] = yCoord[0];
                leftX[1] = xCoord[1]; leftY [1] = yCoord[1];
                leftX[2] = xCoord[5]; leftY [2] = yCoord[5];
                leftX[3] = xCoord[4]; leftY [3] = yCoord[4];
                g.fillPolygon(leftX, leftY, 4);
                
                int [] frontX, frontY;
                frontX = new int[4];
                frontY = new int[4];
                g.setColor(Color.GREEN);
                frontX[0] = xCoord[0]; frontY[0] = yCoord[0];
                frontX[1] = xCoord[3]; frontY[1] = yCoord[3];
                frontX[2] = xCoord[2]; frontY[2] = yCoord[2];
                frontX[3] = xCoord[1]; frontY[3] = yCoord[1];
                g.fillPolygon(frontX, frontY, 4);
                
                fourthQuad = false;
            }
            /*
            int [] backX, backY;
            backX = new int[4];
            backY = new int[4];
            g.setColor(Color.GREEN);
            backX[0] = xCoord[4]; backY[0] = yCoord[4];
            backX[1] = xCoord[5]; backY[1] = yCoord[5];
            backX[2] = xCoord[6]; backY[2] = yCoord[6];
            backX[3] = xCoord[7]; backY[3] = yCoord[7];
            g.fillPolygon(backX, backY, 4);
            
            int [] leftX, leftY;
            leftX = new int[4];
            leftY = new int[4];
            g.setColor(Color.CYAN);
            leftX[0] = xCoord[0]; leftY [0] = yCoord[0];
            leftX[1] = xCoord[1]; leftY [1] = yCoord[1];
            leftX[2] = xCoord[5]; leftY [2] = yCoord[5];
            leftX[3] = xCoord[4]; leftY [3] = yCoord[4];
            g.fillPolygon(leftX, leftY, 4);
            
            int [] rightX, rightY;
            rightX = new int[4];
            rightY = new int[4];
            g.setColor(Color.CYAN);
            rightX[0] = xCoord[3]; rightY[0] = yCoord[3];
            rightX[1] = xCoord[2]; rightY[1] = yCoord[2];
            rightX[2] = xCoord[6]; rightY[2] = yCoord[6];
            rightX[3] = xCoord[7]; rightY[3] = yCoord[7];
            g.fillPolygon(rightX, rightY, 4);
            
            int [] topX, topY;
            topX = new int[4];
            topY = new int[4];
            g.setColor(Color.YELLOW);
            topX[0] = xCoord[0]; topY[0] = yCoord[0];
            topX[1] = xCoord[4]; topY[1] = yCoord[4];
            topX[2] = xCoord[7]; topY[2] = yCoord[7];
            topX[3] = xCoord[3]; topY[3] = yCoord[3];
            g.fillPolygon(topX, topY, 4);
            
            int [] bottomX, bottomY;
            bottomX = new int[4];
            bottomY = new int[4];
            g.setColor(Color.YELLOW);
            bottomX[0] = xCoord[1]; bottomY[0] = yCoord[1];
            bottomX[1] = xCoord[5]; bottomY[1] = yCoord[5];
            bottomX[2] = xCoord[6]; bottomY[2] = yCoord[6];
            bottomX[3] = xCoord[2]; bottomY[3] = yCoord[2];
            g.fillPolygon(bottomX, bottomY, 4);
            
            int [] frontX, frontY;
            frontX = new int[4];
            frontY = new int[4];
            g.setColor(Color.GREEN);
            frontX[0] = xCoord[0]; frontY[0] = yCoord[0];
            frontX[1] = xCoord[3]; frontY[1] = yCoord[3];
            frontX[2] = xCoord[2]; frontY[2] = yCoord[2];
            frontX[3] = xCoord[1]; frontY[3] = yCoord[1];
            g.fillPolygon(frontX, frontY, 4);
            */
            
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
