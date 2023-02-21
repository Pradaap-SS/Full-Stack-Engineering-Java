//import necessary packages
import java.util.*;
import java.io.*;

 @SuppressWarnings("unchecked")//Do not delete this line
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
	    String fileContent = "";
	    
	    while(true){
	        System.out.println("Enter Name");
    	    String name = sc.nextLine();
    	    
    	    System.out.println("Enter Phone Number");
    	    String phoneNo = sc.nextLine();
    	    
    	    System.out.println("Enter Email");
    	    String email = sc.nextLine();
    	    
    	    System.out.println("Do you want to enter another record(yes/no)");
    	    String choice = sc.nextLine();
    	    
    	    fileContent += name +","+phoneNo+","+email+";";
    	    
    	    if(choice.equalsIgnoreCase("no")){
    	        break;
    	    }
	    }
	    
	    FileManager fm = new FileManager();
  	    
	    try {
	    	File f = fm.createFile();
	    	fm.writeFile(f,fileContent);
	    	String[] content = fm.readFile(f);
	    	System.out.println(content.toString());
	    }
	    catch (Exception e) {
	           e.printStackTrace();
	    }
	    
	    
	    
	    
	}
    
}