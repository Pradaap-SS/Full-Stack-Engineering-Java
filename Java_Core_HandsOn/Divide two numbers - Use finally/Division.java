public class Division
{
    public String divideTwoNumbers(int number1,int number2)
    {
        
        try{
            int d=number1/number2;
            String output="The answer is "+d+". Thanks for using the application.";
            //output.concat(" Thanks for using the application");
            return output;
        }
        catch(ArithmeticException e){
            return "Division by zero is not possible. Thanks for using the application.";
        }
        finally{
        }
    }
}