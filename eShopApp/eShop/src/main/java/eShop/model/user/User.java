package eShop.model.user;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String permissions;


	private String firstName;
	private String lastName;
	private String email;
	private boolean active;


	User() {
	}

	public User(String username, String password, Role role, String permissions, String firstName, String lastName, String email, boolean active) {
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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}