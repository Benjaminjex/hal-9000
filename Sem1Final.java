//Semester 1 Final:
//Implement this code. Fix the syntax and semantic (logic) errors.
//Compile and execute. Follow the directions provided on the 
//paper that is provided by your teacher.
public class Sem1Final
{
    //class members---------------------------
    //private
    int option;
    boolean done;
    String[] code = {"erg_", "va", "erb", "!", "a_e", "H", "ka", "_ta"};    
           
    
    //main of class
    public static void main(String[] args)
    {
        new Sem1Final();
    }

    //class constructor
    public Sem1Final()
    {
 
        //call methods
        done = false;
        do
        {
            output("\u000c"); //clears output terminal before execution
            displayMenu();
            option = getMenuOption();
            processMenuOption();
        }while (!done);
        output("\u000c");
        output("Program Done");
    }


    //class methods---------------------------
    //method header
    public void displayMenu()
    {
        output("MENU\n");
        output("----------------------\n");
        output("1\tCube a Number\n");
        output("2\tCheck 10\n");
        output("3\tExit\n");
    }

    
    
    
    public int getMenuOption()
    {
        option = inputInt("\nEnter menu option: ");
        return option;
    }
    
    public void processMenuOption()
    {
        switch(option)
        {
            case    1   :   process1();
                            break;
            case    2   :   process2();
                            break;
            case    3   :   quitProgram();
                            break;
            default     :   output("ERROR: Invalid option.\n\n");
                            input("press <return> to continue.");        
        }
    }
    
    public void process1()
    {
        int num, cubed;
        
        output("You have chosen to cube a number\n\n");
        num = inputInt("Input a whole number to have it cubed: ");
        cubed = num*num*num;
        output(num+" equals "+ cubed +" when cubed\n\n");
        input("press <return> to continue.");        
    }
    
    public void process2()
    {
        int check10;
        output("You have chosen to Check 10\n\n");
        
        check10 = inputInt("Enter a whole number and I will check it against the number 10: ");
        if(check10 < 10)output("\nThis number is less than 10\n\n");
        else if (check10>10)output("\nThis number is more than 10\n\n");
        else if (check10==10) output("\nThis number is 10\n\n");
        
        input("press <return> to continue.");
    }
    
    public void quitProgram()
    {
        done = true;
        decode();
        input("press <return> to continue.");
    }
    
    
    public void decode()
    {
        int [] descrambler = { 5, 1, 4, 0, 7, 2, 6, 3};
        
        for (int i = 0; i < 8; i++)
        {
            output( reversed( code[ descrambler[i] ] ) );
        }
        output("n\n\n");
    }
    
    
    public String reversed( String stuff)
    {
        String reversedStuff = "";
        
        for (int i = (stuff.length()-1); i >= 0; i--)
        {
            reversedStuff = reversedStuff + stuff.charAt(i);
        }
        return reversedStuff;
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
