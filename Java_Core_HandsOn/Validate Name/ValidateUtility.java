import java.util.*;
import java.util.regex.*;

public class ValidateUtility
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
        String employeeName=sc.nextLine();
        String productName=sc.nextLine();
        
        // call 
        Validate validate1 = validateEmployeeName();
        validate1.validateName(employeeName);
        
        Validate validate2 = validateProductName();
        validate2.validateName(productName);
        
        //validateEmployeeName().validateName(employeeName);
        //validateProductName().validateName(productName);
        
    }
    
    public static Validate validateEmployeeName() 
    {
        Validate validate=(String employeeName)->{
            if(Pattern.matches("[a-zA-Z ]{5,20}",employeeName))
            {
                System.out.println("Employee name is valid");
                return true;
            }
            else{
            System.out.println("Employee name is invalid");
                return false;
            }
        };
        return validate;
        
    }
    
    public static Validate validateProductName() 
    {
        
        Validate validate=(String productName)->{
            if(Pattern.matches("[a-zA-Z]{1}[0-9]{5}",productName))
            {
                System.out.println("Product name is valid");
                return true;
            }
            else{
            System.out.println("Product name is invalid");
                return false;
            }
        };
        return validate;
    }
}