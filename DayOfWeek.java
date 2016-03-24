public class DayOfWeek
{
    //class members
    int day, month, year, dayNum;    
    boolean leapYear;
    
    //main method
    public static void main(String[] args)
    {
        new DayOfWeek();
    }
    
    //constructor method
    public DayOfWeek()
    {
        //processAll();
    }

    //method---------------------------------------------------
    public void processAll()
    {
        boolean done;
        String response;

        done=false;
        do
        {
            processPart();
            response=input("Coninute? (y/n): ");
            if (!response.equalsIgnoreCase("y"))
                done = true;
        }while (!done);
    }

    //method---------------------------------------------------
    public void processPart()
    {
        output("\u000c");
        output("DayOfWeek Calculator.....\n");
        getDate();
        dayNum = calcDayOfWeek();
        output ("dayNum = "+calcDayOfWeek());
        displayDayOfWeek();
    }

    //method---------------------------------------------------
    public void getDate()
    {
        
        getYear();
        getMonth();
        getDay();
        //year=inputInt("Enter 4-digit year: ");
    }
 
    //method----------------------------------------------
    public void getYear()
    {
        leapYear = false;//declared as a class member, boolean
        year=inputInt("Enter 4-digit year: ");
        if ((year % 4) == 0)
            leapYear = true;
    }
    
    //method--------------------------------------------------- 
    public void getMonth()
    {
        boolean validMonth;
        
        validMonth = false;
        do
        {
            month = inputInt("Enter month: ");
            if ((month<1)||(month>12))
                output("Invalid month....Try again.");
            else
                validMonth = true;
        }while(!validMonth);
    }

    //method---------------------------------------------------
    public void getDay()
    {
        boolean validDay;
        
        validDay = false;
        do
        {
            day = inputInt("Enter day: ");
            if (month==2)
            {
                if ((day<1)||(((!leapYear)&&(day>28))||((leapYear)&&(day>29))))
                    output("Invalid day....Try again.");
                else
                    validDay = true;
            }
            else if (longMonth(month))
            {
                if((day<1)||(day>31))
                    output("Invalid day....Try again.");
                else
                    validDay = true;                
            }
            else
            {
                if((day<1)||(day>30))
                    output("Invalid day....Try again.");
                else
                    validDay = true;                                
            }
        }while(!validDay);   
    }

    //method---------------------------------------------------    
    public boolean longMonth(int month)
    {
       if((month == 1)||(month == 3)||(month == 5)||(month == 7)||(month == 8)||(month == 10)||(month == 12)) 
            return true;
       else
            return false;
    }
    
    //method---------------------------------------------------
    public int calcDayOfWeek()
    {
        int nd;

        if (month < 3)
        {
            month=month+12;
            year=year-1;
        }
        nd=((13*month+3)/5+day+year+year/4-year/100+year/400)%7;

        return nd;
    }

    //method---------------------------------------------------
    public void displayDayOfWeek()
    {
        switch (dayNum)
        {
            case 0 :    output ("Monday");
                        break;
            case 1 :    output ("Tuesday");
                        break;
            case 2 :    output ("Wednesday");
                        break;
            case 3 :    output ("Thursday");
                        break;
            case 4 :    output ("Friday");
                        break;
            case 5 :    output ("Saturday");
                        break;
            case 6 :    output ("Sunday");
                        break;
        }
    }

    //method---------------------------------------------------
    public int retMonth()
    {
        return month;
    }

    //method---------------------------------------------------
    public int retDay()
    {
        return day;
    }

    //method---------------------------------------------------
    public int retYear()
    {
        return year;
    }

    
    static void output(String info) {  System.out.println(info); }  
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
