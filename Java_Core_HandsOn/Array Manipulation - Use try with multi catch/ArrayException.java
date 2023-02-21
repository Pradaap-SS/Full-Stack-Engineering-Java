import java.util.*;
public class ArrayException
{
    public String getPriceDetails()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=sc.nextInt();
        System.out.println("Enter the price details");
        int input[]=new int[n];
        for(int i=0;i<n;i++)
        {
        try {
            input[i]=sc.nextInt();
            sc.nextLine();
        } 
        catch(InputMismatchException e) {
            return "Input was not in the correct format";
        } 
        }
        System.out.println("Enter the index of the array element you want to access");
        try{
            int in=sc.nextInt();
            String str="The array element is "+input[in];
            return str;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return "Array index is out of range";
        }
    }
}