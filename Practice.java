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

public class Practice
{
    //class members---------------------------
    //private
    boolean programDone,run1,run2,run3, wloop = false;
    int option, iloop=0, wloopExit=0, floop = 0;
    int maxOption;

    //main of class
    public static void main(String[] args)
    {
        new Practice();
    }

    //class constructor
    public Practice()
    {
        output("\u000c"); //clears output terminal before execution

        maxOption = 4;
        programDone = false;
        
        //call methods
        
        while (!programDone)
        {
            displayOptionMenu();
            getOption();
            processOption();        
            obeyOption();
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
        output("MENU...\n1. ITTT\n2. While true\n3. For these conditions\n4. Quit");
    }
    
    public void getOption()
    {
        boolean valid = false;
        
        while (!valid)
        {
            option = inputInt("\n\nEnter one of the menu options: ");
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
            case    4   :   programDone = true;
            case    3   :   run3 = true;    
                            break;
            case    2   :   run2 = true;  
                            break;
            case    1   :   run1 = true;  
                            break;
        };
    }
    
    public void obeyOption(){
        if (run1){run1();}
        else if(option==2){run2();}
        else if(option==3){run3();}
        else{output("help!");}
    }
    
    
    public void run1(){
        output("\u000c");
        output("This is an IfThisThenThat(ITTT) scenario");
        iloop = inputInt("\n\nInput a 1 to see what happens. If you want to. : ");
        if (iloop==1){input("\n\nThis is what happens when you enter 1. Good job. Press <return> to continue: ");}
        else{input("\n\nI guess you didn't want to find out. Press <return> to continue: ");}
        programDone = true;
    }
    
    public void run2(){
        output("\u000c");
        input("This is an until scenario. Press <return> to continue: ");
        while(!wloop){
            wloopExit = inputInt("\nPut in a number other than 0 to repeat the loop: ");
            if(wloopExit == 0){wloop =true;}
        }
        programDone = true;
    }
    
    public void run3(){
        output("\u000c");
        for(int d=0; d < 5; d++){
            input("This loop won't finish until it has gone 5 times. Press <return> to continue: ");
        }
        programDone = true;
    }
    
    public void endProgram()
    {
        input("\n\nPress <return> to continue...");
        output("\u000c");
        output("Goodbye!!");        
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
