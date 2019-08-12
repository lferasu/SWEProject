package eShop.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import eShop.model.user.Customer;

@Entity
public class Cart {
	
	@Id@GeneratedValue
	private Integer id;
	
	@OneToOne //uni
	@JoinColumn(name = "cart_customer_id")
	private Customer customer;
	@OneToMany
	@JoinColumn(name="fk_book")
	private List<Book> books;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Customer customer, List<Book> books) {
		super();
		this.customer = customer;
		this.books = books;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", customer=" + customer + ", books=" + books + "]";
	}
	
	
	

}
