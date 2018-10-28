package com.ebs.domain;

/**
 * This is the Domain class for employee Domain object. Also Encompassing the
 * methods for Employee related functionalities
 * 
 * @author faisalkhan
 *
 */
public class Employee implements User{

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

	/**
	 * @return the policyId
	 */
	public int getPolicyId() {
		return policyId;
	}

	/**
	 * @param policyId the policyId to set
	 */
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	/**
	 * @return the phone
	 */
	public double getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(double phone) {
		this.phone = phone;
	}

	/**
	 * @return the noOfDependents
	 */
	public int getNoOfDependents() {
		return noOfDependents;
	}

	/**
	 * @param noOfDependents the noOfDependents to set
	 */
	public void setNoOfDependents(int noOfDependents) {
		this.noOfDependents = noOfDependents;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Name of the Employee
	 */
	private String name;

	/**
	 * Employee Id for the Org
	 */
	private int empId;

	/**
	 * The name of the Vendor the employee has enrolled with
	 */
	private String vendorName;
	
	/**
	 * 
	 */
	private int ssn;
	
	/**
	 * Policy Id of the employee
	 */
	private int policyId;
	
	/**
	 * Phone Number
	 */
	private double phone;
	
	/**
	 * No oF Dependents
	 */
	private int noOfDependents;
	
	/**
	 * Username of the employee
	 */
	private String username;
	
	/**
	 * password of the employee
	 */
	private String password;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName
	 *            the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", empId=" + empId +
				", vendorName='" + vendorName + '\'' +
				", ssn=" + ssn +
				", policyId=" + policyId +
				", phone=" + phone +
				", noOfDependents=" + noOfDependents +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
