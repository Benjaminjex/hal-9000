

public class SequentialSearch
{
    //class members---------------------------
    //private
    boolean done;
    int [] numList;
    int maxSize;
    

    //main of class
    public static void main(String[] args)
    {
        new SequentialSearch();
    }

    //class constructor
    public SequentialSearch()
    {
        String response;
        
        getList();
        displayList();
        done = false;
        //call methods
        do
        {
            output("\u000c");
            search();
            response = input("\n\nContinue? (y/n) ");
            if (response.equalsIgnoreCase("n"))
            {
                done = true;
            }
        }while (!done);
        output("\u000c");
        output("Program done!!!!!");
    }


    //class methods---------------------------
    //method header
    public void getList()
    {
        output("\u000c");
        maxSize = inputInt("Enter list size: ");
        numList = new int [maxSize];
        
        for (int i = 0; i < maxSize; i++)
        {
            numList[i] = inputInt("Enter numList[" + i + "] = ");
        }
    }
    
    public void search()
    {
        int searchElement;
        boolean Found;
        int i;
        searchElement = inputInt("Enter search value: ");
        Found = false;
        i = 0;
        while((!Found)&&(i < maxSize))
        {
            if(numList[i] == searchElement) Found = true;
            else i = i + 1;
        }
        if(Found) output(searchElement + " Found at position " + i);
        else output ("Not Found!");
    }

    public void displayList()
    {
        output("\n\nHere is the list...\n");
        for (int i = 0; i < maxSize; i++)
        {
            output(numList[i] + "\n");
        }
        output("\n\n");
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
