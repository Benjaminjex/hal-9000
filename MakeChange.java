package completedClasses;

public class MakeChange
{
    //class members---------------------------
    //private
    double moneyGiven;
    double purchasePrice;
    double changeGiven;

    //main of class
    public static void main(String[] args)
    {
        new MakeChange();
    }

    //class constructor
    public MakeChange()
    {
        boolean done;
        String response;
        
        done = false;
        welcome();
        do
        {
            output("\u000c"); //clears output terminal before execution
            //call methods
            processAll();
            response = input("\nContinue? (y/n) ");
            if (!response.equalsIgnoreCase("y"))
                done = true;
        }while (!done);
        output("\n\nProgram Done!!! Goodbye!!!");
    }


    //class methods---------------------------
    //method header
    public void welcome()
    {
        output("\u000c");
        output("Welcome to Make Change\n\n");
        input("<press return when ready>");
    }
    
    public void processAll()
    {
       getPurchasePrice();
       getMoney();
       giveChange();
    }


    public void getPurchasePrice()
    {
        purchasePrice = inputDouble("Enter Purchase Price: ");
        output("price entered is $"+purchasePrice);
    }
    
    public void getMoney()
    {
        moneyGiven = inputDouble("\nMoney given: ");
        output("money given is $"+moneyGiven);
    }
    
    public void giveChange()
    {
        int iChange;
        int ct = 0;
        
        changeGiven = moneyGiven - purchasePrice;
        changeGiven = changeGiven * 100;
        iChange = (int) changeGiven;
        if ((iChange % 500) >= 0)
        {
            ct = denomCount(iChange, 500);
            displayDenom(ct, "Fives   ");
        }
        iChange = iChange - (ct * 500);
        if ((iChange % 100) >= 0)
        {
            ct = denomCount(iChange, 100);
            displayDenom(ct, "Ones    ");
        }
        iChange = iChange - (ct * 100);
        if ((iChange % 25) >= 0)
        {
            ct = denomCount(iChange, 25);
            displayDenom(ct, "Quarters");
        }
        iChange = iChange - (ct * 25);   
        if ((iChange % 10) >= 0)
        {
            ct = denomCount(iChange, 10);
            displayDenom(ct, "Dimes    ");
        }
        iChange = iChange - (ct * 10);
        if ((iChange % 5) >= 0)
        {
            ct = denomCount(iChange, 5);
            displayDenom(ct, "Nickels  ");
        }
        iChange = iChange - (ct * 5);
        if ((iChange % 1) >= 0)
        {
           ct = denomCount(iChange, 1);
           displayDenom(iChange, "Pennies  ");
        }
        iChange = iChange - (ct *1);
   }
    
        
    public int denomCount(int iChange, int iDenom)
    {
        return iChange / iDenom;
    }
    
    
    public void displayDenom(int ct, String denom)
    {
        output("\n" + denom + "\t\t" + ct);
    }
    //end of coding; not end of class


    //Easy IO methods-------------------------

    //methods for output
    static void output(String info) { System.out.print(info); }
    static void output(double info) { System.out.println(info); }
    static void output(int info)    { System.out.println(info); }

    //static void outputDecimalFormat(double info) {System.out.printf(info); }
    
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
