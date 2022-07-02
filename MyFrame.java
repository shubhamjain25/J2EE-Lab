package proj2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
	
	
	JFrame frame;
	JLabel label1, label2, label3, label4, label5, label6;
	JTextField box1, box2, box3, box4, box5, box6;
	JButton btn1, btn2;
	JTextArea textArea;
	int age;
	double cgpa;
	
	MyFrame(){
		frame = new JFrame();	//creates a frame
		
		frame.setSize(900,600);		//sets the x-dimension and y-dimension of frame
		frame.setTitle("Frame");
		frame.setLayout(null);		//resets the whole layout, labels need to have setBounds to be visible
		
		label1 = new JLabel("Name:");
		label1.setFont(new Font("Arial", Font.PLAIN, 15));
		label1.setBounds(50,100,300,50);	//setBounds(x,y,width,height)
//		label1.setForeground(Color.RED);
//		label1.setBackground(Color.ORANGE);
//		label1.setOpaque(true);		//For visibility of colors

		box1 = new JTextField();
		box1.setBounds(150,100,200,40);	
		
		label2 = new JLabel("USN:");
		label2.setFont(new Font("Arial", Font.PLAIN, 15));
		label2.setBounds(50,150,300,50);	//setBounds(x,y,width,height)

		box2 = new JTextField();
		box2.setBounds(150,150,200,40);	
		
		label3 = new JLabel("Age:");
		label3.setFont(new Font("Arial", Font.PLAIN, 15));
		label3.setBounds(50,200,300,50);	//setBounds(x,y,width,height)

		box3 = new JTextField();
		box3.setBounds(150,200,200,40);	
		
		label4 = new JLabel("Address:");
		label4.setFont(new Font("Arial", Font.PLAIN, 15));
		label4.setBounds(50,250,300,50);	//setBounds(x,y,width,height)

		box4 = new JTextField();
		box4.setBounds(150,250,200,40);	
		
		label5 = new JLabel("SGPA1:");
		label5.setFont(new Font("Arial", Font.PLAIN, 15));
		label5.setBounds(50,300,100,50);	//setBounds(x,y,width,height)

		box5 = new JTextField();
		box5.setBounds(150,300,100,40);	
		
		label6 = new JLabel("SGPA2:");
		label6.setFont(new Font("Arial", Font.PLAIN, 15));
		label6.setBounds(50,350,100,50);	//setBounds(x,y,width,height)

		box6 = new JTextField();
		box6.setBounds(150,350,100,40);	
			
		btn1 = new JButton("Compute");
		btn1.setBounds(50,450,100,40);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Done");
		btn2.setBounds(200,450,100,40);
		btn2.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setBounds(500,100,300,400);
		textArea.setEditable(false);
		
		frame.add(box1);
		frame.add(box2);
		frame.add(box3);
		frame.add(box4);
		frame.add(box5);
		frame.add(box6);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		
		frame.add(btn1);
		frame.add(btn2);
		
		frame.add(textArea);
		
		frame.setVisible(true);		//displays the frame
	}

//	int isInteger(String str) {
//		int num = -1;
//		try {
//			num = Integer.parseInt(str);
//		}
//		catch(Exception e) {
//			return -1;
//		}
//		return num;
//	}
//	
//	double isDecimal(String str) {
//		double num;
//		try {
//			num = Double.parseDouble(str);
//		}
//		catch(Exception e) {
//			return -1;
//		}
//		return num;
//	}

	
	boolean checkForErrors() {
		
		// Syntax for a warning message dialog:
		// JOptionPane.showMessageDialog(frame,"<Warning-Message>","<Warning-Message-Title>",JOptionPane.WARNING_MESSAGE);
				
		// Syntax for a normal message dialog:
		// JOptionPane.showMessageDialog(frame,"<Warning-Message>");
		
		// Visit this site for more info: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
		
		//Null-Check
		if(box1.getText().isEmpty() || box2.getText().isEmpty() || box3.getText().isEmpty() || box4.getText().isEmpty() || box5.getText().isEmpty() || box6.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(frame, "One or more entries are empty.");
			return true;
		}
		
		
		//Age Integer & Age Range Check
//		age = isInteger(box3.getText());
		age = Integer.parseInt(box3.getText());
		if( age<18 || age>100 ) {
			JOptionPane.showMessageDialog(frame, "Age should be in integer, and between 18 to 100!");
			return true;
		}
		
		
//		double sgpa1 = isDecimal(box5.getText()); 
//		double sgpa2 = isDecimal(box6.getText()); 
		
		double sgpa1 = Float.parseFloat(box5.getText());
		double sgpa2 = Float.parseFloat(box6.getText());
		
		cgpa = (sgpa1+sgpa2)/2;

		
		if(sgpa1<0.0 || sgpa1>10.0 || sgpa2<0.0 || sgpa2>10.0) {
			JOptionPane.showMessageDialog(frame, "SGPA should be in decimal, and between 0.0 to 10.0!");
			return true;
		}
		
		
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			boolean errorCheck = checkForErrors();
			if(errorCheck==false) {
				JOptionPane.showMessageDialog(frame, "Cgpa comes out to be: "+ cgpa);
				System.out.println("Compute Pressed");
			}
		}
		
		if(e.getSource()==btn2) {
			boolean errorCheck = checkForErrors();
			if(errorCheck==false) {
				String data1 = "Name: "+box1.getText()+"\n"; 
				String data2 = "Usn: "+box2.getText()+"\n"; 
				String data3 = "Age: "+box3.getText()+"\n"; 
				String data4 = "Address: "+box4.getText()+"\n"; 
				String data5 = "CGPA: "+cgpa;
				textArea.setText(data1+data2+data3+data4+data5);
			}
		}
		
	}
}
