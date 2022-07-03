package jdbcProject1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	
	static Connection conn;
	
	JFrame frame1, frame2, frame3, frame4;
	JButton btn1, btn2, btn3;
	JButton btnRepAdd, btnDisplayRep;
	JTextArea textArea;
	
	JLabel l1, l2, l3, l4;
	JTextField box1, box2, box3, box4;
	
	HashMap<String, Integer> selectedRep = new HashMap<String,Integer>();
	
	void initialFrame() {
		frame1 = new JFrame("Primary Frame");
		frame1.setSize(700, 450);
		frame1.setLayout(null);
		frame1.setVisible(true);
		
		btn1 = new JButton("Add Representative");
		btn1.setBounds(50, 150, 150, 80);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Add Customer");
		btn2.setBounds(250, 150, 150, 80);
		btn2.addActionListener(this);
		
		btn3 = new JButton("Display Representative");
		btn3.setBounds(450, 150, 150, 80);
		btn3.addActionListener(this);
		
		frame1.add(btn1);
		frame1.add(btn2);
		frame1.add(btn3);
		
	}
	
	MyFrame(Connection conn){
		this.conn = conn;
		initialFrame();
	}

	public void openDisplayFrame(String repDetails) {
		frame4 = new JFrame("openDisplayFrame");
		frame4.setSize(700, 450);
		frame4.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(100,100,500,300);
		textArea.setText(repDetails);
		textArea.setFont(new Font("Arial", Font.BOLD, 15));
		
		frame4.add(textArea);
		frame4.setVisible(true);
		
		
	}

	public void openCustomerFrame() {
		frame3 = new JFrame("openCustomerFrame");
		frame3.setSize(700, 450);
		frame3.setLayout(null);
		
		//We can create this frame similar to the openRepresentativeFrame
		//Just remember to map the button with the respective query for database updation
		
		frame3.setVisible(true);
		
	}

	public void openRepresentativeFrame() {
		frame2 = new JFrame("openRepresentativeFrame");
		frame2.setSize(700, 600);
		frame2.setLayout(null);
		
		l1 = new JLabel("Rep No:");
		l1.setBounds(50,50,100,40);
		l1.setFont(new Font("Arial",Font.PLAIN,15));
		
		box1 = new JTextField();
		box1.setBounds(150,50,100,40);
		
		l2 = new JLabel("Rep Name:");
		l2.setBounds(50,150,100,40);
		l2.setFont(new Font("Arial",Font.PLAIN,15));
		
		box2 = new JTextField();
		box2.setBounds(150,150,100,40);
		
		l3 = new JLabel("State:");
		l3.setBounds(50,250,100,40);
		l3.setFont(new Font("Arial",Font.PLAIN,15));
		 
		box3 = new JTextField();
		box3.setBounds(150,250,100,40);
		
		l4 = new JLabel("Commission:");
		l4.setBounds(50,350,100,40);
		l4.setFont(new Font("Arial",Font.PLAIN,15));
		
		box4 = new JTextField();
		box4.setBounds(150,350,100,40);
		
		btnRepAdd = new JButton("Add!");
		btnRepAdd.setBounds(50,450,100,40);
		btnRepAdd.addActionListener(this);
		
		frame2.add(l1);
		frame2.add(l2);
		frame2.add(l3);
		frame2.add(l4);
		
		
		frame2.add(box1);
		frame2.add(box2);
		frame2.add(box3);
		frame2.add(box4);
		
		frame2.add(btnRepAdd);
		
		frame2.setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1) {
			openRepresentativeFrame();
		}
		
		if(e.getSource() == btn2) {
			openCustomerFrame();
		}
		
		if(e.getSource() == btn3) {
			
			try {
				Statement stmt = conn.createStatement();
				String query1 = "select * from cust";
				String query2 = "select * from rep";
				ResultSet rs1 = stmt.executeQuery(query1);
				
				// To retrieve all repno from selectedRep
				while(rs1.next()) {
					int creditLimit = rs1.getInt("credlimit");	//column name is credlimit
					String repNo = rs1.getString("repno");
					int hmi=1;	//hash map index
					
					if(creditLimit>=15000 && !selectedRep.containsKey(repNo)) {
						selectedRep.put(repNo, hmi);
						hmi++;
					}
				}
				
				String repDetails="";
				ResultSet rs2 = stmt.executeQuery(query2);

				while(rs2.next()) {
					String repNo = rs2.getString("repno");

					if(selectedRep.containsKey(repNo)) {
						System.out.println("Rep No: "+rs2.getString("repno"));
						System.out.println("Rep Name: "+rs2.getString("repname"));
						System.out.println("State: "+rs2.getString("state"));
						System.out.println("Comission: "+rs2.getString("comission"));
						
						repDetails+=("Rep No: "+rs2.getString("repno")+"\n");
						repDetails+=("Rep Name: "+rs2.getString("repname")+"\n");
						repDetails+=("State: "+rs2.getString("state")+"\n");
						repDetails+=("Comission: "+rs2.getString("comission")+"\n");
						repDetails+="\n";
					}
					
				}
				
				openDisplayFrame(repDetails);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
		
		if(e.getSource() == btnRepAdd) {
			try {
				
				String a1 = box1.getText();
				String a2 = box2.getText();
				String a3 = box3.getText();
				String a4 = box4.getText();

				Statement stmt = conn.createStatement();
				String query = "insert into rep values ('"+a1+"','"+a2+"','"+a3+"','"+a4+"');";
				stmt.executeUpdate(query);
				frame2.dispose();
				System.out.println("Frame 2 disposed");
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(box1, "There is some error with details added");
			}
		}
		
	}

}
