import java.util.*;
public class Main{
    public static void main (String[] args) {
     Scanner sc=new Scanner(System.in);
     
     // Fill the code here
     int n=sc.nextInt();
     
     double min=1000000.0;
     
     String[] name=new String[10];
     int amt,discount,discountAmt;
     int j=0;
     
     for(int i=0;i<=n;i++)
     {
        String str=sc.nextLine();
        
        if(str.isEmpty()==false)
        {
            String[] values=str.split(",");
            amt=Integer.parseInt(values[1]);
            discount=Integer.parseInt(values[2]);
            discountAmt=amt*discount;
            
            
            if(discountAmt<min)
            {
                min=discountAmt;
                name[0]=values[0];
            }
            
            if(discountAmt==min)
            {
                name[j]=values[0];
                j++;
            }
        }
    }
        for(String ch:name)
        {
            if(ch!=null)
            System.out.println(ch);
        }
    
    }
}
    