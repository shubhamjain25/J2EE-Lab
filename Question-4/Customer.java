package labPractice4;

import java.util.*;
import javax.swing.JOptionPane;

public class Customer {
	String name, id, mobile;
	
	static public ArrayList<Customer> cust = new ArrayList<Customer>();
	
	Customer validateCustId(String customerId) {
		for(Customer c:cust) {
			if(c.id.equals(customerId)) {return c;}
		}
		
		Customer c = new Customer();
		c.id = customerId;
		c.name = JOptionPane.showInputDialog("Enter Customer Name").trim();
		c.mobile = JOptionPane.showInputDialog("Enter Customer Number").trim();
		cust.add(c);
		return c;
	}
}
