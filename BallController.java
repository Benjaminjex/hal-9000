package BallGame;
/*
   Benjamin Jex
   Ball v0
   */
public class BallController
{
    //class members---------------------------    
    //private
    int xPosnBall, yPosnBall, xMax=20, yMax=40;
    String[][] field;
    String ballColor;
    

    //main of class
    public static void main(String[] args)
    {
        new BallController();
    }

    //class constructor
    public BallController()
    {
        output("\u000c");
        boolean done = false;
        String response;
        
        field = new String [xMax][yMax];
        //call methods
        ballColor="@";
        do{
                        setField();
                        runProgram();

            displayField();
            response = input("Quit? y/n: ");
            if(response.equalsIgnoreCase("y")) done = true;
            else output("\u000c");
        }while(!done);
    }


    //class methods---------------------------
    //method header
    public void runProgram(){
        //program ball
        //call methods that are instructions
        /*Duration
         * 18 for diag
         * 35 for horizon
         * 19 for vertical
         */
        roll(18, 20, 135);
        roll(18, 20, 45);
        roll(35, 20, 270);
        roll(19, 600, 180);
        roll(40, 625, 90);
        roll(19, 650, 0);
        roll(18, 225, 270);
        roll(40, 625, 180);
        roll(40, 625, 45);
        roll(40, 625, 180);
        roll(40, 625, 315);
    }
    
    public void roll(int duration, int speed, int heading){ 
        int xDirect=0, yDirect=0;
        
        switch(heading){//-x means vertical up move, +x = vertical down, -y = horizon L, +y = horizon R
            case 0 : xDirect = -1;
                     yDirect = 0;
                     break;
            case 45 : xDirect = -1;
                     yDirect = 1;
                     break;
            case 90 : xDirect = 0; 
                     yDirect = 1; 
                     break;
            case 135 : xDirect = 1;
                     yDirect = 1;
                     break;
            case 180 : xDirect = 1;
                     yDirect = 0;
                     break;
            case 225 : xDirect = 1;
                     yDirect = -1;
                     break;
            case 270 : xDirect = 0;
                     yDirect = -1;
                     break;
            case 315 : xDirect = -1;
                     yDirect = -1;
                     break;            

            case 360 : xDirect = -1;
                     yDirect = 0;
                     break;
                     
            default : output("\u000c");
                      output("Heading error!!\n\n");
                      input("Press <return> to continue...");
                    }
                      
            for (int i = 0; i<duration; i++){
                field[xPosnBall][yPosnBall] = " ";
                xPosnBall = xPosnBall + xDirect;
                yPosnBall = yPosnBall + yDirect;
                field[xPosnBall][yPosnBall] = ballColor;//out of bounds
                displayField();
                pause(speed);
            }
        }
    
                        
    public void pause(int speed){
        try {
            Thread.sleep(speed);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    public void setColor(String color){ballColor = color;}
    
    
    public void setField(){
        for (int r = 0; r < xMax; r++)
        {
            for (int c = 0; c < yMax; c++)
            {
                field[r][c]=" ";
            }
            output("\n");
        }   
    }
    public void displayField()
    {
        output("+");
        for(int c = 0; c < yMax; c++)
            {
                output("-");
            }
        output("+");
        output("\n");    
        for(int r = 0; r < xMax; r++)
        {
            //top
            
            //middle
            output("|");
            for(int c = 0; c < yMax; c++)
            {
                output(field[r][c]);
            }
            output("|");
            output("\n");
            
        }
        output("+");
        for(int c = 0; c < yMax; c++)
        {
            output("-");
        }
        output("+");
        output("\n");
    }

    //end of coding; not end of class


    //Easy IO methods-------------------------

    //methods for output
    static void output(String info) { System.out.print(info); }
    static void output(double info) { System.out.println(info); }
    static void output(int info)    { System.out.println(info); }

    //method for input
    static int inputInt(String prompt)
    {
        int result = 0;

        try
        {
            result = Integer.parseInt(input(prompt).trim());
        }
        catch (Exception e)
        {
            result = 0;
        }
    
        return result;
    }


    static double inputDouble(String prompt)
    {
        double result = 0;

        try
        {
            result = Double.valueOf(input(prompt).trim()).doubleValue();
        }
        catch (Exception e)
        {
            result = 0;
        }

        return result;
    }

    
    static String input(String prompt)
    {
        String inputLine = "";

        System.out.print(prompt);
        try
        {
            java.io.InputStreamReader sys = new java.io.InputStreamReader(System.in);
            java.io.BufferedReader inBuffer = new java.io.BufferedReader(sys);
            inputLine = inBuffer.readLine();
        }
        catch (Exception e)
        {
            String err = e.toString();

            System.out.println(err);
        }
        
        return inputLine;
    }


    static String input()
    {
        return input("");
    }


} //end of class
