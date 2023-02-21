import java.util.*;
public class Main 
{
    public static void main (String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Details:");
        Hosteller obb=new Hosteller();
        obb=getHostellerDetails();
        System.out.println("Modify Room Number(Y/N)");
        char ch=sc.next().charAt(0);
        if(ch=='Y')
        {
            System.out.println("New Room Number");
            int rm=sc.nextInt();
            obb.setRoomNumber(rm);
        }
        System.out.println("Modify Phone Number(Y/N)");
        char c=sc.next().charAt(0);
        if(c=='Y')
        {
            System.out.println("New Phone Number");
            String ph=sc.nextLine();
            obb.setPhone(ph);
        }
        System.out.print(obb.getStudentId()+" ");
        System.out.print(obb.getName()+" ");
        System.out.print(obb.getDepartmentId()+" ");
        System.out.print(obb.getGender()+" ");
        System.out.print(obb.getPhone()+" ");
        System.out.print(obb.getHostelName()+" ");
        System.out.print(obb.getRoomNumber());
    }
    
    public static Hosteller getHostellerDetails()
    {
      Scanner sc=new Scanner(System.in);
      Hosteller ob=new Hosteller();
      System.out.println("Student Id");
        int id=sc.nextInt();
        ob.setStudentId(id);
      System.out.println("Student Name");
        String name=sc.nextLine();
        ob.setName(name);
      System.out.println("Department Id");
        int did=sc.nextInt();  
        ob.setDepartmentId(did);
      System.out.println("Gender");
        String g=sc.nextLine();
        ob.setGender(g);
      
      System.out.println("Phone Number");
        String p=sc.nextLine();
        ob.setPhone(p);
      
      System.out.println("Room Number");
       int r=sc.nextInt();
       ob.setRoomNumber(r);
      
      System.out.println("Hostel Name");
        String hn=sc.nextLine();
        ob.setHostelName(hn);
      
      return ob;
    }
}