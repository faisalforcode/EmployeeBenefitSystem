package com.ebs.controllers;

import java.io.IOException;

import com.ebs.db.ConsoleReaderUtility;
import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;

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
				} else if (user instanceof Manager) {
					Manager manager = (Manager) userInstance;
					managerMainMenu(manager);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Employee Main Menu
	 * 
	 * @param userInstance
	 */
	private void employeeMainMenu(Employee emp) {

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
			makeElections();
		} else if (menuItem == 3) {
			checkEnrollmentStatus(emp);
		} else if (menuItem == 4) {
			displayMainMenu();
		} else if (menuItem == 5) {
			exitSystem();
		}
	}

	private void makeElections() {

	}

	private void checkEnrollmentStatus(Employee emp) {
		if ((null == emp.getVendorName() || null == emp.getPolicyType()) && ("".equals(emp)) || "".equals(emp)) {
			System.out.println("\nYou are not enrolled...please select Make Election below to enroll\n");
			employeeMainMenu(emp);
		}
		else {
			System.out.println("\n Congratulations!! You are already enrolled...");
		}
	}

	/**
	 * admin main menu
	 */
	private void adminMainMenu(Admin admin) {

		System.out.println("Please select options from the menu below: ");
		System.out.println("1. View/Maintain Profile.");
		System.out.println("2. Make Elections.");
		System.out.println("3. Check status.");
		System.out.println("4. Create/Modify User.");
		System.out.println("5. Exit.");
		int menuItem = cru.readInt();

		if (menuItem == 1) {
			profileViewMaintainMenu(admin);
		} else if (menuItem == 2) {
			makeElections();
		} else if (menuItem == 3) {
			checkEnrollmentStatus(admin);
		} else if (menuItem == 4) {

		} else if (menuItem == 5) {
			exitSystem();
		}
	}

	/**
	 * manager main menu
	 */
	private void managerMainMenu(Manager manager) {

		System.out.println("Please select options from the menu below: ");
		System.out.println("1. View/Maintain Profile.");
		System.out.println("2. Generate BI Report.");
		System.out.println("3. Manager Vendor.");
		System.out.println("4. Exit.");
		int menuItem = cru.readInt();

		if (menuItem == 1) {
			profileViewMaintainMenu(manager);
		}  else if (menuItem == 2) {

		} else if (menuItem == 3) {

		} else if (menuItem == 4) {
			exitSystem();
		}
	}

	/**
	 * Choose the vendor
	 */
	private void chooseVendor() {

		System.out.println("Please select options from the menu below: ");
		System.out.println("1. Kaiser - Healthcare.");
		System.out.println("2. BlueCross - Healthcare.");
		System.out.println("3. Metlife - Life Insurance.");
		System.out.println("4. DDs - Dental.");
		System.out.println("5. Go Back.");
		System.out.println("6. Exit.");
		int selection = cru.readInt();
	}

	/**
	 * vendor main menu
	 */
	private void vendorMainMenu() {

		System.out.println("Please select options from the menu below: ");
		System.out.println("1. Add Vendor");
		System.out.println("2. Modify Vendor.");
		System.out.println("3. Go Back.");
		System.out.println("4. Exit.");
		int selection = cru.readInt();
	}

	private void profileViewMaintainMenu(Employee emp) {
		System.out.println("\n1. View Profile");
		System.out.println("2. Maintain Profile");
		System.out.println("3. Go back");
		System.out.println("4. Exit");
		int selection = cru.readInt();
		if (1 == selection) {
			pvc.viewProfile(emp);
		} else if (2 == selection) {

		} else if (3 == selection) {
			employeeMainMenu(emp);
		} else if (4 == selection) {
			exitSystem();
		}
	}
}