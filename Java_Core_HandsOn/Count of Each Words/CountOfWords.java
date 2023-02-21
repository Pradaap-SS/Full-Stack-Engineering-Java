//import the necessary packages if needed
import java.util.*;
     
@SuppressWarnings("unchecked")//Do not delete this line
public class CountOfWords
{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        //System.out.println("Enter Student's Article");
        String sentence = sc.nextLine();
        
        String[] words = sentence.split("[.,;:?!\\s]+");
        
        
        System.out.println("Number of words "+words.length);
        
        System.out.println("Words with the count");
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        for(String w:words){
            String word = w.toLowerCase();
            
            Set<String> keys = map.keySet();
            
            if(!keys.contains(word)){
                map.put(word,1);
            }
            else{
                int count = map.get(word)+1;
                map.replace(word,count);
            }
        }
        
        Map<String,Integer> tMap = new TreeMap<String,Integer>();
        
        tMap.putAll(map);
        
        for (Map.Entry element : tMap.entrySet()) { 
            String key = (String)element.getKey(); 
  
            
            int value = (int)element.getValue(); 
  
            System.out.println(key + ":" + value); 
        } 
    }
         
}