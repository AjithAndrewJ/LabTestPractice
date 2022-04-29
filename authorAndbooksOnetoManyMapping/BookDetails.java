package authorAndbooksOnetoManyMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("serial")
class AccountExistException extends Exception{
	 public AccountExistException(String message) {
		 super(message);
	 }
}

@SuppressWarnings("serial")
class AccountNotFoundException extends Exception{
	public AccountNotFoundException(String message) {
		 super(message);
	 }
}

public class BookDetails {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session=factory.openSession();
	Scanner sc=new Scanner(System.in);
	String book,author;
	int num;
	double price;
	public void bookDetail() {
		System.out.println("Enter Author Name: ");
		author=sc.nextLine();
		Author ca=checkExistingAccount(author);
		if(ca==null) {
			List<Book> list=new ArrayList<Book>();
			Transaction tx=session.beginTransaction();
			System.out.println("Enter number of books: ");
			num=sc.nextInt();
			for(int i=0;i<num;i++) {
				Book bk=new Book();
				sc.nextLine();
				System.out.println("Enter Book "+(i+1)+" Name: ");
				book=sc.nextLine();
				bk.setBook(book);
				System.out.println("Enter the Price: ");
				price=sc.nextDouble();
				bk.setPrice(price);
				list.add(bk);
				session.save(bk);
			}
			session.save(new Author(author, list));
			tx.commit();
			sc.nextLine();
			System.out.println("Your Book Detail has been created!");
		}
		System.out.println("===================================================================="); 
	}
	public void display() {
		Author a1=checkAccountNotFound();
		if(a1!=null) {
			List<Book> a=a1.getBook();
			System.out.println("Author: "+a1.getAuther());
			System.out.println("---------------------------------------------------------------------"); 
			for(Book A:a) {
				System.out.println("Book Name: "+A.getBook()+"\nBook Price: Rs."+A.getPrice());
				System.out.println("===================================================================="); 
			}
		}
		System.out.println("===================================================================="); 
	}
	public void update() {
		Author a2=checkAccountNotFound();
		if(a2!=null) {
			List<Book> a=a2.getBook();
			Transaction tx=session.beginTransaction();
			for(Book A:a) {
				System.out.println("Enter Book Name to update: ");
				String ch=sc.nextLine();
				if(A.getBook().equals(ch)){
					System.out.println("Enter the Updating Book Name: ");
					String ch1=sc.nextLine();
					A.setBook(ch1);
					System.out.println("Enter the updating price: ");
					double ch2=sc.nextDouble();
					A.setPrice(ch2);
					session.update(A);
					session.update(a2);
				}
			}
			tx.commit();
			System.out.println("Your book detail has been Updated!");
		}
		System.out.println("===================================================================="); 
	}

	public void delete() {
		Author a3=checkAccountNotFound();
		if(a3!=null) {
			Transaction tx=session.beginTransaction();
			session.delete(a3);
			tx.commit();
			System.out.println("Your author detail has been Deleted!");
		}
		System.out.println("===================================================================="); 
	}
	public Author checkExistingAccount(String authorName) {
		Author b=session.get(Author.class, authorName);
		try {
			if(b!=null) {
				throw new AccountExistException("Account number already exist!");
			}
		}catch(AccountExistException e) {
			System.err.println(e.getMessage());
		}
		return b;
	}
	
	public Author checkAccountNotFound() {
		System.out.println("Enter Author Name: ");
		String a=sc.nextLine();
		Author b=session.find(Author.class,a);
		try {
			if(b==null) {
				throw new AccountNotFoundException("Account number not found!");
			}
		}catch(AccountNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return b;
	}
}
