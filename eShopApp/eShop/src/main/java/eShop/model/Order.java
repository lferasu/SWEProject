package eShop.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import eShop.model.user.Address;
import eShop.model.user.Customer1;
import eShop.model.user.User;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id@GeneratedValue
	private Integer id;
	private String orderNumber;
	private LocalDate date;
	private Double amount;
	
    @OneToOne
    @JoinColumn(name = "fk_customer")	
	private User customer;
    
    @OneToOne
    @JoinColumn(name = "fk_cart")
	private Cart cart;
    
    @OneToOne
    @JoinColumn(name = "fk_shippingAddress")
	private Address shippingAddress;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderNumber, User customer, Cart cart, LocalDate date, Address shippingAddress,
                 Double amount) {
		super();
		this.orderNumber = orderNumber;
		this.customer = customer;
		this.cart = cart;
		this.date = date;
		this.shippingAddress = shippingAddress;
		this.amount = amount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", customer=" + customer + ", cart=" + cart
				+ ", date=" + date + ", shippingAddress=" + shippingAddress + ", amount=" + amount + "]";
	}
	
	
	

}
