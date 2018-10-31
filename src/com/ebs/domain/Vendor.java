package com.ebs.domain;

/**
 * Domain class for the vendor providing the employee benefits
 * 
 * @author faisalkhan
 */
public class Vendor {

	/**
	 * @param name
	 * @param id
	 * @param type
	 * @param contact
	 */
	public Vendor(String name, String type, String contact) {
		super();
		this.name = name;
		this.type = type;
		this.contact = contact;
	}

	private String name;

	private String type;

	private String contact;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

}
