package eShop.model;

import eShop.model.user.Customer;
import eShop.model.user.Supplier;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DeliveryInfo {
	
	@Id@GeneratedValue
	private Integer id;
	private Integer trackingNumber;
	private LocalDate expectedArrival;
	private LocalDate orderedDate;
	
	@OneToOne //uni
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@OneToOne //uni
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne //uni
	@JoinColumn(name = "order_id")
	private Order order;	
	
	public DeliveryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryInfo(Supplier supplier, Customer customer, Order order, Integer trackingNumber,
			LocalDate expectedArrival, LocalDate orderedDate) {
		super();
		this.supplier = supplier;
		this.customer = customer;
		this.order = order;
		this.trackingNumber = trackingNumber;
		this.expectedArrival = expectedArrival;
		this.orderedDate = orderedDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(Integer trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public LocalDate getExpectedArrival() {
		return expectedArrival;
	}
	public void setExpectedArrival(LocalDate expectedArrival) {
		this.expectedArrival = expectedArrival;
	}
	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
	@Override
	public String toString() {
		return "DeliveryInfo [id=" + id + ", supplier=" + supplier + ", customer=" + customer + ", order=" + order
				+ ", trackingNumber=" + trackingNumber + ", expectedArrival=" + expectedArrival + ", orderedDate="
				+ orderedDate + "]";
	}
	
	

}
