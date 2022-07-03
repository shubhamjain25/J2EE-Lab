import java.time.LocalDateTime;
import java.util.HashMap;

public class MissedCall {
	
	long phno;
	String name;
	LocalDateTime ldt;
	
	MissedCall(long phno){
		this.name = "private caller";
		this.phno = phno;
		this.ldt = LocalDateTime.now();
		
		HashMap<Long,Contact> contList = ContactList.fetchList();
		
		if(contList.containsKey(phno)) {
			this.name = contList.get(phno).name;
		}
	}
	
	public String toString() {
		return ("Name: "+name+" PhNo: "+phno+" Time: "+ldt+"\n");
	}
	
}
