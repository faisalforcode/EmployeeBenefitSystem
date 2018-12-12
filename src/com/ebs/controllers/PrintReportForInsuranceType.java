package com.ebs.controllers;

import java.util.List;

import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;
import com.ebs.domaininterfaces.PrintReportInterface;
import com.ebs.loggingServices.ApacheLogging;
import com.ebs.loggingServices.JavaLogging;
import com.ebs.techservicesinterfaces.LoggingHandler;

public class PrintReportForInsuranceType implements PrintReportInterface {

	LoggingHandler logger = new ApacheLogging();
	LoggingHandler loggerJava = new JavaLogging();

	@Override
	public void printReport(List<User> users, Manager manager) throws Exception {
	/*	logger.printLog("Report for employees and theie insurance type printed",
				PrintReportForInsuranceType.class.getName());
	*/	loggerJava.printLog("Report for employees and their insurance type printed",
				PrintReportForInsuranceType.class.getName());
		System.out.println("\n###REPORT OF EMPOYEES AND INSURANCE TYPE###");
		System.out.println("______________________________________________");
		System.out.println("\nName\t\t\t\tEmployee ID\t\t\tInsurance Type");
		for (User user : users) {
			Employee employee = (Employee) user;
			System.out.println(
					employee.getName() + "\t\t\t\t" + employee.getEmpId() + "\t\t\t" + employee.getPolicyType());
		}
	}

}
