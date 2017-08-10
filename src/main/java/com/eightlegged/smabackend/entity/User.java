package com.eightlegged.smabackend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Long id;

	@Column(name = "user_email", nullable = false, unique = true)
	private String email;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "user_pw", nullable = false)
	private String password;

	@Column(name = "user_auth", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_mt_connect", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "meeting_id", referencedColumnName = "meeting_id"))
	private List<Meeting> meetingList = new ArrayList<>();

	public User() {

	}

	public User(Long id) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	@JsonIgnore
	public List<Meeting> getMeetingList() {
		return meetingList;
	}

	public void setMeetingList(List<Meeting> meetingList) {
		this.meetingList = meetingList;
	}
}