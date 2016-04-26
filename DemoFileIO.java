
//Mastery Aspect 13
//File i/o

import java.io.*;

public class DemoFileIO
{
    private PrintWriter outFile;
    private BufferedReader inFile;
    private String outFileName, inFileName;
    private int option;
    private boolean done;
 
    public static void main(String[] args) throws IOException
    {
        new DemoFileIO();
    }

    public DemoFileIO() throws IOException
    {        
        output("\u000c");
        input("press [Enter] to begin demo...File i/o");
        done = false;
        do
        {
            DisplayMenu();
            GetMenuOption();
            ProcessMenuOption();
            if (!done)
                input("press [Enter] to return to the menu of file options");            
        }while (!done);
        output("\n\ndemo File i/o -- complete....\n");
        output("\n");
    }
    
    public void DisplayMenu()
    {
        output("\u000c");
        output("MENU OF FILE OPTIONS:\n");
        output("Option      Action\n");
        output("----------------------------\n");
        output("  1         Create/Re-create File\n");
        output("  2         Add to File\n");
        output("  3         DisplayFile\n");
        output("  4         Quit File I/O\n\n");
    }
    
    public void GetMenuOption()
    {
        do
        {
            option = inputInt("Enter your option (a # between 1 and 4 inclusively): ");
        }while ((option < 1) || (option > 4));
    }
    
    public void ProcessMenuOption() throws IOException
    {
        switch(option)
        {
            case 1 : SaveToFile(false);
                     break;
            case 2 : SaveToFile(true);
                     break;            
            case 3 : ReadFromFile();
                     break;            
            default: done = true;
                     break;                     
        }
    }
    
    //method for file output
    public void SaveToFile(boolean addToFile) throws IOException
    {
        String stuff;
        
        output("Ready to save something to a file.\n");
        outFileName = input("Enter the file's name: ");
        try
        {
            //open or create a file
            outFile = new PrintWriter(new FileWriter(outFileName+".txt", addToFile));
            output("\nType -999 to quit entering information.\n\n");
            do
            {
                stuff = input("Enter a line of stuff to save: ");
                if (!stuff.equals("-999"))
                    outFile.println(stuff);                
            }while(!stuff.equals("-999"));
            outFile.close();    //close the file
        }
        catch (IOException e)
        {
            output("File cannot be opened....ABORT.");
        }
    }
    
    //method for file input
    public void ReadFromFile() throws IOException
    {
        String fileStuff;
        
        output("Ready to display the contents of a file.\n"); 
        inFileName = input("Enter the file's name: ");        
        try
        {            
            //open the file for reading
            inFile = new BufferedReader(new FileReader(inFileName+".txt"));
            while (((fileStuff = inFile.readLine()) != null))
            {
                output(fileStuff+"\n");
            }
            output("EOF has been reached.\n");
            inFile.close(); //close the file
        }
        catch (FileNotFoundException e)
        {
            output("Invalid input file name...ABORT.");
        }            
    }
    








    
     //VentureEasyIO
     static void output(String info) {  System.out.print(info); }
     static void output(double info) {  System.out.println(info); }
     static void output(int info)    {  System.out.println(info); }
  
     static int inputInt(String Prompt)
     {  
         int result=0;
         try{result=Integer.parseInt(input(Prompt).trim());}
         catch (Exception e){result = 0;}
         return result;
     }
     static double inputDouble(String Prompt)
     {  
         double result=0;
         try{result=Double.valueOf(input(Prompt).trim()).doubleValue();}
         catch (Exception e){result = 0;}
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
      static String input() { return input("");  }
}