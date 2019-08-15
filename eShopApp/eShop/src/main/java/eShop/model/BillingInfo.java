package eShop.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import eShop.model.user.Customer1;
import eShop.model.user.User;
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
//	@Size(max = 3)
	private Integer securityDigits;

	@ManyToOne
	private User customer;
	
	public BillingInfo() {

	}

	public BillingInfo(Integer cardNumber, String holderFullName, @NotNull @NotNull(message = "* Expiration Date is required") LocalDate expireDate, @Size(max = 3) Integer securityDigits, User customer) {
		this.cardNumber = cardNumber;
		this.holderFullName = holderFullName;
		this.expireDate = expireDate;
		this.securityDigits = securityDigits;
		this.customer = customer;
	}

	public BillingInfo(Integer cardNumber, String holderFullName, LocalDate expireDate, Integer securityDigits
			) {

		this.cardNumber = cardNumber;
		this.holderFullName = holderFullName;
		this.expireDate = expireDate;
		this.securityDigits = securityDigits;
//		this.billingAddress = billingAddress;
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

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getCustomer() {
        return customer;
    }

	@Override
	public String toString() {
		return "BillingInfo{" +
				"id=" + id +
				", cardNumber=" + cardNumber +
				", holderFullName='" + holderFullName + '\'' +
				", expireDate=" + expireDate +
				", securityDigits=" + securityDigits +
				", customer=" + customer +
				'}';
	}

}
