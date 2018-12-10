package com.ebs.controllers;

import java.util.List;

import com.ebs.domain.Manager;
import com.ebs.domain.User;
import com.ebs.domaininterfaces.PrintReportInterface;

public class PrintReportForNoInsuranceUsers implements PrintReportInterface {

	@Override
	public void printReport(List<User> users, Manager manager) throws Exception {
		System.out.println("\n###REPORT OF EMPOYEES WITH NO INSURANCE###");
		System.out.println("______________________________________________");
		System.out.println("Total number of Employees with No Enrollment: " + users.size());
		System.out.println("\nName\t\t\t\tEmployee ID\t\t\tSSN");
		for (User user : users) {
			System.out.println(user.getName() + "\t\t\t\t" + user.getEmpId() + "\t\t\t" + user.getSsn());
		}
	}
}
