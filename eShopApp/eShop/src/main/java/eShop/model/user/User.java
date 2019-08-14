package eShop.model.user;

import eShop.model.BillingInfo;
import eShop.model.Subscription;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "username", nullable = false, unique = true)
	@NotEmpty(message = "Please provide your username")
	private String username;


	private String password;

	@Enumerated(EnumType.STRING)
	private Role role = Role.CUSTOMER;

	private String permissions;

	@NotEmpty(message = "Please provide your first name")
	private String firstName;

	@NotEmpty(message = "Please provide your last name")
	private String lastName;

	@Column(name = "email", nullable = false)
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;

	private Boolean active;

	@Column(name = "confirmation_token")
	private String confirmationToken;

	private String companyName;

	@OneToOne
	@JoinColumn(name = "supplier_address_id")
	private Address address;

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


	public User(@NotEmpty(message = "Please provide your username") String username, String password, Role role, String permissions, @NotEmpty(message = "Please provide your first name") String firstName, @NotEmpty(message = "Please provide your last name") String lastName, @Email(message = "Please provide a valid email") @NotEmpty(message = "Please provide an email") String email, Boolean active) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.permissions = permissions;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
	}




	User() {
	}

	public User(@NotEmpty(message = "Please provide your username") String username, String password, Role role, String permissions, @NotEmpty(message = "Please provide your first name") String firstName, @NotEmpty(message = "Please provide your last name") String lastName, @Email(message = "Please provide a valid email") @NotEmpty(message = "Please provide an email") String email, Boolean active, String confirmationToken, String companyName, Address address, Address billingAddress, Address shippingAddress, List<BillingInfo> billingInfos, List<Subscription> subscriptions) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.permissions = permissions;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.confirmationToken = confirmationToken;
		this.companyName = companyName;
		this.address = address;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
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

	public List<String> getPermissionList(){
		if(this.permissions.length() > 0){
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}

	public List<String> getRoleList(){
		if(this.role != null){
			return Arrays.asList(this.role.toString());
		}
		return new ArrayList<>();
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				", permissions='" + permissions + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", active=" + active +
				", confirmationToken='" + confirmationToken + '\'' +
				'}';
	}
}