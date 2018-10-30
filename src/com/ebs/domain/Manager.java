/**
 * 
 */
package com.ebs.domain;

/**
 * Domain class for the Manager in the organization
 * 
 * @author faisalkhan
 *
 */
public class Manager implements User {

	/**
	 * Name of the Manager
	 */
	private String name;

	/**
	 * Id of the Manager for org
	 */
	private int empId;

	private String username;

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

}
