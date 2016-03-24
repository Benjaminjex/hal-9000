package completedClasses;

public class GPA_Calculator
{
    //class members---------------------------
    //private
    int numberOfClasses;
    double gpa, totalGradePts;
    boolean done;
    String letterGrade;
    String response;
    //main of class
    public static void main(String[] args)
    {
        new GPA_Calculator();
    }

    //class constructor
    public GPA_Calculator()
    {
        output("\u000c"); //clears output terinal before execution

        output("Welcome to the GPA Calculator!\n\n");
        
        done = false;
        while(!done)
        {
            doProcess();
        }
    }
    
    public void doProcess()
    {
        getNumberOfClasses();
        getTotalGradePts();
        gpa = totalGradePts / numberOfClasses;
        
        output("Your gpa is " + gpa + "\n");
        doAgain();
    }

    public void doAgain()
    {
        response = input("Calculate Another? y/n: ");
        if (response.equalsIgnoreCase("y"))
        {
             output("\u000c");
        }
        else
        {
            done = true;
            output("\u000c");
            output("Goodbye!");            
        }
        numberOfClasses = 0;
    }
    //class methods---------------------------
    //method header
    public void getNumberOfClasses()
    {
        while(numberOfClasses < 1)
        {
            numberOfClasses = inputInt("Enter number of classes: ");
            //zero classes possible
            output("\n");
        }
    }

    
    public void getTotalGradePts()
    {
        int classCount;     //local variable declaration
        boolean letterLoop;
        totalGradePts = 0;
        classCount = 0;
        while (classCount < numberOfClasses)
        {
            getValidGrade();
            
            if (letterGrade.equalsIgnoreCase("A"))
            {
                totalGradePts = totalGradePts + 4.0;
            }
            else if (letterGrade.equalsIgnoreCase("A+"))
            {
                totalGradePts = totalGradePts + 4.0;
            }
            else if (letterGrade.equalsIgnoreCase("A-"))
            {
                totalGradePts = totalGradePts + 3.7;
            }
            else if (letterGrade.equalsIgnoreCase("B+"))
            {
                totalGradePts = totalGradePts + 3.3;
            }
            else if (letterGrade.equalsIgnoreCase("B"))
            {
                totalGradePts = totalGradePts + 3.0;
            }
            else if (letterGrade.equalsIgnoreCase("B-"))
            {
                totalGradePts = totalGradePts + 2.7;
            }
            else if (letterGrade.equalsIgnoreCase("C+"))
            {
                totalGradePts = totalGradePts + 2.3;
            }
            else if (letterGrade.equalsIgnoreCase("C"))
            {
                totalGradePts = totalGradePts + 2.0;
            }
            else if (letterGrade.equalsIgnoreCase("C-"))
            {
                totalGradePts = totalGradePts + 1.7;
            }
            else if (letterGrade.equalsIgnoreCase("D+"))
            {
                totalGradePts = totalGradePts + 1.3;
            }
            else if (letterGrade.equalsIgnoreCase("D"))
            {
                totalGradePts = totalGradePts + 1.0;
            }
            else if(letterGrade.equalsIgnoreCase("F"))
            {
                totalGradePts = totalGradePts + 0.00;
            }
            else
            {
                letterLoop=true;
                while(letterLoop)
                {
                    output("\n\nInvalid Character. Try Again\n\n");
                    getValidGrade();
                    letterLoop=false;
                }
            }
            
            classCount = classCount + 1;
        }
    }
    
    
    public void getValidGrade()
    {
        letterGrade = input("Please enter your next letter grade: ");
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