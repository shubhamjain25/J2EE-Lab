import java.util.*;

public class MissedCallList {

	ArrayList<MissedCall> missedList = new ArrayList<MissedCall>();
	
	MissedCallList(){
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("To add new missed-call press 1, otherwise 0");
			
			if(sc.nextLine().equals("1")) {
				
				if(missedList.size()==5) {
					missedList.remove(0);
				}
				
				System.out.print("Enter number: ");
				long phno = sc.nextLong();
				sc.nextLine();
				
				MissedCall mc1 = new MissedCall(phno);
				missedList.add(mc1);
			}
			else {
				break;
			}
			
		}
		
	}
	
	void displayOptions() {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Delete 2. Display 3. Exit");
			sc.nextLine();
			Iterator<MissedCall> itr = missedList.iterator();
			
			if(sc.nextLine().equals("1")) {
				
				System.out.print("Enter number whose missed call is to be deleted: ");
				long phno = sc.nextLong();

				while(itr.hasNext()) {
					if(itr.next().phno==phno) {itr.remove();}
				}
				
			}
			else if(sc.nextLine().equals("2")){
				System.out.println("Missed Call Log:");
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}
			}
			else {
				break;
			}
			

			
		}
	}
	
}
