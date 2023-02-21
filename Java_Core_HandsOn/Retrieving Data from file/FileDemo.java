import java.io.*;
public class FileDemo
{
    public static void main(String[] args)
    {
        String fileContent = "";
       
        FileInputStream fis=null;
        try{
            fis = new FileInputStream("log.txt");
            try{
                int i = 0;
                while((i=fis.read())!=-1){
                    //System.out.println((char)i);
                    fileContent += (char)i;
                }
                System.out.println(fileContent);
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        finally{
            try{
                fis.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            
        }
        
    }
}