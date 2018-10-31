package com.ebs.domain;

public class User {

	public User(String name, int empId, String phone, String username, String password, String type, int ssn) {
		this.name = name;
		this.empId = empId;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.type = type;
		this.ssn = ssn;
	}

	private String name;
	private int empId;
	private String phone;
	private String username;
	private String password;
	private String type;
	private int ssn;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the ssn
	 */
	public int getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

}
