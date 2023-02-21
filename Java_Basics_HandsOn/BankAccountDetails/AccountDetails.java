import java.util.*;
public class AccountDetails
{
    Scanner sc=new Scanner(System.in);
    public Account getAccountDetails()
    {
        Account ob=new Account();
        System.out.println("Enter account id:");
        int id=sc.nextInt();
        sc.nextLine();
        ob.setAccountId(id);
        
        System.out.println("Enter account type:");
        String type=sc.nextLine();
        ob.setAccountType(type);
        
        while(true)
        {
            System.out.println("Enter balance:");
            int bal=sc.nextInt();
            sc.nextLine();
            if(bal<=0)
                System.out.println("Balance should be positive");
            else
            {
                ob.setBalance(bal);
                break;
            }
        }
       // System.out.println(ob.getAccountId());
        // System.out.println(ob.getAccountType());
        // System.out.println(ob.getBalance());
        return ob;
    }
    public int getWithdrawAmount()
    {
        int amount=0;
        while(true)
        {
            System.out.println("Enter amount to be withdrawn:");
            amount=sc.nextInt();
            if(amount>0)
                break;
        }
        return amount;
    }
    
    public static void main(String args[])
    {
        AccountDetails obj=new AccountDetails();
        Account ob1=new Account();
        ob1=obj.getAccountDetails();
        
        int withdrawAmount=obj.getWithdrawAmount();
        boolean output=ob1.withdraw(withdrawAmount);
    }
}