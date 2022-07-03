package labPractice7;

import java.io.*;
import java.util.*;

public class Driver {

	static void printBookDetail(Book b) {
		System.out.println("Title: "+b.title);
		System.out.println("Author: "+b.author);
		System.out.println("Pubisher: "+b.publisher);
		System.out.println("Price: "+b.price);
		System.out.println("<---------->");
	}
	
	static void printBookDatabase(ArrayList<Book> bookDB) {

		for (Book b: bookDB) {
			printBookDetail(b);
		}
		
	}
	
	
	static void sortBooks(ArrayList<Book> bookDB) {
		Collections.sort(bookDB, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return (int)(b1.price) - (int)(b2.price);
			}
		});
		
		printBookDatabase(bookDB);
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Book> bookDatabase = new ArrayList<Book>();
		
		bookDatabase.add(new Book("b1","auth1","pub1",1000));
		bookDatabase.add(new Book("b2","auth2","pub2",800));
		bookDatabase.add(new Book("b3","auth3","pub3",900));
		
		while(true) {
			System.out.println("Do u want to enter book details? Mention yes/no");
			
			String choice = sc.nextLine();
			if(choice.toUpperCase().equals("YES")){
				System.out.println("Enter Book Details: ");
				System.out.println("Enter Title");
			    String title =sc.nextLine();
			    
			    System.out.println("Enter Author");
			    String author = sc.nextLine();
			    
			    System.out.println("Enter Publisher");
			    String publisher = sc.nextLine();
			    
			    System.out.println("Enter Price");
			    double price = Double.parseDouble(sc.nextLine());
			    
			    Book b1 = new Book(title,author,publisher,price);
			    
			    bookDatabase.add(b1);
			  
			}
			else {
				break;
			}
		}
		
		// Write a method to sort the books in ascending order of price and store it in another List
		
		ArrayList<Book> bookDatabaseDuplicate = new ArrayList<Book>(bookDatabase);		
		sortBooks(bookDatabaseDuplicate);
		

		// Maintain the book details with respect to an unique book id.
		
		HashMap<Integer, Book> hmap = new HashMap<>();
		int i=1;
		for(Book b:bookDatabase) {
			hmap.put(i, b);
			i++;
		}
		
		//printing hash map using for each loop
		hmap.forEach((Integer sid, Book b)->{
			System.out.println("Serial ID: "+sid);
			printBookDetail(b);
		});
		
		
		
		// Prompt for an author name and list all the books with the same author name
		
		System.out.println("Enter the author name: ");
		String authorName = sc.nextLine();
		
		int flag1=0;	//To check if any book is there by that author or not
		for(Book b:bookDatabase) {
			if(authorName.equals(b.author)) {
				printBookDetail(b);
				flag1=1;
			}
		}
		
		if(flag1==0) {System.out.println("There are no books by that author");}
		
		
		
		// Create a new list holding all the book details with price greater than a user specified price.
		
		System.out.println("Enter the price above which you want the books to be stored: ");
		double price = sc.nextDouble();
		sc.nextLine();	//This is done because there is a bug in java.
		
		System.out.println("Entered Price: "+price);
		
		ArrayList<Book> greaterPriceDatabase = new ArrayList<Book>();
		
		int flag2=0;	//To check if any book is there suiting that price range or not
		for(Book b:bookDatabase) {
			if(b.price>=price) {
				greaterPriceDatabase.add(b);
				flag2=1;
			}
		}
		
		if(flag2==0) {System.out.println("There are no books in that price range");}
		else {
			System.out.println("Books belonging to the new price database: ");
			printBookDatabase(greaterPriceDatabase);
		}
		
		
		// Find all the books that match either the whole or a part of the book title.
		
		System.out.println("Enter the partial or complete title: ");
		String partialTitle = sc.nextLine();
		
		int flag3=0;	//To check if any book is there suiting that price range or not
		for(Book b:bookDatabase) {
			if(b.title.contains(partialTitle)) {
				printBookDetail(b);
				flag3=1;
				break;
			}
		}
		
		if(flag3==0) {System.out.println("There are no books in that price range");}
		
		
		
		
		// Identify a publisher and print books from a particular publisher. 
		// The code for the above will be same as "prompt for author name ...." case just replace author with publisher
		
		
		// Update the publisher details based on a title
		
		System.out.println("Enter a title whose publisher is to be updated: ");
		String enteredTitle = sc.nextLine();
		System.out.println("Enter the updated publishers name: ");
		String updatedPublisher = sc.nextLine();
		
		int flag4=0;	//To check if any book is there suiting that title or not
		for(Book b:bookDatabase) {
			if(b.title.equals(enteredTitle)) {
				b.publisher=updatedPublisher;
				flag4=1;
				
				System.out.println("Updated Book Details are: ");
				printBookDetail(b);
				break;
			}
		}
		
		if(flag4==0) {System.out.println("There are no books in that price range");}
		

		
	}

}
