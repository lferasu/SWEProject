package eShop.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Supplier1 extends User{
	
	@Id@GeneratedValue
	private Integer id;
	private String companyName;

	@OneToOne
	@JoinColumn(name = "supplier_address_id")
	private Address address;

	public Supplier1() {
	}

	public Supplier1(String companyName, Address address) {
		super();
		this.companyName = companyName;
		this.address = address;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Supplier [companyName=" + companyName + ", address=" + address + "]";
	}
}

