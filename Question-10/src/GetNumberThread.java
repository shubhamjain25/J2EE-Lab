import java.util.Scanner;
public class GetNumberThread extends Thread{
	public void run() {
		String[] digitToString = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number greater than 4 digits");
		int num = sc.nextInt();
		
		// For number to be greater than 4 digits it needs to be above 9999
		if(num<9999) {
			System.out.println("Invalid number input");
		}
		else {
			String numberInString="";
			while(num!=0) {
				int digit = num%10;
				num/=10;
				
				//We are doing it this way because the above method gets us all the digits in reverse order
				numberInString=digitToString[digit]+" "+numberInString;
			}
			System.out.println(numberInString);
		}
	}
}
