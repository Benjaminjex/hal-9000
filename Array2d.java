public class Array2d
{
    //variable declaration
    int numRows, numColumns;
    String [][] matrix;

    //main of class
    public static void main(String[] args)
    {
        new Array2d();
    }

    //class constructor
    public Array2d()
    {
        output("\u000c"); //clears output terminal before execution

        //call methods
        fillMatrix();
        displayMatrix();
    }

    //class methods---------------------------
    public void fillMatrix(){ //fillMatrix main
        numRows = inputInt("Enter the number of ROWS in the matrix: ");
        numColumns = inputInt("Enter the number of COLUMNS in the matrix: ");
        output("Input values LEFT to RIGHT, and TOP to BOTTOM\n\n");
        matrix = new String [numRows] [numColumns];
        
        for(int r = 0; r<numRows; r++){
            for(int c = 0; c < numColumns; c++){
                matrix [r] [c] = input("matrix["+r+"]["+c+"]= ");
            }
        }
    }
    
    public void displayMatrix(){ //displayMatrix main
        for(int r = 0; r<numRows; r++){
            output("\n");
            for(int c = 0; c < numColumns; c++){
                output("\t"+matrix [r] [c]);
            }
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
