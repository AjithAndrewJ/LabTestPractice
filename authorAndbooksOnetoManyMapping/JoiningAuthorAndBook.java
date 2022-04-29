package authorAndbooksOnetoManyMapping;

import java.util.Scanner;

public class JoiningAuthorAndBook {

	public static void main(String[] args) {
		int choice;
		BookDetails bd=new BookDetails();
    	Scanner sc=new Scanner(System.in);
    	do {
	    	System.out.println("-----------Book Detail-----------\nPress 1.To Create\nPress 2.To Read\n"
	    			+ "Press 3.To Update\nPress 4.To Delete\n"
	    			+ "Press 5.To Quit"); 
	    	System.out.println("====================================================================");
	    	System.out.println("Enter your choice!"); 
	    	choice=sc.nextInt(); 
	    	System.out.println("====================================================================");
	    	switch(choice) {
	    	case 1:
	    		bd.bookDetail();
	    		break;
	    	case 2:
	    		bd.display();
	    		break;
	    	case 3:
	    		bd.update();
	    		break;
	    	case 4:
	    		bd.delete();
	    		break;
	    	case 5:
	    		System.out.println("Thank You Visit Again!");
	    		System.out.println("====================================================================");
	    		break;
	    	default:
	    		System.err.println("Enter the Correct choice!");
	    		System.out.println("====================================================================");
	    	}
    	}while(choice!=5);
    	sc.close();
	}
}
