import java.util.stream.Stream;
import java.util.Arrays;
import java.util.*;

public class EmployeeUtility {

	public Employee[] getEmployeeDetails(String[] details) {

		//Fill your code here
		Employee[] emp = new Employee[details.length];
		
		int i=0;
		for(String detail:details){
		    String[] arr = detail.split(";");
		    Employee obj = new Employee();
		    obj.setEmpId(arr[0]);
		    obj.setEmpName(arr[1]);
		    obj.setSalary(Double.parseDouble(arr[2]));
		    
		    emp[i] = obj;
		    i += 1;
		    
		}
		return emp;
	}

	public Stream<Employee> getStreamOfEmployee(Employee[] empDetails) {

		//Fill your code here
		return Arrays.stream(empDetails);



	}

	public String[] shortlistedEmployee(Stream<Employee> empStream,double minSalary) {

		//Fill your code here
		Comparator<String> comp = (s1,s2) -> s1.compareTo(s2);
		return empStream.filter(emp -> emp.getSalary()>=minSalary)
		                      .map(emp -> emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getSalary())
		                      .sorted(comp)
		                      .toArray(String[]::new);
		                      
        //return s;





	}

}
