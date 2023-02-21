import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
	
		// fill your code here
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the minimum height");
		double min=sc.nextDouble();
		System.out.println("Enter the maximum weight");
		double max=sc.nextDouble();
		PlayerSelectionSystem pss= new PlayerSelectionSystem();
		List<String> l =pss.playersBasedOnHeightWeight(min, max);
		if(l.size()>0){
			for(int i=0;i<l.size();i++){
				System.out.println(l.get(i));
			}
		}else{
			System.out.println("No players are with minimum height of "+min+" and maximum weight of "+max);
		}
	}
}