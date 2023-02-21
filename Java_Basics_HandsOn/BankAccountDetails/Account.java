import java.util.*;
public class Account
{
    private int accountId;
    private String accountType;
    private int balance;
    
    public void setAccountId(int id)
    {
        this.accountId=id;
    }
    public int getAccountId()
    {
        return accountId;  
    }
    
    public void setAccountType(String type)
    {
        this.accountType=type;
    }
    public String getAccountType()
    {
        return accountType;  
    }
    
    public void setBalance(int bal)
    {
       this.balance=bal;
    }
    public int getBalance()
    {
        return balance;  
    }
    
    public boolean withdraw(int amt)
    {
        if(amt<=balance)
        {
            System.out.println("Balance amount after withdraw:"+(balance-amt));
            return true;
        }
        else
        {
            System.out.println("Sorry!!! No enough balance");
            return false;
        }
    }

}