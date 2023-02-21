import java.util.*;

public class Main extends Thread{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//fill the code
		int i=0;
		List<Employee> list= new ArrayList<Employee>();
		
		System.out.println("Enter the number of employees");
		int n = sc.nextInt();
		sc.nextLine();
		
		
		System.out.println("Enter the employee details");
		
		for(i=0;i<n;i++) {
		    //Parse the employee details
		    String[] input = sc.nextLine().split(":");
		    
		    //add to employee class using constructor
		    Employee employee = new Employee(input[0],input[1],Double.parseDouble(input[2]));
		    
		    //Populate the Employee objects to the List.
		    list.add(employee);
		   
		}
		
	    // Get the number of times the salary limit value is to be entered by the user.
	    System.out.println("Enter the number of times salary limit to be searched");
	    int noOfSalaryLimit = sc.nextInt();
	    sc.nextLine();
	    
	    Map<Double,Integer> output = new HashMap<Double,Integer>();
	    
	    for(i=0;i<noOfSalaryLimit;i++) {
	        System.out.println("Enter the salary limit to be searched");
	        double salaryLimit = sc.nextDouble();
	    
	        //Create a Management thread by passing the salary limit and the List created and then invoke the thread.
            Management mnt = new Management(salaryLimit,list);
            mnt.run();
            
            int count = mnt.getCount();
            output.put(salaryLimit,count);
	    }
	    output.forEach((k, v) -> {System.out.println(k+" : "+v);});
	    
}
}
