import java.util.*;

public class Main{
    public static void main (String[] args) {
        /* code */
        
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("1.Add Book");
            System.out.println("2.Display all book details");
            System.out.println("3.Search Book by author ");
            System.out.println("4.Count number of books - by book name");
            System.out.println("5.Exit");
            
            int choice = sc.nextInt();
            
            if(choice==1){
                
                System.out.println("Enter the isbn no:");
                int isbn = sc.nextInt();
                System.out.println("Enter the book name:");
                String bookName = sc.nextLine();
                System.out.println("Enter the author name:");
                String authorName = sc.nextLine();
                
                Book newObj = new Book();
                newObj.setIsbnno(isbn);
                newObj.setBookName(bookName);
                newObj.setAuthor(authorName);
                
                Library libray = new Library();
                libray.addBook(newObj);
                
            }
            else if(choice==2){
                
            }
            else if(choice==3){
                
            }
            else if(choice==4){
                
            }
            else if(choice==5){
                break;
            }
        }
    }
}