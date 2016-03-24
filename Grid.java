public class Grid
{
    //class members---------------------------
    //private
    String response;

    //main of class
    public static void main(String[] args)
    {
        new Grid();
    }

    //class constructor
    public Grid()
    {
        boolean done = false;
        
        output("\u000c"); //clears output terminal before execution

        //call methods
        do
        {
            doProcess();
            response = input("Another? y/n: ");
            if (response.equalsIgnoreCase("n"))
            {
                done = true;
            }
            output("\u000c");
        }while(!done);
        output("Goodbye!!");
    }


    //class methods---------------------------
    //method header
    public void doProcess()
    {
        int rows, columns;
        
        rows = inputInt("Enter number of rows: ");
        columns = inputInt("Enter number of columns: ");
        displayGrid(rows, columns);
    }

    public void displayGrid(int rows, int columns)
    {
        for(int r = 0; r < rows; r++)
        {
            //top
            output("+");
            for(int c = 0; c < columns; c++)
            {
                output("-+");
            }
            output("\n");
            //middle
            output("|");
            for(int c = 0; c < columns; c++)
            {
                output(" |");
            }
            output("\n");
        }
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
