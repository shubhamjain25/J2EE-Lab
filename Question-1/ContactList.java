import java.util.*;

public class ContactList {
	
	static HashMap<Long,Contact> contList = new HashMap<Long,Contact>();
	
	ContactList(){
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("To add new contact press 1, otherwise 0");
			
			if(sc.nextLine().equals("1")) {
				System.out.print("Enter name: ");
				String name = sc.nextLine();
				
				System.out.print("Enter number: ");
				long phno = sc.nextLong();
				
				Contact c1 = new Contact(name,phno);
				contList.put(phno, c1);
			}
			else {
				break;
			}
			
			sc.nextLine();
		}
		
	}
	
	static HashMap<Long,Contact> fetchList(){
		return contList;
	}
	
	void displayContactList() {
		contList.forEach((Long hmi,Contact contact)->{
			System.out.println(contact);
		});
	}
	
}
