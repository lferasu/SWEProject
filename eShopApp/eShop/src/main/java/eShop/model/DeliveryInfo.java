package eShop.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import eShop.model.user.Customer1;
import eShop.model.user.Supplier1;
import eShop.model.user.User;

@Entity
public class DeliveryInfo {
	
	@Id@GeneratedValue
	private Integer id;
	private Integer trackingNumber;
	private LocalDate expectedArrival;
	private LocalDate orderedDate;
	
	@OneToOne //uni
	@JoinColumn(name = "supplier_id")
	private User supplier;
	
	@OneToOne //uni
	@JoinColumn(name = "customer_id")
	private User customer;
	
	@OneToOne //uni
	@JoinColumn(name = "order_id")
	private Order order;	
	
	public DeliveryInfo() {

	}
	public DeliveryInfo(User supplier, User customer, Order order, Integer trackingNumber,
						LocalDate expectedArrival, LocalDate orderedDate) {

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
	public User getSupplier() {
		return supplier;
	}
	public void setSupplier(User supplier) {
		this.supplier = supplier;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
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
