public class SecretMsg
{
    //class members---------------------------
    //private
    int[] msgCode;
    int lowerBound, upperBound, shift;
    int msgSize;

    //main of class
    public static void main(String[] args)
    {
        new SecretMsg();
    }

    //class constructor
    public SecretMsg()
    {
        output("\u000c"); //clears output terinal before execution
        getSecret();
        translateSecret();
        output("\n\n\n........................................Goodbye!!");
    }


    public void getSecret(){
        boolean done = false;
        String secretMsg;
        int i;
        
        lowerBound = 32; upperBound = 126;
        shift = inputInt("Enter the key: ");
        secretMsg = input("Enter the message: ");
        output("\n\nYou entered "+secretMsg+"");
        msgSize = secretMsg.length();
        msgCode = new int[msgSize];
        while(!done){
            if (msgSize < 0) done = true;
            else { 
                for(i=0; i<msgSize; i++) {
                    msgCode[i] = (int) (secretMsg.charAt(i));
                }
                for(i=0; i<msgSize; i++) {
                    output(msgCode[i]+ " ");
                }
                output("\n\n");
                done = true;
            }
        }
    }
    
    public void translateSecret() {
        int index;
        String translatedMsg;
        int sum, diff, newPosn;
        
        translatedMsg= "";
        for (index = 0; index<msgSize; index++) {
            sum = msgCode[msgSize-(index+1)] + shift;
            newPosn = sum;
            if (sum > upperBound) {
                diff = sum - upperBound;
                newPosn = diff+lowerBound;
            }
            else if (sum < upperBound) {
                diff = lowerBound - sum;
                newPosn = upperBound - diff;
            }
            translatedMsg = translatedMsg+(char)(newPosn);
            //translatedMsg = translatedMsg + (char)(msgCode[index]);
        }
        output("The translated message: \n\n"+translatedMsg);
    }
    //class methods---------------------------
    //method header


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
