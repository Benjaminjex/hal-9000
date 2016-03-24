package completedClasses.calendarContent;
public class Calendar
{
    //class members
    private int size, date, keyDate, dayOfWeek, nDaysInMonth;
    private int month, year;
    
    //main method
    public static void main(String[] args)
    {
        new Calendar();
    }
    
    //constructor method----------------------------------------
    public Calendar()
    {
        String response;
        boolean done;
        output("\u000c");
        output("Welcome to the Calendar Generator. Please put the window size at its maximum\n");
        done=false;
        do
        {
            process();
            response=input("Continue? y/n: ");
            if (!response.equalsIgnoreCase("y"))
                done=true;
        }while (!done);
        output("\u000c");
        output("Goodbye!!");
    }

    //method---------------------------------------------------
    public void process()
    {
        int n;
        DayOfWeek d;

        output("\u000c");
        d = new DayOfWeek();
        d.getDate();  
        month=d.retMonth();
        year=d.retYear();
        keyDate = d.retDay();
        n=d.calcDayOfWeek();
        n=n+1;      //correction for calendar; different from DayOfWeek class
        dayOfWeek=((n-(d.retDay()%7)+1)+7)%7;//calcDayOfWeek();          

        //Display the calendar
        date = 1;          //the first day of the month
        size = 20;
        calcDaysInMonth();//determines nDaysInMonth
        output("\n\n");
        displayMonth();
        output("\n\n");
        displayFirstWeek();
        displayRemainingWeeks();
    }
   
    //method---------------------------------------------------
    //use this method for formatting
    public String stringFormat(int nString)
    {
        int i;
        String blanks;
        
        blanks = "";    //initialized with an empty string (no space)
        for(i=0; i<(size-nString); i++)
            blanks = blanks + " ";
            
        return blanks;      //returns a string that consists of only blank spaces
    }
    
    //method---------------------------------------------------    
    public void calcDaysInMonth()
    {
        switch(month)
        {
            case 2  :   if ((year%4)==0)
                            nDaysInMonth=29;
                        else
                            nDaysInMonth=28;
                        break;
            case 1  :
            case 3  :
            case 5  :
            case 7  :
            case 8  :
            case 10 :
            case 12 :   nDaysInMonth=31;
                        break;
            default :   nDaysInMonth=30;
                        break;
        }
    }
    //method
    public void displayMonth() {
        if (month == 1) {output("\t\t\t\t\t\t\t\t\tJanuary");}
        else if (month == 2){output("\t\t\t\t\t\t\t\t\tFebruary");}
        else if (month == 3){output("\t\t\t\t\t\t\t\t\tMarch");}
        else if (month ==4){output("\t\t\t\t\t\t\t\t\tApril");}
        else if (month ==5){output("\t\t\t\t\t\t\t\t\tMay");}
        else if (month ==6){output("\t\t\t\t\t\t\t\t\tJune");}
        else if (month ==7){output("\t\t\t\t\t\t\t\t\tJuly");}
        else if (month ==8){output("\t\t\t\t\t\t\t\t\tAugust");}
        else if (month ==9){output("\t\t\t\t\t\t\t\t\tSeptember");}
        else if (month ==10){output("\t\t\t\t\t\t\t\t\tOctober");}
        else if (month ==11){output("\t\t\t\t\t\t\t\t\tNovember");}
        else if (month ==12){output("\t\t\t\t\t\t\t\t\tDecember");}
        output(" "+year);
    }
    
    //method---------------------------------------------------    
    public void displayFirstWeek()
    {
        int nDay;   
        String nString; //used only for formatting
        
        putHeadLine();
        output("|");
        for(nDay=0; nDay<7; nDay++)  //?????
        {
            if((dayOfWeek <= nDay)&&(date<=nDaysInMonth))
            {
                nString=Integer.toString(date);
                if (date==keyDate)
                {
                    nString="*"+nString ;
                    output(stringFormat(nString.length()) +"*"+ date);  //formatted
                }
                else
                    output(stringFormat(nString.length()) + date);  //formatted
                date++;
            }
            else
                output(stringFormat(1)+" ");    //formatting for blank days
            output("|");
        }
        output("\n");
        putBrokenLine();
        putSolidLine();
    }

    //method---------------------------------------------------    
    public void displayRemainingWeeks()
    {
        while (date<=nDaysInMonth)
        {
            putDateLine();
            putBrokenLine();                     
            putSolidLine();
        }
    }
    
    //method---------------------------------------------------    
    public void putHeadLine()
    {
        String [] dayName;
        int dayNum;
        
        //a shortcut to initializing an array
        dayName =new String[]{"Sun", "Mon", "Tues", "Wed", "Thu", "Fri", "Sat"};
        for(dayNum=0; dayNum<7; dayNum++)
        {
            output(" " + stringFormat(dayName[dayNum].length()) + dayName[dayNum]);
        }
        output("\n");
        putSolidLine();
    }
    
    //method---------------------------------------------------    
    public void putSolidLine()
    {
        int nDay, nSz;
        
        output("+");
        for(nDay=0; nDay<7; nDay++)
        {
            for(nSz=0; nSz< size; nSz++)
            {
                output("-");
            }
            output("+");
        }
        output("\n");
    }
    
    //method---------------------------------------------------
    public void putDateLine()
    {
        int nDay;
        String nString; //used to format
        
        output("|");
        for(nDay=0; nDay<7; nDay++)
        {
            //format
            if(date <= nDaysInMonth)
            {
                nString=Integer.toString(date);
                if (date==keyDate)
                {
                    nString="*"+nString ;
                    output(stringFormat(nString.length()) +"*"+ date);  //formatted
                }
                else
                    output(stringFormat(nString.length()) + date);  //formatted
            }
            else
               output(stringFormat(1)+" "); //formatting for blank days
            output("|");
            date++;            
        }
        output("\n");
    }
    
    //method---------------------------------------------------   
    public void putBrokenLine()
    {
        int nDay, nSz;
        int ht, maxHt=2;  //formerly a 3
        
        for (ht=0; ht<maxHt; ht++)
        {
            output("|");
            for(nDay=0; nDay<7; nDay++)
            {
                for(nSz=0; nSz<size; nSz++)
                {
                    output(" ");
                }
                output("|");
            }
            output("\n");
        } 
    }
    
    
    
    static void output(String info) {  System.out.print(info); }
    static void output(double info) {  System.out.print(info); }
    static void output(int info)    {  System.out.print(info); }
  
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