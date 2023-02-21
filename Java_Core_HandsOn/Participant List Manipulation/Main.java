import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int option=0;
		String participantName;
		String departmentName;
		String collegeName;
		ParticipantUtility viewObj=new ParticipantUtility();
		
		do {
			System.out.println("1.Add\n2.View\n3.Exit");
			option=sc.nextInt();
			sc.nextLine();
			switch(option) {
			case 1:
				participantName=sc.nextLine();
				departmentName=sc.nextLine();
				collegeName=sc.nextLine();
				Participant pObj=new Participant();
				pObj.setParticipantName(participantName);
				pObj.setDepartmentName(departmentName);
				pObj.setCollegeName(collegeName);
				
				// Fill your code here to add Participant Object
				Participant participant = new Participant();
				participant.setParticipantName(participantName);
				participant.setDepartmentName(departmentName);
				participant.setCollegeName(collegeName);
				
				viewObj.addParticipant(participant);
				
				
					
				break;
			case 2:
				System.out.println("Enter department name");
				departmentName=sc.nextLine();
				System.out.println("Enter college name");
				collegeName=sc.nextLine();
				
				// Fill your code here to display partcipant details
				Stream<Participant> stream = viewObj.viewAllParticipants(departmentName,collegeName);
				List<Participant> list = stream.collect(Collectors.toList());
				for(Participant obj:list){
				    System.out.println(obj.getParticipantName()+" "+ obj.getDepartmentName() +" "+ obj.getCollegeName());
				}
				
				//
				
				break;
			case 3:
				System.out.println("Thank you for using the application");
				break;
			default:
				System.out.println("Please choose a correct option");
				break;
			}
		}while(option!=3);
		
	}

}
