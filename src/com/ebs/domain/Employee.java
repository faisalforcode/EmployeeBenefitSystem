package com.ebs.domain;

/**
 * This is the Domain class for employee Domain object. Also Encompassing the
 * methods for Employee related functionalities
 * 
 * @author faisalkhan
 *
 */
public class Employee extends User {

	public Employee(String name, int empId, String phone, String username, String password, String type,
			int noOfDependents, String policyType, int ssn, String vendorName) {
		super(name, empId, phone, username, password, type, ssn);
		this.noOfDependents = noOfDependents;
		this.policyType = policyType;
		this.vendorName = vendorName;
	}

	/**
	 * Employee Id for the Org
	 */

	/**
	 * The name of the Vendor the employee has enrolled with
	 */
	private String vendorName;

	/**
	 * 
	 */

	/**
	 * Policy Id of the employee
	 */
	private String policyType;

	/**
	 * Phone Number
	 */

	private int noOfDependents;

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	@Override
	public String toString() {
		return "Employee [vendorName=" + vendorName + ",  policyType=" + policyType
				+ ", noOfDependents=" + noOfDependents + "]";
	}
}
