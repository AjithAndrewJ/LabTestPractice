package authorAndbooks;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Author {
	@Id
	private String auther;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="aut")
	private List<Book> book;
	
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	public Author(String auther, List<Book> book) {
		super();
		this.auther = auther;
		this.book = book;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
}
