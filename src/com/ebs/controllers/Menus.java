package com.ebs.controllers;

import java.io.IOException;
import java.util.List;

import com.ebs.constants.FilePathConstants;
import com.ebs.db.ConsoleReaderUtility;
import com.ebs.db.CsvUtility;
import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;
import com.ebs.domain.Vendor;

public class Menus {

	User user;
	LoginController loginController;
	ConsoleReaderUtility cru = new ConsoleReaderUtility();
	ProfileController pvc = new ProfileController();
	private String username;
	private String password;

	{
		loginController = new LoginController();
	}

	public void displayMainMenu() {
		System.out.println("\nSelect from the options below:");
		System.out.println("1. Login ");
		System.out.println("2. Exit..");
		System.out.println("Enter your choice (1|2): ");
		int choice = cru.readInt();

		if (choice == 1) {
			displayMenu();
		} else if (choice == 2) {
			exitSystem();
		} else {
			System.out.println("\nInvalid option Selected.. Select 1 or 2");
			displayMainMenu();
		}
	}

	private void exitSystem() {
		System.out.println("\nSystem terminated.... Thank you for using Employee Benefit System");
		System.exit(0);
	}

	public void displayMenu() {
		System.out.println("\nYou have chosen to Login.");
		verifyCredentials();
	}

	/**
	 * 
	 * @param cru
	 * @param user
	 */
	private void verifyCredentials() {
		System.out.println("\nPlease enter your username: ");
		username = cru.readString();
		System.out.println("Please enter your password: ");
		password = cru.readString();
		try {
			User userInstance = loginController.login(username, password);
			if (null != userInstance) {
				System.out.println("\nWelcome " + userInstance.getName() + "! You have logged in successfully... ");
				if (userInstance instanceof Employee) {
					Employee emp = (Employee) userInstance;
					employeeMainMenu(emp);
				} else if (userInstance instanceof Admin) {
					Admin admin = (Admin) userInstance;
					adminMainMenu(admin);
				} else if (userInstance instanceof Manager) {
					Manager manager = (Manager) userInstance;
					managerMainMenu(manager);
				}
			} else {
			    System.out.println(" ");
			    System.out.println("***********************************");
				System.out.println("Please check your login credentials.");
                System.out.println("***********************************");
				displayMainMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Employee Main Menu
	 * 
	 * @param userInstance
	 * @throws IOException
	 */
	private void employeeMainMenu(Employee emp) throws IOException {

		System.out.println("\nPlease select options from the menu below: ");
		System.out.println("1. View/Maintain Profile.");
		System.out.println("2. Make Elections.");
		System.out.println("3. Check status.");
		System.out.println("4. Logout");
		System.out.println("5. Exit.");

		int menuItem = cru.readInt();

		if (menuItem == 1) {
			profileViewMaintainMenu(emp);

		} else if (menuItem == 2) {
			makeElections(emp);
		} else if (menuItem == 3) {
			checkEnrollmentStatus(emp);
		} else if (menuItem == 4) {
			displayMainMenu();
		} else if (menuItem == 5) {
			exitSystem();
		}
	}

	private void makeElections(Employee emp) throws IOException {
		System.out.println(" ");
		System.out.println("Sorry, we are working on this part.");
		employeeMainMenu(emp);
	}

	private void checkEnrollmentStatus(Employee emp) throws IOException {
		if ((null == emp.getVendorName() || null == emp.getPolicyType()) && ("".equals(emp)) || "".equals(emp)) {
			System.out.println("\nYou are not enrolled...please select Make Election below to enroll\n");
			employeeMainMenu(emp);
		} else {
			System.out.println("\n Congratulations!! You are already enrolled...");
			employeeMainMenu(emp);
		}
	}

	/**
	 * admin main menu
	 * 
	 * @throws IOException
	 */
	private void adminMainMenu(Admin admin) throws IOException {

		System.out.println("Please select options from the menu below: ");
		System.out.println("1. View/Maintain Profile.");
		System.out.println("2. Create/Modify User.");
		System.out.println("3. Logout.");
		System.out.println("4. Exit.");
		int menuItem = cru.readInt();

		if (menuItem == 1) {
			profileViewMaintainMenu(admin);
			System.out.println(" ");
			profileViewMaintainMenu(admin);
		} else if (menuItem == 2) {
			createModifyUser(admin);
		} else if(menuItem == 3){
		    displayMainMenu();
        } else if (menuItem == 4) {
			exitSystem();
		}
	}

	private void createModifyUser(Admin admin) throws IOException {
		System.out.println("\n Please select an option to continue:");
		System.out.println("1. Create User");
		System.out.println("2. Modify User");
		System.out.println("3. Go Back");
		System.out.println("4. Exit");
		int selection = cru.readInt();
		if (1 == selection) {
			createUser(admin);
		} else if (2 == selection) {
			modifyUser(admin);
		} else if (3 == selection) {
			adminMainMenu(admin);
		} else if (4 == selection) {
			exitSystem();
		} else {

		}

	}

	private void modifyUser(Admin admin) throws IOException {
	    System.out.println("");
	    System.out.println("Sorry! we are working on this part");
	    createModifyUser(admin);
	}

	private void createUser(Admin admin) throws IOException {
		System.out.println("\n Enter the following details for the new user");
		System.out.println("Enter type of user: (E|M|A): ");
		String type = cru.readString();
		System.out.println("Enter name for the user:");
		String name = cru.readString();
		System.out.println("Enter Employee ID (Numbers only): ");
		int empId = cru.readInt();
		System.out.println("Enter Phone number: ");
		String phone = cru.readString();
		System.out.println("Enter username: ");
		String username = cru.readString();
		System.out.println("Enter temporary password: ");
		String password = cru.readString();
		System.out.println("Enter SSN (numbers only): ");
		int ssn = cru.readInt();

		if ("M".equalsIgnoreCase(type)) {
			Manager manager = new Manager(name, empId, phone, username, password, type, ssn);
			CsvUtility csvUtility = new CsvUtility();
			csvUtility.write(FilePathConstants.USERS_CSV, manager);
		} else if ("E".equalsIgnoreCase(type)) {

			Employee employee = new Employee(name, empId, phone, username, password, type, 0, null, ssn, null);
			CsvUtility csvUtility = new CsvUtility();
			csvUtility.write(FilePathConstants.USERS_CSV, employee);
		} else if ("A".equalsIgnoreCase(type)) {

		}
		createModifyUser(admin);
	}

	/**
	 * manager main menu
	 * 
	 * @throws IOException
	 */
	private void managerMainMenu(Manager manager) throws IOException {
		System.out.println("\nPlease select options from the menu below: ");
		System.out.println("1. View/Maintain Profile.");
		System.out.println("2. Generate BI Report.");
		System.out.println("3. Manager Vendor.");
		System.out.println("4. Logout.");
		System.out.println("5. Exit.");
		int menuItem = cru.readInt();

		if (menuItem == 1) {
			profileViewMaintainMenu(manager);
		} else if (menuItem == 2) {
			generateBiReports(manager);
		} else if (menuItem == 3) {
			vendorMainMenu(manager);
		} else if(menuItem == 4) {
		    displayMainMenu();
        } else if (menuItem == 5) {
			exitSystem();
		}
	}

	private void generateBiReports(Manager manager) throws IOException {
		BiReportingController brc = new BiReportingController();
		System.out.println("\n Select which Report you would like to see:");
		System.out.println("1. Employees with No Enrollment");
		System.out.println("2. Employees with particular Vendor.");
		System.out.println("3. Employees with Insurance Type.");
		System.out.println("4. Go back");
		System.out.println("5. Exit");
		int selection = cru.readInt();

		if (1 == selection) {
			List<User> users = brc.generateReportforEmployeeWithNoEnrollment();
			printReportForNoInsuranUsers(users, manager);
		} else if (2 == selection) {
			List<User> users = brc.generateReportForEmployeeInsuranceType();
			printReportForVendorDistribution(users, manager);
		} else if (3 == selection) {
			List<User> users = brc.generateReportForEmployeeInsuranceType();
			printReportforInsuranceType(users, manager);
		} else if (4 == selection) {
			managerMainMenu(manager);
		} else if (5 == selection) {
			exitSystem();
		} else {
			System.out.println("\nInvalid option.. Select Again");
			generateBiReports(manager);
		}
	}

	private void printReportForVendorDistribution(List<User> users, Manager manager) throws IOException {
		System.out.println("\n###REPORT OF EMPOYEES AND Vendor###");
		System.out.println("______________________________________________");
		System.out.println("\nName\t\t\t\tEmployee ID\t\t\tVendor");
		for (User user : users) {
			Employee employee = (Employee) user;
			System.out
					.println(employee.getName() + "\t\t\t\t" + employee.getEmpId() + "\t\t\t" + employee.getVendorName());
		}
		System.out.println("\n\nGenerate Another report");
		generateBiReports(manager);
	}

	private void printReportforInsuranceType(List<User> users, Manager manager) throws IOException {
		System.out.println("\n###REPORT OF EMPOYEES AND INSURANCE TYPE###");
		System.out.println("______________________________________________");
		System.out.println("\nName\t\t\t\tEmployee ID\t\t\tInsurance Type");
		for (User user : users) {
			Employee employee = (Employee) user;
			System.out
					.println(employee.getName() + "\t\t\t\t" + employee.getEmpId() + "\t\t\t" + employee.getPolicyType());
		}
		System.out.println("\n\nGenerate Another report");
		generateBiReports(manager);
	}

	private void printReportForNoInsuranUsers(List<User> users, Manager manager) throws IOException {
		System.out.println("\n###REPORT OF EMPOYEES WITH NO INSURANCE###");
		System.out.println("______________________________________________");
		System.out.println("Total number of Employees with No Enrollment: " + users.size());
		System.out.println("\nName\t\t\t\tEmployee ID\t\t\tSSN");
		for (User user : users) {
			System.out.println(user.getName() + "\t\t\t\t" + user.getEmpId() + "\t\t\t" + user.getSsn());
		}
		System.out.println("\n\nGenerate Another report");
		generateBiReports(manager);

	}

	/**
	 * vendor main menu
	 * 
	 * @param manager
	 * @throws IOException
	 */
	private void vendorMainMenu(Manager manager) throws IOException {

		System.out.println("Please select options from the menu below: ");
		System.out.println("1. Add Vendor");
		System.out.println("2. Modify Vendor.");
		System.out.println("3. Go Back.");
		System.out.println("4. Exit.");
		int menuitem = cru.readInt();

		if (menuitem == 1) {
			addVendorDetails();
			System.out.println("");
			vendorMainMenu(manager);
		} else if (menuitem == 2) {
			modifyvendordetails();
			System.out.println("");
			System.out.println("Sorry we are working on this part.");
			vendorMainMenu(manager);
		} else if (menuitem == 3) {
			managerMainMenu(manager);
		} else if (menuitem == 4) {
			exitSystem();
		}
	}

	private void modifyvendordetails() {
		// TODO Auto-generated method stub

	}

	private void addVendorDetails() throws IOException {
		String vendorName, vendorType, vendorContact = null;
		System.out.println("You have chosen to add new vendor.");
		System.out.println("Please enter the vendor name : ");
		vendorName = cru.readString();
		System.out.println("Please enter the vendor type: ");
		vendorType = cru.readString();
		System.out.println("Please enter the name of contact person: ");
		vendorContact = cru.readString();
		CsvUtility csvUtility = new CsvUtility();
		Vendor vendor = new Vendor(vendorName, vendorType, vendorContact);
		csvUtility.write(FilePathConstants.VENDOR_CSV, vendor);
	}

	private void profileViewMaintainMenu(Object obj) throws IOException {
		System.out.println("\n1. View Profile");
		System.out.println("2. Maintain Profile");
		System.out.println("3. Go back");
		System.out.println("4. Exit");
		int selection = cru.readInt();

		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if (1 == selection) {
				pvc.viewProfile(emp);
				profileViewMaintainMenu(obj);
			} else if (2 == selection) {
			    System.out.println(" ");
			    System.out.println("Sorry, we are working on this part");
			    profileViewMaintainMenu(obj);
			} else if (3 == selection) {
				employeeMainMenu(emp);
			} else if (4 == selection) {
				exitSystem();
			}
		} else if (obj instanceof Manager) {
			Manager manager = (Manager) obj;
			if (1 == selection) {
				pvc.viewProfile(manager);
                profileViewMaintainMenu(obj);
			} else if (2 == selection) {
                System.out.println("");
                System.out.println("Sorry! we are working on this part");
                profileViewMaintainMenu(manager);
			} else if (3 == selection) {
				managerMainMenu(manager);
			} else if (4 == selection) {
				exitSystem();
			}
		} else if (obj instanceof Admin) {
			Admin admin = (Admin) obj;
			if (1 == selection) {
				pvc.viewProfile(admin);
				profileViewMaintainMenu(obj);
			} else if (2 == selection) {
			    System.out.println("");
                System.out.println("Sorry! we are working on this part");
                profileViewMaintainMenu(admin);
			} else if (3 == selection) {
				adminMainMenu(admin);
			} else if (4 == selection) {
				exitSystem();
			}
		}
	}
}