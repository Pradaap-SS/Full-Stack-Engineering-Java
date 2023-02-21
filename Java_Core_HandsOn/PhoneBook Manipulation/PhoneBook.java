import java.util.*;

public class PhoneBook{
	private List<Contact> phoneBook = new ArrayList<Contact>();

	public List<Contact> getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(List<Contact> phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	public void addContact(Contact contactObj) {
		phoneBook.add(contactObj);
	}
	
	public List<Contact> viewAllContacts(){
		return phoneBook;
	}
	
	public Contact viewContactGivenPhone(long phoneNumber) {
		Contact cTact = null;
		for(Contact contact : phoneBook) {
			if(contact.getPhoneNumber()==phoneNumber) {
				cTact = contact;
				break;
			}
		}
		return cTact;
	}
	
	public boolean removeContact(long phoneNumber) {
		for(Contact contact : phoneBook) {
			if(contact.getPhoneNumber()==phoneNumber) {
				phoneBook.remove(contact);
				return true;
			}
		}
		return false;
	}
	
}