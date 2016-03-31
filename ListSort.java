public class ListSort
{
    //class members---------------------------
    //private
    boolean done;
    int [] numList;
    int listSize;
    

    //main of class
    public static void main(String[] args)
    {
        new ListSort();
    }

    //class constructor
    public ListSort()
    {
        String response;
        
        done = false;
        //call methods
        do
        {
            output("\u000c");
            getList();
            sort();
            displayList();
            response = input("Continue? (y/n) ");
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
        listSize = inputInt("Enter list size: ");
        numList = new int [listSize];
        
        for (int i = 0; i < listSize; i++)
        {
            numList[i] = inputInt("Enter numList[" + i + "] = ");
        }
    }
    
    public void sort()
    {
        boolean sorted = false;

        while (!sorted)
        {
            sorted = true;
            for(int i = 0; i < listSize-1; i++)
            {
                if (numList[i] > numList[i+1])
                {
                    int temp;
                    int first;
                    int second;
        
                    temp = numList[i];
                    numList[i] = numList[i+1];
                    numList[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public void swap(int first, int second)    
    {
        
    }
    
    public void displayList()
    {
        output("\n\nHere is the list...\n");
        for (int i = 0; i < listSize; i++)
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
