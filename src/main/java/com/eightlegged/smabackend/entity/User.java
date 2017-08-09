package com.eightlegged.smabackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName User.java
 * @Project smabackend
 * @Date 2017. 8. 9.
 */

@Entity
@Table(name = "user_info")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7872760785026865644L;

	@Id
	@GeneratedValue
	@Column(name = "user_id",nullable = false)
	private long id;

	@Column(name = "user_email", nullable = false, unique = true)
	private String email;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "user_pw", nullable = false)
	private String password;

	@Column(name = "user_auth", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
	}

	public User(long id) {
		this.id = id;
	}

	public User(String email, String userName) {
		this.email = email;
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}