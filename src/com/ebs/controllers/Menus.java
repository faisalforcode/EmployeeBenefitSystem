package com.ebs.controllers;

import com.ebs.db.ConsoleReaderUtility;
import com.ebs.domain.*;

import java.io.IOException;

public class Menus {

	User user;
	LoginController loginController;
	private String username;
	private String password;
	private int makechoice;

	{
		loginController = new LoginController();
	}

	public void displayMainMenu() {
		System.out.println("\nSelect from the options below:");
		System.out.println("1. Login ");
		System.out.println("2. Exit..");
		System.out.println("Enter your choice (1|2): ");
		ConsoleReaderUtility cru = new ConsoleReaderUtility();
		int choice = cru.readInt();

		if (choice == 1) {
			displayMenu(cru);
		} else if (choice == 2) {
			exitSystem();
		} else {
			displayMainMenu();
		}
	}

	private void exitSystem() {
		System.out.println("System terminated.... Thank you for using Employee Benefit System");
		System.exit(0);
	}

	public void displayMenu(ConsoleReaderUtility cru) {
		System.out.println("\nYou have chosen to Login.");
		verifyCredentials(cru);
	}

	/**
	 * 
	 * @param cru
	 * @param user
	 */
	private void verifyCredentials(ConsoleReaderUtility cru) {
		System.out.println("Please enter your username: ");
		username = cru.readString();
		System.out.println("Please enter your password: ");
		password = cru.readString();
		try {
			boolean userInstance = loginController.login(username, password);
			if (userInstance) {
				System.out.println("You have logged in successfully ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * employee main menu
	 */
	private void employeemainmenu(ConsoleReaderUtility cru) {

		System.out.println("Please select options from the menu below: ");
		System.out.println("1. View/Maintain Profile.");
		System.out.println("2. Make Elections.");
        System.out.println("3. Check status.");
        System.out.println("4. Exit.");
        makechoice = cru.readInt();
	}

    /**
     * admin main menu
     */
    private void adminmainmenu(ConsoleReaderUtility cru) {

        System.out.println("Please select options from the menu below: ");
        System.out.println("1. View/Maintain Profile.");
        System.out.println("2. Make Elections.");
        System.out.println("3. Check status.");
        System.out.println("4. Create/Modify User.");
        System.out.println("5. Start/Stop System.");
        System.out.println("6. Exit.");
        makechoice = cru.readInt();
    }

    /**
     * manager main menu
     */
    private void managermainmenu(ConsoleReaderUtility cru) {

        System.out.println("Please select options from the menu below: ");
        System.out.println("1. View/Maintain Profile.");
        System.out.println("2. Make Elections.");
        System.out.println("3. Check status.");
        System.out.println("4. Generate BI Report.");
        System.out.println("5. Manager Vendor.");
        System.out.println("6. Exit.");
        makechoice = cru.readInt();
    }

    /**
     *  Choose the vendor
     */
    private void choosevendor(ConsoleReaderUtility cru) {

        System.out.println("Please select options from the menu below: ");
        System.out.println("1. Kaiser - Healthcare.");
        System.out.println("2. BlueCross - Healthcare.");
        System.out.println("3. Metlife - Life Insurance.");
        System.out.println("4. DDs - Dental.");
        System.out.println("5. Go Back.");
        System.out.println("6. Exit.");
        makechoice = cru.readInt();
    }

    /**
     *  vendor main menu
     */
    private void vendormainmenu(ConsoleReaderUtility cru) {

        System.out.println("Please select options from the menu below: ");
        System.out.println("1. Add Vendor");
        System.out.println("2. Modify Vendor.");
        System.out.println("3. Go Back.");
        System.out.println("4. Exit.");
        makechoice = cru.readInt();
    }



}