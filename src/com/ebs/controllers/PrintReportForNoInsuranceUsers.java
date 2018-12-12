package com.ebs.controllers;

import java.util.List;

import com.ebs.domain.Manager;
import com.ebs.domain.User;
import com.ebs.domaininterfaces.PrintReportInterface;
import com.ebs.loggingServices.JavaLogging;
import com.ebs.techservicesinterfaces.LoggingHandler;

public class PrintReportForNoInsuranceUsers implements PrintReportInterface {
	LoggingHandler loggerJava = new JavaLogging();

	@Override
	public void printReport(List<User> users, Manager manager) throws Exception {
		loggerJava.printLog("Printing Report for Employees With No Insurance",
				PrintReportForNoInsuranceUsers.class.getName());
		System.out.println("\n###REPORT OF EMPOYEES WITH NO INSURANCE###");
		System.out.println("______________________________________________");
		System.out.println("Total number of Employees with No Enrollment: " + users.size());
		System.out.println("\nName\t\t\t\tEmployee ID\t\t\tSSN");
		for (User user : users) {
			System.out.println(user.getName() + "\t\t\t\t" + user.getEmpId() + "\t\t\t" + user.getSsn());
		}
	}
}
