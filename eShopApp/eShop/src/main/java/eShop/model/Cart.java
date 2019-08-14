package eShop.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import eShop.model.user.User;

@Entity
public class Cart {
	
	@Id@GeneratedValue
	private Integer id;
	
	@OneToOne //uni
	@JoinColumn(name = "cart_customer_id")
	private User customer;
	@OneToMany
	@JoinColumn(name="fk_book")
	private List<Book> books = new ArrayList<>();
	private Double totalPrice;

	public Cart() {

	}

	public Cart(User customer, List<Book> books, Double totalPrice) {
		this.customer = customer;
		this.books = books;
		this.totalPrice = totalPrice;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public void setBooks(List<Book> books) {
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
