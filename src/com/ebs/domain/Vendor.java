package com.ebs.domain;

/**
 * Domain class for the vendor providing the employee benefits
 * 
 * @author faisalkhan
 */
public class Vendor implements User {

	private String name;

	private int id;
	
	private String type;
	
	private String contact;
	

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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
