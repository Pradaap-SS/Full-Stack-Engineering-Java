
import java.util.ArrayList;
import java.util.Scanner;

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
		ArrayList<Train> trains = new TrainManagementSystem().viewTrain(coachType, source, destination);
		trains.stream().forEach((train)->System.out.println(train.getTrainNumber()+" "+train.getTrainName()));
	}
}