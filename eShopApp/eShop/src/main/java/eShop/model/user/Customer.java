package eShop.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import eShop.model.BillingInfo;
import eShop.model.Subscription;

@Entity
@Table(name = "customer")
public class Customer extends User{
	@Id@GeneratedValue
	private Integer id;
	@OneToOne //uni
	@JoinColumn(name="shipping_address_id")  //FK
	private Address shippingAddress;
	
	@OneToMany
	@JoinColumn(name="fk_customer")
	private List<BillingInfo> billingInfos = new ArrayList<BillingInfo>();
	
	@OneToMany
	@JoinColumn(name="fk_customer")
	private List<Subscription> subscriptions = new ArrayList<Subscription>();
	
	public Customer() {

	}
	public Customer(String username, String password, String firstName, String lastName, String email,
			Boolean isValid) {
		super(username, password, firstName, lastName, email, isValid);

	}
	public Customer(Address shippingAddress, List<BillingInfo> billingInfos,
			List<Subscription> subscriptions) {

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
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
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
		return "Customer [id=" + id  + ", shippingAddress=" + shippingAddress
				+ ", billingInfos=" + billingInfos + ", subscriptions=" + subscriptions + "]";
	}
	
	
	
}
