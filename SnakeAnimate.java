//Implement this code as a Venture EasyIO class.
//Improve it.
public class SnakeAnimate
{
    //class members---------------------------
    //private
    String [][] snakeMatrix;
    int rowDim, colDim;
    int snakeLength; //added to the head and tail
    int headRowPosn, headColPosn;
    int tailRowPosn, tailColPosn;
    int headDirection, tailDirection;
    boolean done;
    int speed, speedVal;


    //main of class
    public static void main(String[] args)
    {
        new SnakeAnimate();
    }

    //class constructor
    public SnakeAnimate()
    {
        output("\u000c"); //clears output terminal before execution
               
        //call methods
        welcome();
        getDimensions();
        setUpMatrix();
        animateMatrix();
    }


    //class methods---------------------------
    //method header
    public void welcome()
    {
        output("Welcome...\n\n");
    }
    
    public void getDimensions()
    {
        rowDim = inputInt("Enter the number of rows: ");
        colDim = inputInt("Enter the number of columns: ");
        snakeMatrix = new String[rowDim][colDim];
        snakeLength = inputInt("Enter the snake's length: ");
        
        speedVal = inputInt("Enter speed value: ");
    }
    
    public void setUpMatrix()
    {
        for (int r = 0; r < rowDim; r++)
        {
            for (int c = 0; c < colDim; c++)
            {
                snakeMatrix[r][c]=" ";
            }
            output("\n");
        }
    }
    
    public void animateMatrix()
    {
        done = false;
        
        output("You have entered the matrix....\n\n");
        headRowPosn = 0;
        headColPosn = 0;
        tailRowPosn = 0;
        tailColPosn = headRowPosn - snakeLength;
        headDirection = 1;
        tailDirection = 1;
        snakeMatrix[headRowPosn][headColPosn]="@";
        while (!done)
        {
            output("\u000c");
            displayMatrix();
            moveSnake();
            pause();
        }    
        output("\n\n\nProgram Done!!!");
    }
    
    
    public void pause()
    {
        input("");
        
        try
        {
            Thread.sleep(speedVal);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    
    public void moveSnake()
    {
        headColPosn = headColPosn + headDirection;
        tailColPosn = tailColPosn + tailDirection;
            
        done = gameOver();
        if (!done)
        { 
            if (headColPosn == colDim )
            {
                headRowPosn++;
                headDirection = -1;
                headColPosn--;
            }
            else if (headColPosn == -1)
            {
                headRowPosn++;
                headDirection = 1;
                headColPosn++;
            }
            if (tailColPosn == colDim )
            {
                tailRowPosn++;
                tailDirection = -1;
                tailColPosn--;
            }
            else if ((tailColPosn < 0) && (tailDirection == -1))
            {
                tailRowPosn++;
                tailDirection = 1;
                tailColPosn++;
            }
            
            snakeMatrix[headRowPosn][headColPosn]="@";
            if (tailColPosn >= 0)
            {
                snakeMatrix[tailRowPosn][tailColPosn]=" ";
            }        
        }
    }

    
    public boolean gameOver()
    {
        if ((headDirection == 1) && (headColPosn == (colDim)) && (headRowPosn == (rowDim-1)))
        {
            return true;
        }
        else if ((headDirection == -1) && (headColPosn == -1) && (headRowPosn == (rowDim-1)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void displayMatrix()
    {
        //displayLine();
        for (int r = 0; r < rowDim; r++)
        {
            for (int c = 0; c < colDim; c++)
            {
                output(snakeMatrix[r][c]);
            }
            output("\n");
        }
        //displayLine();
    }

    //end of coding; not end of class


    //Venture Easy IO methods-------------------------

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
