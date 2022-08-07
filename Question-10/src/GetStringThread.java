import java.util.Scanner;

public class GetStringThread extends Thread{
	
	public void run() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.next();
  
        int vowelCount=0;
  
        for(int i=0;i<str.length();i++) {      	
        	char ch = str.charAt(i);
        	if(ch=='a' || ch=='e' || ch=='i' || ch=='o'||ch=='u') {
        		vowelCount++;
        	}
        }
        
        System.out.print(vowelCount + " vowels present\n");
        
	}
}