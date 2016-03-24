package completedClasses;

//Computer Programming, 9-30-15.
public class PrimeNumbers
{
    //class members---------------------------
    //private
    int option;
    String response;
    boolean done;

    //main of class
    public static void main(String[] args)
    {
        new PrimeNumbers();
    }

    //class constructor
    public PrimeNumbers()
    {
        output("\u000c"); //clears output terminal before execution

        //call methods
        done = false;
        while (!done)
        {
            getOption();
            if (option == 1)
            {
                checkPrime();
                doAgain();
            }
            else if(option == 2)
            {
                doProcess();
                doAgain();
            }
        }
        output("\u000c");
        output("Goodbye!!");
    }


    //class methods---------------------------
    //method header
    public void getOption()
    {
        //add a while loop
        output("Menu of Options\n------------------------\n\nOption            Action\n\n------------------------\n\n   1\tOne Number\n   2\tList\n\n");
        option = inputInt("Enter your option: ");
        if (option == 1)
        {
            output("\nYou entered option " + option + ", One Number\n\n");
        }
        else if(option == 2)
        {
            output("\nYou entered option " + option + ", List\n\n");
        }//what happens if option does not equal 1 or 2?
        input("press <return> to continue");
        output("\u000c");
    }
    
    public void doAgain()
    {
        response = input("\nAnother? y/n: ");
        if (response.equalsIgnoreCase("n"))
            {
                done = true;
            }
            else
            {
                output("\u000c");
            }
    }
    
    public void checkPrime()
    {
        int number;
        
        number = inputInt("Enter your number: ");
        if (primeNumber(number))
        {
            output(number + " is prime.\n\n");
        }
        else
        {
            output(number + " in not prime.\n\n");
        }
    }
    
    public void doProcess()
    {
        int maxNumber, primeCt, yesNo;
        boolean areYouSure;
        yesNo = 0;
        areYouSure = false;
        
        output("Here we go....\n\n");
        primeCt = 0;
        maxNumber = inputInt("Enter the max: ");
        if (maxNumber > 10000) {           
            /*yesNo = inputInt("This number will take a while to process. \n\nAre you sure you want to proceed? y/n: ");
            if (response.equalsIgnoreCase("n"))
            {
                yesNo = 1;
            }
            else { yesNo = 0;}
            
            if (yesNo == 1) {
                areYouSure = true;
            }
            */
            //while (areYouSure) {
                for(int n = 2; n <= maxNumber; n++) {
                      if (primeNumber(n))
                      {
                            primeCt = primeCt + 1;
                            output(n + "\t");
                               //formatting...
                            if ((primeCt % 7) == 0)
                            {
                                output("\n");
                            }
                      }
                    }
            //}
        }
        else {
            for(int n = 2; n <= maxNumber; n++)
        {
            if (primeNumber(n))
            {
                primeCt = primeCt + 1;
                output(n + "\t");
                //formatting...
                if ((primeCt % 7) == 0)
                {
                    output("\n");
                }
            }
        }
        }
        output("\n\nThere are " + primeCt +"\n");
        output("prime numbers up to " + maxNumber + "\n\n"); 
    }

    public boolean primeNumber(int n)
    {
        double dNum;
        int num;
        
        dNum = Math.sqrt(n);
        num = (int) dNum;
        for (int i = 2; i <= num; i++)
        {
            if ((n % i) == 0)
            {
                return false;
            }
        }
        return true;
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