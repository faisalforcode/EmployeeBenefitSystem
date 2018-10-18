/**
 * 
 */
package com.ebs.domain;

/**
 * This is the Domain class for employee Domain object. Also Encompassing the
 * methods for Employee related functionalities
 * 
 * @author faisalkhan
 *
 */
public class Employee {

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

}
