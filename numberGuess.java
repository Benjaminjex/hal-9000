public class numberGuess
{
    //class members---------------------------
    //private
    boolean donePlayAgain, gameOver;
    String responsePlayAgain;
    int mysteryNumber, lowClose, highClose, numberGuessed, ct, mysNumChange, highScore;
   
    //main of class
    public static void main(String[] args)
    {
        new numberGuess();
    }

    //class constructor
    public numberGuess()
    {
        output("\u000c"); //clears output terinal before execution
        //call methods
        mysteryNumber = 34;
        mysNumChange = 0;
        welcome();
        
        donePlayAgain=false;
        while (!donePlayAgain)
        {
            mysNumChange = mysNumChange + 1;
            highScore = 0;
            playGame();
            highScore();            
            responsePlayAgain = input("\nWould you like to try again?  y/n: ");
            output("\n");
            if(responsePlayAgain.equalsIgnoreCase("y"))
            {
                output("\u000c");
            }
            else
            {
                donePlayAgain=true;
                output("\u000c");            
                output("Goodbye!!");
            }
        }
    }

    //class methods---------------------------
    //method header
    public void welcome()
    {
        output("Welcome to Number Guesser!\n");
        input("\n<press return when ready>");
        output("\u000c");
    }
    
    public void playGame()
    {
        if ((mysNumChange != 0)&&(mysteryNumber < 40)&&(mysteryNumber > 30))
        {
            mysteryNumber = mysteryNumber + 24;
        }
        else if ((mysNumChange != 0)&&(mysteryNumber < 100)&&(mysteryNumber > 60))
        {
            mysteryNumber = mysteryNumber - 17;
        }
        else if(mysteryNumber < 50) {
            mysteryNumber = mysteryNumber + 18;
        } 
        else if (mysteryNumber > 49){
            mysteryNumber = mysteryNumber - 11;
        }
        lowClose = mysteryNumber - 10;
        highClose = mysteryNumber + 10;
        gameOver = false;
        ct = 0;
        while(!gameOver)
        {
            ct = ct + 1;
            getNumberGuessed();
            checkNumberGuessed();
        }
    }
    
    public void highScore() {
        if (highScore <= ct) {
            highScore = ct;
        }
        output("\nYour highscore is: "+highScore+" guesses.");
    }
    
    public void getNumberGuessed()
    {
        numberGuessed = inputInt("Guess a whole number between 1 and 100: ");
        output("\n");
        if((numberGuessed < 1) || (numberGuessed > 100))
        {
            output("This number is less than 1 or more than 100\n\n");
        }
    }
    
    public void checkNumberGuessed()
    {
        if((lowClose <= numberGuessed) & (numberGuessed < mysteryNumber))
        {
            output("Just a little higher!\n\n");
        }
        else if(numberGuessed < mysteryNumber)
        {
            output("Too low!\n\n");
        }
        
        else if((highClose >= numberGuessed) & (numberGuessed > mysteryNumber))
        {
            output("Just a little lower!\n\n");
        }
        else if(numberGuessed > mysteryNumber)
        {
            output("Too high!\n\n");
        }
        else
        {
            output("\nCorrect! The answer is " + mysteryNumber + ". It took you " + ct + " tries to guess the number.\n");
            gameOver=true;
        }
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
