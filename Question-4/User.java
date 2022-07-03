package labPractice4;

import java.io.*;
import java.util.*;

public class User {
	
	String username; 
	String password;
	ArrayList<User> allowedUsers = new ArrayList<User>();
	
	User(String username, String password){
		this.username = username;
		this.password = password;
		
	}
	
	boolean isUserValid() {
//		for(User users: allowedUsers) {
//			if(users.username.equals(username) && users.password.equals(password)) {
//				return true;
//			}
//		}
//		return false;

		if(username.equals("shubh") && password.equals("1234")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
