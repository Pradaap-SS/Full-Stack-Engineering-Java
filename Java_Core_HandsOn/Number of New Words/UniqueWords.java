//import the necessary packages if needed
import java.util.*; 
@SuppressWarnings("unchecked")//Do not delete this line

public class UniqueWords
{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Student's Article");
    String article=sc.nextLine();
    
    List<String> words = new ArrayList<String>();
    
    String allWords[]=article.split("[!,:;.?\\s]+");
    
    int uWordsNo=0;
    int wordsNo=0;
    
    List<String> uniqueWords = new ArrayList<String>();
    
    /*for(String s: words)
    {
        uniqueWords.add(s);
        words.removeAll(Collections.singleton("s"));
    }*/
    
    
    for(String w: allWords)
    {
        words.add(w.toLowerCase());
        
        if(!uniqueWords.contains(w.toLowerCase()))
        {
            uniqueWords.add(w.toLowerCase());
            uWordsNo+=1;
        }
        wordsNo+=1;
    }
    System.out.println("Number of words");
    System.out.println(wordsNo);
    System.out.println("Number of unique words");
    System.out.println(uWordsNo);
    
    Collections.sort(uniqueWords);
    
    System.out.println("The words are");
    int i=1;
    for(String s: uniqueWords)
    {
        System.out.println(i+". "+s);
        i++;
    }
    }
    
}