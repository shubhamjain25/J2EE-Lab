package labPractice4;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	
	JFrame frame;
	JButton btn1, btn2;
	JTextArea textArea;
	User user;
	
	Customer customer;
	Item item;
	float totalBillAmt=0;
	
	boolean isUserAuthenticated = false;
	
	boolean authenticateUser() {
		String username = JOptionPane.showInputDialog(null, "Username:").trim();
		String password = JOptionPane.showInputDialog(null, "Password:");
		
		user = new User(username,password);
		if(user.isUserValid()) {
			JOptionPane.showMessageDialog(null, "Successfully Logged In.");
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid Username or password");
			return false;
		}
	}
	
	void accessCustomer() {
		customer = new Customer();
		String cid = JOptionPane.showInputDialog(null,"Enter customer id");
		customer = customer.validateCustId(cid);
	}
	
	void initialiseFrame() {
		frame = new JFrame("Frame Window");
		frame.setLayout(null);
		frame.setSize(900,600);
		btn1 = new JButton("Add Item");
		btn1.setBounds(100,500,100,60);
		btn1.addActionListener(this);
		
		
		btn2 = new JButton("Display Bill");
		btn2.setBounds(300,500,100,60);
		btn2.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setBounds(50,50,500,400);
		textArea.setText("ID \t Name \t Quantity \t Price \t\n");
		textArea.setFont(new Font("Arial",Font.BOLD,15));
		textArea.setEditable(false);
		
		frame.add(btn1);
		frame.add(btn2);
		frame.add(textArea);
		
		frame.setVisible(true);
	}
	
	MyFrame(){
		
		// It will go on till authenticate user function comes out to be true.
		while(isUserAuthenticated==false){
			isUserAuthenticated = authenticateUser();
		}
		
		// To create a customer and access their details
		accessCustomer();
		
		// To initialize the frame
		initialiseFrame();

	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1) {
			System.out.println("Add Item Pressed");
			String itemId = JOptionPane.showInputDialog(frame, "Enter Item id:");
			item = new Item();
			item = item.retrieveItem(itemId);
			
			int qtyPurchased = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Quantity:"));
			String displayText = textArea.getText() + item.id+"\t"+item.name+"\t"+qtyPurchased+"\t"+qtyPurchased*item.price+"\n";
			
			textArea.setText(displayText);
			
			totalBillAmt+=qtyPurchased*item.price;
		}
		
		if(e.getSource() == btn2) {
			System.out.println("Display Bill Pressed");
			JOptionPane.showMessageDialog(frame,"Total Bill Amount: "+totalBillAmt);
			frame.dispose();
			accessCustomer();
			initialiseFrame();
			
		}
		
	}	
		
		
		
}
