package jdbcProject1;

import java.sql.*;

public class Driver {

	static Connection conn=null;

	static boolean createConnection() {
		try {
			String connUrl = "jdbc:mysql://localhost:3306/db1";
			String username = "root";
			String password = "root";
			
			conn = DriverManager.getConnection(connUrl,username,password);
			
			System.out.println("Connection Established");
			return true;
		}
		catch(Exception ex){
			System.out.println(ex);
			return false;
		}
	}
	
	public static void main(String[] args) {
		boolean isConnected = false;
		
		while(isConnected==false) {
			isConnected = createConnection();
		}
		
		// We are passing the connection we have made, into the frame.
		MyFrame myFrame = new MyFrame(conn);
	}

}
