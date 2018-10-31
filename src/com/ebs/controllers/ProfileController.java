package com.ebs.controllers;

import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;

public class ProfileController {

	public void viewProfile(Object userInstance) {
		if (userInstance instanceof Employee) {
			Employee employee = (Employee) userInstance;
			System.out.println("\n########## Profile For " + employee.getName() + "##########");
			System.out.println("Name: " + employee.getName());
			System.out.println("Employee ID: " + employee.getEmpId());
			System.out.println("Contact number: " + employee.getPhone());
			System.out.println("SSN: " + employee.getSsn());
			System.out.println("Access Privelge: " + employee.getType());
			System.out.println("No. of Dependents: " + employee.getNoOfDependents());
			System.out.println("Vendor Name: " + employee.getVendorName());
			System.out.println("Policy Type: " + employee.getPolicyType());
		} else if (userInstance instanceof Manager) {
			//TODO:
		} else if (userInstance instanceof Admin) {

		}
	}
	
	public void update() {}
}
