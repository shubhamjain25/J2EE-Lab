
public class Contact {
	long phno;
	String name;
	
	Contact(String name, long phno){
		this.name = name;
		this.phno = phno;
	}
	
	public String toString() {
		return ("Name: "+name+" PhNo: "+phno);
	}
}
