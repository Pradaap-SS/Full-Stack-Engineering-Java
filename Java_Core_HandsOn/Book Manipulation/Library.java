import java.util.*;

public class Library{
    
    private ArrayList<Book> bookList = new  ArrayList<Book>();
    
    public void setBookList(ArrayList<Book> bookList){
        this.bookList=bookList;
    }
    
    public ArrayList<Book> getBookList(){
        return bookList;
    }
    
    public void addBook(Book bobj){
        bookList.add(bobj);
        
    }
    
    public boolean isEmpty(){
        
        if(bookList.isEmpty()){
            return true;
        }
        return false;
    }
    
    public ArrayList<Book> viewAllBooks(){
        return bookList;
        
    }
    
    public ArrayList<Book> viewBooksByAuthor(String author){
        
        ArrayList<Book> bookList2 = new  ArrayList<Book>();
    
        for(Book obj:bookList){
            if(obj.getAuthor()==author){
                bookList2.add(obj);
            }
        }
        return bookList2;
        
    }
    
    public int countnoofbook(String bname){
        int count = 0;
        ArrayList<Book> bookList2 = new  ArrayList<Book>();
    
        for(Book obj:bookList){
            if(obj.getBookName()==bname){
                count +=1;
            }
        }
        
        return count;
    }
}