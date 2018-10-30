package com.ebs.domain;

/**
 * Domain class for the Manager in the organization
 * 
 * @author faisalkhan
 *
 */
public class Manager extends User {

	public Manager(String name, int empId, String phone, String username, String password, String type, int ssn
			) {
		super(name, empId, phone, username, password, type, ssn);
	}
}
