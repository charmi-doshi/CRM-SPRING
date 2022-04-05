package com.bean;

public class CRM_bean {

	private int Id;
	private String name,address;
	private String keyperson,email;
	private int mobile1,mobile2;
	private int type;
	private String status;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getKeyperson() {
		return keyperson;
	}
	public void setKeyperson(String keyperson) {
		this.keyperson = keyperson;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile1() {
		return mobile1;
	}
	public void setMobile1(int mobile1) {
		this.mobile1 = mobile1;
	}
	public int getMobile2() {
		return mobile2;
	}
	public void setMobile2(int mobile2) {
		this.mobile2 = mobile2;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
