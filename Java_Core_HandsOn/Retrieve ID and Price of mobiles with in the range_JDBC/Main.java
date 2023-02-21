
import java.util.Scanner;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// fill your code here
		
		System.out.println("Enter the minimum range");
		int min = sc.nextInt();
		
		System.out.println("Enter the maximum range");
		int max = sc.nextInt();
		
		MobileManagementSystem mms = new MobileManagementSystem();
		Map<Integer, Integer> mobileMap = mms.viewMobileWithInTheRange(min,max);
		
		if(mobileMap.isEmpty()){
		    System.out.println("No mobiles found for the given range");
		}
		else{
		    mobileMap.forEach((k, v) -> {
		        System.out.println(k+":"+v);
                });
		}
	}
}