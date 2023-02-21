import java.util.*;
public class Main
{
    public static Candidate getCandidateDetails() throws InvalidSalaryException
	{
	    Candidate ob=new Candidate();
	    Scanner sc=new Scanner(System.in);
	    
	    System.out.println("Enter the candidate Details");
	    System.out.println("Name");
	    String nm=sc.nextLine();
	    ob.setName(nm);
	    
	    System.out.println("Gender");
	    String g=sc.nextLine();
	    ob.setGender(g);
	    
	    System.out.println("Expected Salary");
	    double s=sc.nextDouble();
	    ob.setExpectedSalary(s);
	    
	    double sal=ob.getExpectedSalary();
	    if(sal<10000)
	    {
	        ob=null;
	        throw new InvalidSalaryException("Registration Failed. Salary cannot be less than 10000.");
	    }
	        return ob;
	}
    public static void main(String Args[])
    {
        try {
            if(getCandidateDetails()==null)
                System.out.println("Registeration Successfull");
            else
                System.out.print("Registeration Failed.");
        } 
        catch(InvalidSalaryException e) {
            System.out.println(e.getMessage());
        } 
    }
}