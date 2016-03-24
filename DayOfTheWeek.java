package completedClasses;

public class DayOfTheWeek
{
    //class members---------------------------
    //private
    String another;
    boolean done, doneGetMonth, doneGetDay, doneGetYear;
    int day, year, month, weekday, monthLength, monthName, leapYear;
    
    //main of class
    public static void main(String[] args)
    {
        new DayOfTheWeek();
    }

    //class constructor
    public DayOfTheWeek()
    {              
        done = true;
        output("\u000c"); //clears output terinal before execution
        do 
        {
            getDate();
            processDate();
            displayDate();
            doAnother();
        } while(done);
        output("\u000c");
        output("Goodbye!!");
        //call methods
    }


    //class methods---------------------------
    public void getDate() //main method
    {        
        output("Enter any date and I'll tell you what day of the week that day is on!"); //dont forget 0
        getYear();
        getMonth();
        getDay();
        output("\n\nYou entered the date: " + month + "-" + day + "-" + year);
        input("\n\nPress <enter> to continue");
        output("\u000c");
    }
    
    public void getMonth() //Submethod of getDate
    {
        
        
        doneGetMonth = false;
        while (!doneGetMonth)
        {
            month= inputInt("\n\nInput the number of the MONTH of the date you want checked: ");
            if ((month > 12) || (month < 1))
            {
                output("\tThis is not a month");
            }
            else
            {
                switch (month)
                {
                    case 1 : ;
                    case 3 : ;
                    case 5 : ;
                    case 7 : ;
                    case 8 : ;
                    case 10 : ;
                    case 12 : monthLength = 31; break;
                    case 4 : ;
                    case 6 : ;
                    case 9 : ;
                    case 11 : monthLength = 30; break;
                }
                
                if ((month == 2)&&(leapYear == 0))
                {
                    monthLength = 28;
                }
                else if((month == 2)){monthLength = 29;}
                
                if (month == 1)
                {
                    output("\nYou entered the month of January which has " + monthLength + " days in it");
                }
                else if (month == 2)
                {
                    output("\nYou entered the month of February which has " + monthLength + " days in it");
                }
                else if (month == 3)
                {
                    output("\nYou entered the month of March which has " + monthLength + " days in it");
                }
                else if (month == 4)
                {
                    output("\nYou entered the month of April which has " + monthLength + " days in it");
                }
                else if (month == 5)
                {
                    output("\nYou entered the month of May which has " + monthLength + " days in it");
                }
                else if (month == 6)
                {
                    output("\nYou entered the month of June which has " + monthLength + " days in it");
                }
                else if (month == 7)
                {
                    output("\nYou entered the month of July which has " + monthLength + " days in it");
                }
                else if (month == 8)
                {
                    output("\nYou entered the month of August which has " + monthLength + " days in it");
                }
                else if (month == 9)
                {
                    output("\nYou entered the month of September which has " + monthLength + " days in it");
                }
                else if (month == 10)
                {
                    output("\nYou entered the month of October which has " + monthLength + " days in it");
                }
                else if (month == 11)
                {
                    output("\nYou entered the month of November which has " + monthLength + " days in it");
                }
                else if (month == 12)
                {
                    output("\nYou entered the month of December which has " + monthLength + " days in it");
                }
                doneGetMonth = true;
            }
        } 
    }
    
    public void getDay() //Submethod of getDate
    {
        doneGetDay = false;
        while (!doneGetDay)
        {
            day = inputInt("\n\nInput the DAY of the date you want checked: ");
            if ((day < 1)||(day > monthLength))
            {
                output("\tThis is not a day you can use in this month");
            }
            else
            { 
                output("\nYou entered day: " + day);
                doneGetDay = true;
            }
        } 
    }
    
    public void getYear() //Submethod of getDate
    {
        doneGetYear = false;
        while (!doneGetYear)
        {
            year= inputInt("\n\nInput the YEAR of the date you want checked: ");
            if (year > 9999)
            {
                output("\tWhy would you ever need to know this!!");
            }
            else if (year < 1)
            {
                output("\tPlease enter only the YEAR of the date you want checked");
            }
            else
            {
                if ((year % 4) != 0)
                {
                    leapYear = 0;
                    output("\nYou entered the year: " + year + "\tThis year is not a Leap Year");
                }
                else if ((year % 4) == 0)
                {
                    if (((year % 100) == 0) && ((year % 400) != 0))
                    {
                        leapYear = 0;
                        output("\nYou entered the year: " + year + "\tThis year is not a Leap Year");
                    }
                    else
                    {
                        leapYear = 1;
                        output("\nYou entered the year: " + year + "\tThis year is a Leap Year!");   
                    }
                }                                                
                doneGetYear = true;                
            }
        }     
    }
    
    
    
    public int processDate() //Submethod of processingDate
    {
        int weekday;
        
        if (month < 3)
        {
            month=month + 12;
            year=year - 1;
        }
        weekday=(((13*month+3)/5+day+year+year/4-year/100+year/400)%7)+1;
        
        return weekday;
    }
    
    public void displayDate() //main method
    {
        if ((processDate()) == 1)
        {
            output("The day of the week that " + month + "-" + day + "-" + year + " which is on a Monday.");
        }
        else if ((processDate()) == 2)
        {
            output("The day of the week that " + month + "-" + day + "-" + year + " which is on a Tuesday.");
        }
        else if ((processDate()) == 3)
        {
            output("The day of the week that " + month + "-" + day + "-" + year + " which is on a Wednesday.");
        }
        else if ((processDate()) == 4)
        {
            output("The day of the week that " + month + "-" + day + "-" + year + " which is on a Thursday.");
        }
        else if ((processDate()) == 5)
        {
            output("The day of the week that " + month + "-" + day + "-" + year + " which is on a Friday.");
        }
        else if ((processDate()) == 6)
        {
            output("The day of the week that " + month + "-" + day + "-" + year + " which is on a Saturday.");
        }
        else if ((processDate()) == 7)
        {
            output("The day of the week that " + month + "-" + day + "-" + year + " which is on a Sunday.");
        }
    }
    
    public void doAnother() //main method
    {
        another = input("\nAnother? y/n: ");
        if (another.equalsIgnoreCase("y"))
        {
            done = true;
        }
        else {done = false;}
        output("\u000c");
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
