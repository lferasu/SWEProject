package eShop.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import eShop.model.BillingInfo;
import eShop.model.Subscription;

@Entity
public class Customer extends User{
	@Id@GeneratedValue
	private Integer id;
	private String billingAddress;
	private String shippingAddress;
	
	@OneToMany
	@JoinColumn(name="fk_customer")
	private List<BillingInfo> billingInfos = new ArrayList<BillingInfo>();
	
	@OneToMany
	@JoinColumn(name="fk_customer")
	private List<Subscription> subscriptions = new ArrayList<Subscription>();
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String username, String password, String firstName, String lastName, String email,
			Boolean isValid) {
		super(username, password, firstName, lastName, email, isValid);
		// TODO Auto-generated constructor stub
	}
	public Customer(String billingAddress, String shippingAddress, List<BillingInfo> billingInfos,
			List<Subscription> subscriptions) {
		super();
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.billingInfos = billingInfos;
		this.subscriptions = subscriptions;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public List<BillingInfo> getBillingInfos() {
		return billingInfos;
	}
	public void setBillingInfos(List<BillingInfo> billingInfos) {
		this.billingInfos = billingInfos;
	}
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
				+ ", billingInfos=" + billingInfos + ", subscriptions=" + subscriptions + "]";
	}
	
	
	
}
