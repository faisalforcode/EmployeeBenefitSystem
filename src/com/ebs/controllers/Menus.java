package com.ebs.controllers;

import com.ebs.db.ConsoleReaderUtility;

public class Menus {

	public void displayMainMenu() {
		System.out.println("\nSelect from the options below:");
		System.out.println("1. Login ");
		System.out.println("2. Exit..");
		System.out.println("Enter your choice (1|2): ");
		ConsoleReaderUtility cru = new ConsoleReaderUtility();
		int choice = cru.readInt();
		if (choice == 1) {
			System.out.println("You have chosen.. 1. Login");
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

	public void displayAdminMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void displayEmployeeMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void displayVendorMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void displayManagerMenu() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
}
