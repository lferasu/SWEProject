package eShop.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import eShop.model.user.Address;
import eShop.model.user.Customer;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BillingInfo {
	@Id@GeneratedValue
	private Integer id;
	private Integer cardNumber;
	private String holderFullName;
	@NotNull
	@NotNull(message = "* Expiration Date is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expireDate;
	@Size(max = 3)
	private Integer securityDigits;
	
	@OneToOne //uni
	@JoinColumn(name="bill_address_id")  //FK
	private Address billingAddress;
	@ManyToOne
	private Customer customer;
	
	public BillingInfo() {

	}
	public BillingInfo(Integer cardNumber, String holderFullName, LocalDate expireDate, Integer securityDigits,
			Address billingAddress) {

		this.cardNumber = cardNumber;
		this.holderFullName = holderFullName;
		this.expireDate = expireDate;
		this.securityDigits = securityDigits;
		this.billingAddress = billingAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getHolderFullName() {
		return holderFullName;
	}
	public void setHolderFullName(String holderFullName) {
		this.holderFullName = holderFullName;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public Integer getSecurityDigits() {
		return securityDigits;
	}
	public void setSecurityDigits(Integer securityDigits) {
		this.securityDigits = securityDigits;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
	public String toString() {
		return "BillingInfo [id=" + id + ", cardNumber=" + cardNumber + ", holderFullName=" + holderFullName
				+ ", expireDate=" + expireDate + ", securityDigits=" + securityDigits + ", billingAddress="
				+ billingAddress + "]";
	}
	
	

}
