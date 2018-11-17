package com.ebs.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.NotifyVendor;
import com.ebs.constants.VendorEnum;
import com.ebs.db.ConsoleReaderUtility;
import com.ebs.db.CsvUtility;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;

public class NotifyVendorController {

	public void notifyVendor(Manager manager) throws Exception {

		CsvUtility csvUtility = new CsvUtility();
		List<CSVRecord> records = csvUtility.read(FilePathConstants.VENDOR_CSV);
		ConsoleReaderUtility csvReaderUtility = new ConsoleReaderUtility();
		BiReportingController brc = new BiReportingController();
		List<User> users = brc.generateReportForEmployeeInsuranceType();
		List<Employee> employeesToBeNotified = new ArrayList<Employee>();
		Menus menus = new Menus();

		System.out.println("\nThese Vendors are available in the system. Whcih one do you want to notify");

		for (CSVRecord csvRecord : records) {
			System.out.println(csvRecord.getRecordNumber() + ". " + csvRecord.get(VendorEnum.vname) + "("
					+ csvRecord.get(VendorEnum.vtype) + ")");
		}

		int selection = csvReaderUtility.readInt();

		CSVRecord recordSelected = records.get(selection - 1);

		System.out.println("\nYou have selected option " + recordSelected.getRecordNumber() + ": "
				+ recordSelected.get(VendorEnum.vname) + "(Insurance Type Provided=>> "
				+ recordSelected.get(VendorEnum.vtype) + ")");
		System.out.println("\nList of users with Vendor: " + recordSelected.get(VendorEnum.vname));
		System.out.println("======================================");

		for (User user : users) {

			Employee employee = (Employee) user;
			if (employee.getVendorName().equalsIgnoreCase(recordSelected.get(VendorEnum.vname))) {
				employeesToBeNotified.add(employee);
				System.out.println(employee.getName() + "(" + employee.getVendorName() + ")");
			}
		}
		System.out.println("\nDo you want to Go ahead and notify the vendor for the elections (1 for Yes | 2 for No)?");
		int select = csvReaderUtility.readInt();
		if (select == 1) {
			notifyUsersToVendor(employeesToBeNotified);
		} else if (select == 2) {
			System.out.println("\nyou have choosen not to notify the Vendors...Going back to the previous menu.");
			menus.managerMainMenu(manager);
		} else {
			System.out.println("\nInvalid option selected. Select 1|2");
		}
	}

	public void notifyUsersToVendor(List<Employee> employees) throws Exception {
		System.out.println("\nNotifying user elections to External Vendor Systems...");
		CsvUtility csvUtility = new CsvUtility();
		List<CSVRecord> csvRecords = csvUtility.read(FilePathConstants.NOTIFY_VENDOR_CSV);
		Set<Employee> employeesApproved = new HashSet<Employee>();
		List<Employee> employeesNotApproved = new ArrayList<Employee>();
		CsvUtility csvutility = new CsvUtility();
		employeesApproved.addAll(employees);
		for (CSVRecord csvRecord : csvRecords) {
			for (Employee employeeToNotify : employees) {
				if (employeeToNotify.getName().equalsIgnoreCase(csvRecord.get(NotifyVendor.name))
						&& employeeToNotify.getVendorName().equalsIgnoreCase(csvRecord.get(NotifyVendor.vendor))
						&& employeeToNotify.getPolicyType().equalsIgnoreCase(csvRecord.get(NotifyVendor.policyType))) {
					employeesApproved.remove(employeeToNotify);
					employeesNotApproved.add(employeeToNotify);
				}
			}
		}
		boolean notifyVendorSuccessful = csvutility.writeNotifyVendor(employeesApproved);
		if (notifyVendorSuccessful) {
			if (!employeesApproved.isEmpty()) {
				System.out.println("\nThe following users were approved by the vendor");
				System.out.println("_________________________________________________");
				for (Employee employee : employeesApproved) {
					System.out.println(employee.getName());
				} 
			}
			if (!employeesNotApproved.isEmpty()) {
				System.out.println("\nThe following users were not approved. They are already approved.");
				System.out.println("_________________________________________________________________");

				for (Employee employee : employeesNotApproved) {
					System.out.println(employee.getName());
				}
			}
		}
	}
}
