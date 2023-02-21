import java.util.*;
public class StudentMain
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student's Id:");
        int id=sc.nextInt();
        System.out.println("Enter Student's Name:");
        String name=sc.nextLine();
        System.out.println("Enter Student's address:");
        String addr=sc.nextLine();
        
        Student ob;
        while(true)
        {
            System.out.println("Whether the student is from NIT(Yes/No):");
            String input=sc.nextLine();
            if(input=="yes" || input=="YES")
            {
                ob= new Student(id,name,addr);
            break;
            }
            else if(input=="no" || input=="NO")
            {
                System.out.println("Enter the college name:");
                String col=sc.nextLine();
                ob= new Student(id,name,addr,col);
                break;
            }
            else
                System.out.println("Wrong Input");
        }
        
        System.out.println("Student id:"+ob.getStudentId());
        System.out.println("Student name:"+ob.getStudentName());
        System.out.println("Student Address:"+ob.getStudentAddress());
        System.out.println("Student College name:"+ob.getCollegeName());
    }
}