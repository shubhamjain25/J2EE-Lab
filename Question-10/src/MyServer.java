import java.io.*;
import java.net.*;

public class MyServer{
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
			String message = (String)dis.readUTF();
			System.out.println("Message: "+message);
			
			ss.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}