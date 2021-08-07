package com.cropbiddingsystem.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="user")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id") 
	private int userId;
	private String password;
	private String role;
	private String fullName;
	private String mobile;
	private String address;
	private String aadhar;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public User(int userId, String password, String role, String fullName, String mobile, String address,
			String aadhar) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.mobile = mobile;
		this.address = address;
		this.aadhar = aadhar;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", fullName=" + fullName
				+ ", mobile=" + mobile + ", address=" + address + ", aadhar=" + aadhar + "]";
	}

		
	}


