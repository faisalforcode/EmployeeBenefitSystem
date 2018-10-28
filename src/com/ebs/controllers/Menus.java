package com.ebs.controllers;

import com.ebs.db.ConsoleReaderUtility;
import com.ebs.domain.*;

import java.io.IOException;

public class Menus {

    User user;
    LoginController loginController;
    private String username;
    private String password;

    {
        loginController=new LoginController();
    }

	public void displayMainMenu() {
		System.out.println("\nSelect from the options below:");
		System.out.println("1. Login ");
		System.out.println("2. Exit..");
		System.out.println("Enter your choice (1|2): ");
		ConsoleReaderUtility cru = new ConsoleReaderUtility();
		int choice = cru.readInt();
		if (choice == 1) {
			System.out.println("You have chosen.. 1. Login");
			System.out.println("Choose the profile to login from below options:");
			System.out.println("1. Admin ");
			System.out.println("2. Manager ");
			System.out.println("3. Employee ");
			System.out.println("4. Vendor");
			System.out.println("Enter your choice (1|2|3|4): ");
			int input = cru.readInt();
			switch (input){
                case 1:
                    displayAdminMenu(cru);
                    break;
                case 2:
                    displayManagerMenu(cru);
                    break;
                case 3:
                    displayEmployeeMenu(cru);
                    break;
                case 4:
                    displayVendorMenu(cru);
                    break;
                default:
                    System.out.println("No valid option entered");
                    exitSystem();
                    break;
            }
			//call login controller , check inputs and further action
		}
		if (choice == 2)
		{
			exitSystem();
		}
	}

	/**
	 * 
	 */
	private void exitSystem() {
		System.out.println("System terminated.... Thank you for using Employee Benefit System");
		System.exit(0);
	}

	public void displayAdminMenu(ConsoleReaderUtility cru) {
	    user = new Admin();
		System.out.println("You have chosen.. 1. Admin");
        verifyCredentials(cru,user);
		System.out.println("");
		System.out.println("");
	}

    public void displayManagerMenu(ConsoleReaderUtility cru) {
	    user=new Manager();
        System.out.println("You have chosen.. 2. Manager");
        verifyCredentials(cru, user);
        System.out.println("");
        System.out.println("");
    }

	public void displayEmployeeMenu(ConsoleReaderUtility cru) {
	    user = new Employee();
		System.out.println("You have chosen.. 3. Employee");
        verifyCredentials(cru, user);
		System.out.println("");
		System.out.println("");
	}

	public void displayVendorMenu(ConsoleReaderUtility cru) {
	    user = new Vendor();
		System.out.println("You have chosen.. 4. Vendor");
		verifyCredentials(cru, user);
		System.out.println("");
		System.out.println("");
	}

    private void verifyCredentials(ConsoleReaderUtility cru, User user){
        System.out.println("Please enter your username: ");
        username=cru.readString();
        System.out.println("Please enter your password: ");
        password=cru.readString();
        try {
            loginController.login(username,password,user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
