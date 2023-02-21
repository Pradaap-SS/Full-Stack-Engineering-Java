
public class Loan {
	
	//Implement the below method 
	
	public double calculateLoanAmount(Employee employeeObj) 
	{
	    double loan=0;
		if(employeeObj instanceof PermanentEmployee)
		{
		   loan= (double)15/100* (employeeObj.getSalary());
		}
		else if(employeeObj instanceof TemporaryEmployee)
		{
		    loan= (double)10/100* (employeeObj.getSalary());
		}
		return loan;
	}

}
