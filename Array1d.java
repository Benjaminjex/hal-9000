package completedClasses;

public class Array1d
{
    //class members---------------------------
    //private
    String [] name;
    String another;
    int size;
    boolean done = true;

    //main of class
    public static void main(String[] args)
    {
        new Array1d();
    }

    //class constructor
    public Array1d()
    {
        output("\u000c"); //clears output terinal before execution
        while(done){
            boolean large = true;
                    
            do {
                size = inputInt("Enter number of values: ");
                if (size>50) {
                    output("\nYou don't want to do that.\n");
                    large = true;
                }
                else {large = false;}
            }while(large);
            name = new String [size];
            //call methods
            fillArray();
            displayArray();
            displayArrayReverseOrder();
            sortArray();
            doAnother();
        }
    }


    //main methods---------------------------
    public void fillArray() {
        for (int i=0; i<size; i++) {
            name[i] = input("Enter value: ");
        }
    }
    
    public void displayArray() {
        output("\nDisplayed in order of input: ");
        for (int i = 0; i<size; i++) {
           output(name[i]+(" "));
        }
    }

    public void displayArrayReverseOrder(){
        output("\nDisplayed in reverse order of input: ");
        for (int i = size - 1; i >= 0; i--) {
           output(name[i]+(" "));
        }
    }
    
    public void sortArray(){
        String temp;
        boolean sortArrayDone = false;
        
        output("\nDisplayed alphabetically: ");
          
        while(!sortArrayDone) {
            sortArrayDone = true;
            for (int i = 0; i < size-1; i++){
                  if (name[i].compareTo(name[i+1])>0) {
                      //swap(name[i], name[i+ 1]); 
                      temp = name[i];
                      name[i]=name[i+1];
                      name[i+1]=temp;
                      sortArrayDone = false;
                  }
            }
        }
        
        for (int i = 0; i<size; i++) {
           output(name[i]+(" "));
        }
    }
    
    public void swap(String first, String second){
        String temp;
        
        output("before swap "+first+ " ... "+ second);
        input("\npress <return>");
        temp = first;
        first = second;
        second = temp;
        output("after swap "+first+" ... "+second);
        input("\npress <return>");
    }
    
    public void doAnother()
    {
        another = input("\n\nAnother? y/n: ");
        if (another.equalsIgnoreCase("y"))
        {
            done = true;
        }
        else {done = false;}
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