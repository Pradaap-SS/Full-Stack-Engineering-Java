import java.util.*;

public class UserInterface {
    public static void main(String args[]) {
        
    // Fill the code here
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter registration number");
    int regNo = sc.nextInt();
    sc.nextLine();
    
    System.out.println("Enter student name");
    String name = sc.nextLine();
    
    System.out.println("Enter no of semesters");
    int semNo = sc.nextInt();
    sc.nextLine();
    
    System.out.println("Enter basic fee");
    int basicFee = sc.nextInt();
    sc.nextLine();
    
    System.out.println("Course type");
    String course = sc.nextLine();
    
    
    TuitionFee obj = generateFeeReceipt();
    
    int fee = obj.calculateTuitionFees(course,basicFee,semNo);
    
    System.out.println("Fees Receipt");
    System.out.println("Registration number: "+regNo);
    System.out.println("Student name: "+name);
    System.out.println("Tuition fee for "+course+" student: "+fee);

    
    }
    public static TuitionFee generateFeeReceipt() {
        TuitionFee obj = (courseType,basicFee,noOfSemesters) -> {
            int fee = 0;
            if(courseType.equalsIgnoreCase("Regular")) {
                fee = basicFee*noOfSemesters;
            }
            else if(courseType.equalsIgnoreCase("SelfFinance")) {
                fee = (basicFee*noOfSemesters)+50000;
            }
            return fee;
        };
        return obj;
    }
    
}