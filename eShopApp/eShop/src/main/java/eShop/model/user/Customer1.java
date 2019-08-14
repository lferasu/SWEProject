package eShop.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import eShop.model.BillingInfo;
import eShop.model.Subscription;

@Entity
public class Customer1 extends User{
	@Id@GeneratedValue
	private Integer id;
	@OneToOne
	private Address billingAddress;
	@OneToOne
	private Address shippingAddress;

	@OneToMany
	@JoinColumn(name="fk_customer")
	private List<BillingInfo> billingInfos = new ArrayList<BillingInfo>();

	@OneToMany
	@JoinColumn(name="fk_customer")
	private List<Subscription> subscriptions = new ArrayList<Subscription>();

	public Customer1() {
		super();
	}

	public Customer1(Address billingAddress, Address shippingAddress, List<BillingInfo> billingInfos,
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
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
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
		return "Customer [id=" + id + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
				+ ", billingInfos=" + billingInfos + ", subscriptions=" + subscriptions + "]";
	}



}