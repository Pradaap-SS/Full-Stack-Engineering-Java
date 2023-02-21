import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		PhoneBook book = new PhoneBook();
		while(true) {
			System.out.println("Menu");
			System.out.println("1.Add Contact");
			System.out.println("2.Display all contacts");
			System.out.println("3.Search contact by phone");
			System.out.println("4.Remove contact");
			System.out.println("5.Exit");
			
			System.out.println("Enter your choice:");
			int choice = Integer.parseInt(br.readLine());
			
			if(choice==1) {
				System.out.println("Add a Contact:");
				System.out.println("Enter the First Name:");
				String fName = br.readLine();
				System.out.println("Enter the Last Name:");
				String lName = br.readLine();
				System.out.println("Enter the Phone No.:");
				long phn = Long.parseLong(br.readLine());
				System.out.println("Enter the Email:");
				String email = br.readLine();
				Contact contact = new Contact(fName, lName, phn, email);
				book.setPhoneBook(contacts);
				book.addContact(contact);
			}
			else if(choice==2) {
				System.out.println("The contacts in the List are:");
				for(Contact contact : book.viewAllContacts()) {
					System.out.println("First Name: " + contact.getFirstName());
					System.out.println("Last Name: " + contact.getLastName());
					System.out.println("Phone No.: " + contact.getPhoneNumber());
					System.out.println("Email: " + contact.getEmailId());
				}
			}
			else if(choice==3) {
				System.out.println("Enter the Phone number to search contact:");
				long phn = Long.parseLong(br.readLine());
				Contact contact = book.viewContactGivenPhone(phn);
				System.out.println("The contact is:");
				System.out.println("First Name: " + contact.getFirstName());
				System.out.println("Last Name: " + contact.getLastName());
				System.out.println("Phone No.: " + contact.getPhoneNumber());
				System.out.println("Email: " + contact.getEmailId());
			}
			else if(choice==4) {
				System.out.println("Enter the Phone number to remove :");
				long phn = Long.parseLong(br.readLine());
				System.out.println("Do you want to remove the contact (Y/N):");
				char ch = br.readLine().charAt(0);
				boolean delete = false;
				if(ch=='Y')
					delete = book.removeContact(phn);
				if(delete==true)
					System.out.println("The contact is successfully deleted.");
				
				
			}
			else if(choice==5) {
				break;
			}
		}
		
		
		
		
	}
}