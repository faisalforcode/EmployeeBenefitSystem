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
			User userInstance = loginController.login(username, password);
			if (null != user) {
				System.out.println("You have logged in successfully " + userInstance.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
