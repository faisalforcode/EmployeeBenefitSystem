package com.ebs.controllers;

import java.util.List;

import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;
import com.ebs.domaininterfaces.PrintReportInterface;
import com.ebs.loggingServices.JavaLogging;
import com.ebs.techservicesinterfaces.LoggingHandler;

public class PrintReportForVendorDistribution implements PrintReportInterface {
	LoggingHandler loggerJava = new JavaLogging();

	@Override
	public void printReport(List<User> users, Manager manager) throws Exception {
		loggerJava.printLog("Printing report for Vendor Distribution",
				PrintReportForVendorDistribution.class.getName());
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
