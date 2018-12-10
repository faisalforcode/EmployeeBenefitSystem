package com.ebs.controllers;

import java.util.List;

import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;
import com.ebs.domaininterfaces.PrintReportInterface;

public class PrintReportForVendorDistribution implements PrintReportInterface {

	@Override
	public void printReport(List<User> users, Manager manager) throws Exception {

		System.out.println("\n###REPORT OF EMPOYEES AND Vendor###");
		System.out.println("______________________________________________");
		System.out.println("\nName\t\t\t\tEmployee ID\t\t\tVendor");
		for (User user : users) {
			Employee employee = (Employee) user;
			System.out.println(
					employee.getName() + "\t\t\t\t" + employee.getEmpId() + "\t\t\t" + employee.getVendorName());
		}
	}

}
