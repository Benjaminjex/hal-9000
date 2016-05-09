/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{
    // instance variables - replace the example below with your own
    boolean done1 = false, done2 = false, done3 = false, done4 = false, done5 = false;
    boolean finished = false;
    int mealsListSize = 4, menuSize = 3;//remove size of menuSize later
    int meals = 0, breakMain, breakSide, lunchMain, lunchSide, snacks, dinnerMain, dinnerSide, dinnerDesert;
    String mealsList[], menuList[], breakMainList[], breakSideList[], lunchMainList[], lunchSideList[], snacksList[], dinnerMainList[], dinnerSideList[], dinnerDesertList[];

    public main()
    {
        // initialise instance variables
        //constructor
        while(!done1)
        {
            init_Meals_Lists();
            cl();
            pickO1(meals);
            while (!done2)
            {
                if (meals == 1)//breakfast
                {
                    cl();
                    while (!done3)
                    {
                        //randomize(breakMainList[]);
                        pick(breakMain);
                        while (!done4)
                        {
                            if (finished == true)
                            {
                                done4 = true;
                                done3 = true;
                                done2 = true;
                            }
                            else
                            {
                                //randomize(breakSideList[]);
                                pick(breakSide);
                            }
                        }
                    }
                }
                else if (meals == 2)//lunch
                {
                    cl();
                    while (!done3)
                    {
                        //randomize(lunchMainList[]);
                        pick(lunchMain);
                        while (!done4)
                        {
                            if (finished == true)
                            {
                                done4 = true;
                                done3 = true;
                                done2 = true;
                            }
                            else
                            {
                                //randomize(lunchSideList[]);
                                pick(lunchSide);
                            }
                        }
                    }
                }
                else if (meals == 3)//snacks
                {
                    cl();
                    while (!done3)
                    {
                        //randomize(snacksList[]);
                        pick(snacks);
                        if (finished == true)
                        {
                            done3 = true;
                            done2 = true;
                        }
                    }
                }
                else if (meals == 4)//dinner
                {
                    cl();
                    while (!done3)
                    {
                        //randomize(dinnerMainList[]);
                        pick(dinnerMain);
                        while (!done4)
                        {
                            if (finished == true)
                            {
                                done4 = true;
                                done3 = true;
                                done2 = true;
                            }
                            else
                            {
                                //randomize(dinnerSideList[]);
                                pick(dinnerSide);
                                while (!done5)
                                {
                                    if (finished == true)
                                    {   
                                        done5 = true;
                                        done4 = true;
                                        done3 = true;
                                        done2 = true;
                                    }
                                    else
                                    {
                                        //randomize(dinnerDesertList[]);
                                        pick(dinnerDesert);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            cl();
            displayMenu();
        }
    }
    
    public void init_Meals_Lists()//dont forget to add ways to add to lists within program
    {
        mealsList = new String[] {"Breakfast", "Lunch", "Snacks", "Dinner"};
        menuList = new String[] {"test1", "test2", "test3"};//remove later
        breakMainList = new String[] {"Cereal", "Oatmeal", "French Toast", "Waffles", "Yogurt"};
        breakSideList = new String[] {"Smoothie", "Eggs", "Orange Juice", "Sausage", "Bagels"};
        lunchMainList = new String[] {"Meat Sandwich", "Ramen Noodles", "Burger", "Tacos", "Enchilladas"};
        lunchSideList = new String[] {"Lemonade", "Salad", "Cucumber", "Tomato", "Crackers"};
        snacksList = new String[] {"Pudding", "Pretzels", "Salami", "Granola Bars", "Cookies"};
        dinnerMainList = new String[] {"Spaghetti","Pizza","Burritos","Burgers","Polish Dogs"};
        dinnerSideList = new String[] {"Fries","Rice","Corn","Peas","Asparagus"};
        dinnerDesertList = new String[] {"Ice Cream","Cake","Cookies","Pie","Lemon Bar"};
    }
    
    //--------------- Functions
    public void cl() {output("\u000c");}

    //--------------- Methods
    public int pickO1(int meals)
    {
        for(int i = 0; i < mealsListSize; i++)
        {
            System.out.println("\nOption " + (i+1) + " is " + mealsList[i]);
        }
        meals = inputInt("\n\nEnter your option: ");
        return meals;
    }
    
    public int pick(int menuItem)
    {
        
    }
    
    
    public void displayMenu()
    {
        for (int i = 0; i < menuSize; i++)
        {
            System.out.println("\n" + menuList[i]);
        }
        input("\nPress <return> to continue.");
    }
    
    
    
    
    
    
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


}
