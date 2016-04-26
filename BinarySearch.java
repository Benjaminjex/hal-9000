public class BinarySearch
{
    //class members---------------------------
    //private
    boolean done;
    int [] numList;
    int listSize;
    

    //main of class
    public static void main(String[] args)
    {
        new BinarySearch();
    }

    
    //class constructor
    public BinarySearch()
    {
        String response;
        int option;
        
        
        done = false;
        //call methods
        systemInitializedList();
        output("\u000c");
        output("Welcome!!!!!!!!!!!!\n\n");
        
        do
        {
            //output("\u000c");

            input("\n\npress <return> to continue...");
            displayMenu();
            option = getMenuOption();
            processOption(option);
        }while (!done);
        output("\u000c");
        output("Program done!!!!!");
    }


    //class methods---------------------------
    //method header
    public void getList()
    {
        output("\u000c");
        listSize = inputInt("Enter list size: ");
        numList = new int [listSize];
        
        for (int i = 0; i < listSize; i++)
        {
            numList[i] = inputInt("Enter numList[" + i + "] = ");
        }
    }
    
    
    public void systemInitializedList()
    {
        listSize = 20;
        numList = new int[] {1,3,2,5,77,4,8,9,21,15,13,31,25,52,47,74,98,89,12,51};
    }
    
    
    public void displayMenu()
    {
        output("\u000c");
        output("MENU\n");
        output("-------------------------\n");
        output("1\tSequential Search\n");
        output("2\tBinary Search\n");
        output("3\tGet New List (user input)\n");
        output("4\tGet System Initialized List\n");
        output("5\tDisplay List\n");
        output("6\tQuit\n\n");
    }
    
    
    public int getMenuOption()
    {
        int opt;
        
        do
        {
           opt = inputInt("Enter valid option: ");
        }while ((opt<1) || (opt>6));
        
        return opt;
    }
    
    
    public void processOption(int option)
    {
        switch (option)
        {
            case    1   :   sequentialSearch();
                            break;
            case    2   :   binarySearch();
                            break;
            case    3   :   getList();
                            break;
            case    4   :   systemInitializedList();
                            break;
            case    5   :   displayList();
                            break;
            case    6   :   done = true;
                            break;
        }
    }
    
    
    public void sequentialSearch()
    {
        int searchKey, i;
        boolean found;
     
        output("\u000c");
        displayList();
        searchKey = inputInt("Enter search value: ");
        found = false;
        i = 0;
        while ((!found) && (i < listSize))
        {
            if (numList[i] == searchKey)
                found = true;
            else
                i = i + 1;
        }
        if (found)
            output(searchKey + " found at position " + i);
        else
            output("Not found!");
    }

    
    public void binarySearch()
    {
        sortList();
        boolean exit = false, found = false;
        int bott = listSize - 1, top = 0, loc;
        int sK, ex1t;
        
        

        output("\u000c");
        displayList();
        sK = inputInt("Enter search value: ");
        loc = ((top + bott)/2);      
        
        while(!found){
            loc = ((top + bott)/2);
            if (numList[loc] == sK)
            {
                output(sK + " found at position " + loc);
                input("\n\npress <return> to continue...");
                found = true;
            }
            else if (numList[loc] < sK) top = loc - 1;
            else if (numList[loc] > sK) bott = loc + 1;
            else if (top>=bott) {
                input("Not found!\n\n press <return> to continue...");
                found = true;
            }
            else output("Broke");
        }
    }
    
    
    public void sortList()
    {
        boolean sorted;
        int temp;
        
        sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < listSize - 1; i++)
            {
                if (numList[i] > numList[i+1])
                {
                    swap(i, i+1);
                    sorted = false;
                }
            }
        }
    }

    
    public void swap(int first, int second)
    {
        int temp;
        
        temp = numList[first];
        numList[first] = numList[second];
        numList[second] = temp;
    }
    
    
    public void displayList()
    {
        output("\n\nHere is the list...\n");
        for (int i = 0; i < listSize; i++)
        {
            output("[" + i + "]\t" + numList[i] + "\n");
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
