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
	private Book book;
	private Double totalPrice;
	private BillingInfo billingInfo;

	public Cart() {

	}

	public Cart(Customer customer, Book book, Double totalPrice, BillingInfo billingInfo) {
		this.customer = customer;
		this.book = book;
		this.totalPrice = totalPrice;
		this.billingInfo = billingInfo;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setBillingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}

	public BillingInfo getBillingInfo() {
		return billingInfo;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", customer=" + customer +
				", books=" + book +
				", totalPrice=" + totalPrice +
				", billingInfo=" + billingInfo +
				'}';
	}
}
