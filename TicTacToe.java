//Create this class as a Venture EasyIO class.
//Implement the code that follows.
//Test it. Personalize it.
//don't forget about numMoves
public class TicTacToe
{
    //members----------------------------------------------------
    private int NUMCOLS;  
    private int NUMROWS, oneTwo;  
    private String[][] gameBoard; //2-d array
    private int numMoves, size;
    private char xO = 'x';


    //methods----------------------------------------------------
    //main method
    public static void main(String[] args)
    {
        new TicTacToe();
    }
    
    //method -- class constructor
    public TicTacToe()
    {
        boolean ready = true;
        int yesNo;
        output("\u000C"); 
        while (ready)
        {
            welcome(); //choose 1 or 2 player
            setUpBoard();             //find size of gameboard
            if ((oneTwo == 1)||(oneTwo ==2)){
                 getXO();
                 if (xO == 'x') playGameSingleX();
                 else playGameSingleO();
            }

            
            if (oneTwo==2)
                playGameMulti();
            yesNo = inputInt("Press 1 to play again, or 0 to quit: "); //again?
            if (yesNo != 1) ready = false;        
        }
        
            
        output("\n\nGame Over.....");
    }
    //method
    public void getXO(){
        
        boolean valid=false;
        String inVal;
        
        do {
            inVal=input("Please enter the token you want to play as, X or O: ");
            if ((inVal.equalsIgnoreCase("x"))||(inVal.equalsIgnoreCase("o"))){valid = true;}
        } while (!valid);
        xO = inVal.charAt(0);
    }
    //method
    public void playGameSingleX(){ //if player chooses to be X
        boolean done;

        done = false;
        numMoves = 0;
        do
        {
            //get player1 move, then get player2 move
            displayBoard(); //output current state
            playMove("X");
            displayBoard();
            done = testGameOver();
            if (!done) //Al the AI goes in here playing for O
            {
                alO("O");
                displayBoard();
                done = testGameOver();
            }
        }while(!done);
    }
    
    public void alO(String token){
        int row = 1, col = 1;
        boolean done = false;
            if ((size == 3)&&((gameBoard[row][col].equalsIgnoreCase(" ")))){gameBoard[row][col]=token;}
        
            else {
                for (row=0; row<NUMROWS; row++){
                for(col = 0; col<NUMCOLS; col++){
                    if (rowBlocker()==true){gameBoard[row][col]=token; col=NUMCOLS;}
                    else if (colBlocker()==true){gameBoard[row][col]=token;col=NUMCOLS;}
                    else if (diagonalBlocker()==true){gameBoard[row][col]=token;col=NUMCOLS;}
                }
            }
            gameBoard[row][col]=token;
        }
        numMoves();
    }
    
    public boolean rowBlocker(){ //not done
        int row, col, count = 0;
        for (row=0; row<NUMROWS; row++){
            for(col = 0; col<NUMCOLS; col++){
                if (gameBoard[row][col].equalsIgnoreCase(token))
                count++;
            }
            if(count==NUMCOLS)return true;
            
        }
        return false;
    }
    
    public boolean colBlocker()//not done
    {
        //checks for a column win
        //complete this method
        int row, col, count=0;
        for (col=0; col<NUMCOLS; col++){
            for(row = 0; row<NUMROWS; row++){
                if (gameBoard[row][col].equalsIgnoreCase(token))
                count++;
            }
            if(count==NUMROWS)return true;
            
        }
        return false;
    }
    
    public boolean diagonalBlocker() //not done
    {
        int row, col, count1, count2 = 0;

        //test main diagonal '\'
        count1 = 0;
        for (row=0; row<NUMROWS; row++)
        {
            if (gameBoard[row][row].equalsIgnoreCase(token))
                count1++;
        }
        if (count1==NUMROWS)
            return true;

        //test other diagonal '/'
        //finish code
        for (row=NUMROWS-1; row>-1; row--)
        {
            if (gameBoard[row][row].equalsIgnoreCase(token))
                count2++;
        }
        if (count2==NUMROWS)
            return true;
        return false;
    }
    public void playMove(String token)
    {
        int row, col;

        do
        {
            output("\n\nPlayer-"+token+"....");
            output("Enter the row and column location of your next move.\n");
            row = inputInt("row = ");
            row--;
            col = inputInt("col = ");
            col--;
        }while(!validMove(row,col));
        gameBoard[row][col]=token;        
        numMoves();
    }
    
    public boolean validMoveAI(int row, int col)
    {
        if (((row <NUMROWS) && (row>=0))&&((col<NUMCOLS)&&(col>=0)))
        {
            if (gameBoard[row][col].equalsIgnoreCase(" "))
                return true;
        }
        return false;
        }
    
    public boolean validMove(int row, int col)
    {
        if (((row <NUMROWS) && (row>=0))&&((col<NUMCOLS)&&(col>=0)))
        {
            if (gameBoard[row][col].equalsIgnoreCase(" "))
                return true;
            else
                output("That position is already occupied\n");
        }
        else
            output("Invalid move. That position is not on the game board\n");
        return false;
    }
    public void playGameSingleO(){ //if player chooses to be O
        boolean done;

        done = false;
        numMoves = 0;
        do
        {
            displayBoard();
            playMove("X"); // change here for Al playing x
            displayBoard();
            done = testGameOver();
            if (!done) //player goes here playing for O
            {
                playMove("O");
                displayBoard();
                done = testGameOver();
            }
        }while(!done);
    }
    
    public void alX(){
        
    }
    
    //method
    public void welcome(){
        
        boolean validOption = false;
        while(!validOption)
        {
        oneTwo = inputInt("Enter 1 to play against Al the AI or 2 to play with one of your friends in the room: ");
        if ((oneTwo!=1)&&(oneTwo!=2)) output("\nThis is not one of the options. Please enter a valid option.\n\n");
        else validOption=true;
    }
    }
    
    //method
    public void playGameMulti()
    {
        boolean done;

        done = false;
        numMoves = 0;
        do
        {
            //get player1 move, then get player2 move
            displayBoard();
            playMove("X");
            displayBoard();
            done = testGameOver();
            if (!done)
            {
                playMove("O");
                displayBoard();
                done = testGameOver();
            }
        }while(!done);
    }

    //method
    public boolean testGameOver()
    {
        //check gameboard to determine game over
        if ((rowWin("X"))||(colWin("X"))||(diagonalWin("X")))
        {
            output("\n\nX-wins\n\n");
            return true;
        }
        if ((rowWin("O"))||(colWin("O"))||(diagonalWin("O")))
        {
            output("\n\nO-wins\n\n");
            return true;
        }
        if (draw())
        {
            output("\n\nDRAW...Bummer, no winners. \n\n");
            return true;
        }
        return false;       
    }

    //method
    public boolean rowWin(String token)
    {
        //checks for a row win
        //complete this method
        int row, col, count = 0;
        for (row=0; row<NUMROWS; row++){
            for(col = 0; col<NUMCOLS; col++){
                if (gameBoard[row][col].equalsIgnoreCase(token))
                count++;
            }
            if(count==NUMCOLS)return true;
            
        }
        
        
        return false;
    }


    //method
    public boolean colWin(String token)
    {
        //checks for a column win
        //complete this method
        int row, col, count=0;
        for (col=0; col<NUMCOLS; col++){
            for(row = 0; row<NUMROWS; row++){
                if (gameBoard[row][col].equalsIgnoreCase(token))
                count++;
            }
            if(count==NUMROWS)return true;
            
        }
        return false;
    }

    //method
    public boolean diagonalWin(String token)
    {
        int row, col, count1, count2 = 0;

        //test main diagonal '\'
        count1 = 0;
        for (row=0; row<NUMROWS; row++)
        {
            if (gameBoard[row][row].equalsIgnoreCase(token))
                count1++;
        }
        if (count1==NUMROWS)
            return true;

        //test other diagonal '/'
        //finish code
        for (row=NUMROWS-1; row>-1; row--)
        {
            if (gameBoard[row][row].equalsIgnoreCase(token))
                count2++;
        }
        if (count2==NUMROWS)
            return true;
        return false;
    }

    //method
    public boolean draw()
    {
        //Check all gameboard[row][col] symbols. 
        //If none of them are blanks, then the game is a draw. 
        //      return true;
        if (numMoves < (NUMROWS * NUMCOLS))
            return false;
        else
            return true;
    }

    //method
    public void setUpBoard()
    {
        int row, col;
        
        do
        {
            size = inputInt("Enter a valid size of the tic-tac-toe grid: ");
        }while((size < 2)  ||  (size > 7));
        NUMROWS = size;
        NUMCOLS = size;
        gameBoard = new String[NUMROWS][NUMCOLS];

        for(row=0; row<NUMROWS; row++)
        {
            for (col=0; col<NUMCOLS; col++)
                gameBoard[row][col]=" ";
        }
    }

    public void displayBoard()
    {
        int row;       

        output("\u000C");   //clears output screen
        output("\n\nCurrent Board\n\n");
        for(row=0; row<NUMROWS; row++)
        {
            //vertical lines
            verticalLines(row);
            if (row<NUMROWS-1)
            {
                horizontalLines();
            }
        }
    }

    //method
    public void verticalLines(int row)
    {
        int col;

        for (col=0; col<NUMCOLS; col++)
        {
            output(" "+gameBoard[row][col]);
            if (col<NUMCOLS-1)
                output(" |");
            else
                output("\n");
        }
    }

    //method
    public void horizontalLines()
    {
        int col;

        for (col=0; col<NUMCOLS; col++)
        {
            output("---");
            if (col<NUMCOLS-1)
                output("-");
            else
                output("\n");
        }    
    }

    //method
    

    public void numMoves() {numMoves++;}
    
    //method

    
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
            //output("\nNot an integer!!!\n");
            //input("press <return> to continue");
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
