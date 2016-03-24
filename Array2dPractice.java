public class Array2dPractice
{
    //class members---------------------------
    //private
    String [][] array2d;
    int rowMax, colMax;
    boolean done;
    String object;
    int objRowPosn, objColPosn;
    int prevObjRowPosn, prevObjColPosn;
    int objRowDirection, objColDirection;

    //main of class
    public static void main(String[] args)
    {
        new Array2dPractice();
    }

    //class constructor
    public Array2dPractice()
    {
        String response;
        output("\u000c"); //clears output terminal before execution

        //call methods
        done = false;
        rowMax = 15;
        colMax = 15;
        array2d = new String[rowMax][colMax];
        object = ">";
        objRowPosn = 0;
        objColPosn = 0;
        objRowDirection = 1;
        objColDirection = 0;
        while (!done)
        {
            fill2dArray();
            doProcess();
            response = input("Another? y/n: ");
            if (response.equalsIgnoreCase("n"))
            {
                done = true; output("\n\nProgram done!!!!!");
            }
            else {output("\u000c");}

        }
    }
    
    public void doProcess()
    {
        fill2dArray();
        display2dArray();
    }
    
    public void fill2dArray()
    {
        for(int r = 0; r<rowMax; r++)
        {
            for(int c = 0; c<colMax; c++)
            {
                array2d[r][c] = " ";
            }
        }
    }
    
    public void display2dArray()
    {

        
        displayLine();
       
        for(int r = 0; r<rowMax; r++)
        {
            output("|");
            for(int c = 0; c<colMax; c++)
            {
                output(array2d[r][c]);
                
            }
            output("|\n");
            
        }       
    
        displayLine();
    }


    public void displayLine()
    {
        output("+");
        for(int c = 0; c<colMax; c++)
        {
            output("-");
        }        
        output("+\n");
    }
    //class methods---------------------------
    //method header


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
