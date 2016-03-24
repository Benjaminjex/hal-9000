package completedClasses;
/*Create the necessary methods.
 *Menu  Option 1 -- Demonstrate if-else
 *      option 2 -- Demonstrate a while-loop
 *      Option 3 -- Demonstrate a for-loop
 *      Option 4 -- quit program
 *      
 *Use/modify the switch-case to handle each of the options.
 *Create a method to handle each option.
 */ 

public class PracticeSampleSolution
{
    //class members---------------------------
    //private
    boolean programDone;
    int option;
    int maxOption;

    //main of class
    public static void main(String[] args)
    {
        new PracticeSampleSolution();
    }

    //class constructor
    public PracticeSampleSolution()
    {
        output("\u000c"); //clears output terminal before execution

        maxOption = 4;
        programDone = false;
        
        //call methods
        welcome();
        while (!programDone)
        {
            displayOptionMenu();
            getOption();
            processOption();            
        }
        endProgram();
    }


    //class methods---------------------------
    //method header
    public void welcome()
    {
        output("Welcome......\n\n");
        input("\n\npress<return>to continue...");
    }
    
    public void displayOptionMenu()
    {
        output("\u000c");
        output("MENU...\n\n");
        output("Option          Process\n");
        output("----------------------\n");
        output("1\t\tif-else\n");
        output("2\t\twhile-loop\n");
        output("3\t\tfor-loop\n");
        output("4\t\tQuit Program\n\n");
    }
    
    public void getOption()
    {
        boolean valid = false;
        
        while (!valid)
        {
            option = inputInt("Enter one of the menu options: ");
            if ((option > 0) && (option < maxOption + 1))
            {
                valid = true;
            }
            else
            {
                output("\nInvalid option. Please try again.\n");
            }
        }
        
    }
    
    public void processOption()
    {
        switch (option)
        {
            case    1   :   option1();
                            break;
            case    2   :   option2();
                            break;
            case    3   :   option3();
                            break;
            case    4   :   programDone = true;
                            break;
        };
    }
    
    public void option1()
    {
        int x;
        
        output("\nOption 1....\n");
        x = inputInt("Enter a value for x: ");
        if (x > 0)
        {
            output("x is positive\n");
        }
        else
        {
            output("x is zero or negative, or not an integer\n");
        }
        input("press<return>to continue...");
    }
    

    public void option2()
    {
        int x = 0;
        output("\nOption 2....\n");
        while (x < 7)
        {
            output("x = " + x + "\n");
            x++;
        }
        input("press<return>to continue...");
    }

   
    public void option3()
    {
        output("\nOption 3....\n");
        for(int x = 0; x < 7; x++)
        {
            output("x = " + x + "\n");
        }
        input("press<return>to continue...");
    }
    
    public void endProgram()
    {
        input("press<return>to continue...");
        output("\u000c");
        output("Program Done!!!!!!");        
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
