
import java.util.Scanner;
import java.util.List;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// fill your code here

        System.out.println("Enter the source");
        String source = sc.nextLine();
        
        System.out.println("Enter the destination");
        String destination = sc.nextLine();
        
        System.out.println("Enter the coach type");
		String coachType = sc.nextLine();
		if(coachType.equalsIgnoreCase("AC1")||coachType.equalsIgnoreCase("AC2")||coachType.equalsIgnoreCase("AC3")||coachType.equalsIgnoreCase("Sleeper")||coachType.equalsIgnoreCase("Seater")){
		 
    		TrainManagementSystem tms = new TrainManagementSystem();
    		List<Train> trainList=tms.viewTrain(coachType, source, destination);
    		
    		if(trainList.isEmpty()){
    		    System.out.println("No trains found");
    		}
    		else{
    		    for(Train t: trainList){
    		        System.out.println(t.getTrainNumber()+" "+t.getTrainName());
    		    }
    		}
		}
		else{
		    System.out.println("Invalid Coach Type");
		}
	}
}