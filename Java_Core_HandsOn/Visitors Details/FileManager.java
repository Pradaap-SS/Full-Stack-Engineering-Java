 //import necessary packages
 import java.io.*;
 import java.util.*;
 import java.io.File;
 
 @SuppressWarnings("unchecked")//Do not delete this line
 public class FileManager 
 {
    
    static public File createFile() 
    {
        File f = null;
        try{
            f=new File("visitors.txt");
            f.createNewFile();
        }
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        
        
    return f;//change the return type as per the requirement    
    }
    static public void writeFile(File f, String record)
	{
	    FileWriter file = null;
         try {
                file = new FileWriter(f, true);
                file.write(record);
                file.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	} 
	static public String[] readFile(File f) 
	{
	   
	    FileReader file = null;
	    String content = "";
	    try {
                file = new FileReader(f);
                Scanner sc = new Scanner(file);
                int i = 0;
                
                while(sc.hasNextLine()){
                    content+=sc.nextLine();
                }
                file.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        String[] array = content.split(";");
        
       
        
        
	    return array;//change the return type as per the requirement  
	}
 }