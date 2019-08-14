package eShop.model.user;

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




	User() {
	}

	public User(String username, String password, Role role, String permissions, String firstName, String lastName, String email, Boolean active) {
		this.username = username;
		this.password = password;
		this.role=role;
		this.permissions = permissions;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
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

	public Boolean isActive() {
		return active;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
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