import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements EmployeeAudit {
	
	private static Map <String,Double> employeeMap = new HashMap<String,Double>();

	public Map<String, Double> getEmployeeMap() {
		return employeeMap;
	}

	public void setEmployeeMap(Map<String, Double> employeeMap) {
		this.employeeMap = employeeMap;
	}
	
	public void addEmployeeDetails(String employeeName, double salary)
	{
		// Fill the code
		
		employeeMap.put(employeeName,salary);
	}
	
	public ArrayList<String> fetchEmployeeDetails (double salary){
	    
	    
	    ArrayList<String> listOfName = new ArrayList<>();
		employeeMap.forEach((k, v) -> {if(v<salary){
			listOfName.add(k);
			}});
		return listOfName;
		/*
		EmployeeAudit employeeAudit = () -> {return employeeAudit;};
	    */
	}
	
	public static EmployeeAudit findEmployee()
	{
		ArrayList<String> name=null;
		// Fill the code
		return null;
		
		
	}
	
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		
		// Fill the code
		
		while(true){
		    System.out.println("1.Add Employee Details");
		    System.out.println("2.Find Employee Details");
		    System.out.println("3.Exit");
		    System.out.println("Enter the choice");
		    
		    int choice = sc.nextInt();
		    
		    if(choice==1){
		        
		    }
		    else if(choice==2){
		        
		    }
		    else if(choice==3){
		        System.exit(0);
		    }
		    
		}
		
	}

}
