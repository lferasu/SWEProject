package eShop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import eShop.model.user.Customer1;
import eShop.model.user.User;

@Entity
public class Subscription {
	@Id@GeneratedValue
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private User customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscription(Customer1 customer, Category category) {
		super();
		this.customer = customer;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", customer=" + customer + ", category=" + category + "]";
	}
	
	

}
