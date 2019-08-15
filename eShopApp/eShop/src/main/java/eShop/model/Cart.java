package eShop.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import eShop.model.user.User;

@Entity
public class Cart {
	
	@Id@GeneratedValue
	private Integer id;
	
	@OneToOne //uni
	@JoinColumn(name = "cart_customer_id")
	private User customer;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Book> books = new ArrayList<>();

	private Double totalPrice;

	private int numberOfBooks=0;



	private String sessionId;


	public Cart() {
	}

	public Cart(User customer, List<Book> books, Double totalPrice) {
		this.customer = customer;
		this.books = books;
		this.totalPrice = totalPrice;
	}


	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public void setBooks(List<Book> books)
	{
		numberOfBooks += books.size();
		this.books = books;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getId() {
		return id;
	}


	public User getCustomer() {
		return customer;
	}

	public List<Book> getBooks() {
		return books;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", customer=" + customer +
				", books=" + books +
				", totalPrice=" + totalPrice +
				'}';
	}
}
