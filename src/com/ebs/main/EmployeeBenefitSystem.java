package com.ebs.main;

import java.io.IOException;

import com.ebs.constants.FilePathConstants;
import com.ebs.db.ConsoleReaderUtility;
import com.ebs.db.CsvUtility;

public class EmployeeBenefitSystem {

	public static void main(String[] args) throws IOException {
		System.out.println("Employee Benefit System:");

		/**
		 * Test DB here
		 */
		/*
		 * DbConfig dbConfig = new DbConfig(); dbConfig.connect();
		 */
		login();
		read();

	}

	private static void login() {
		System.out.println("Enter your username: ");
		ConsoleReaderUtility cru = new ConsoleReaderUtility();
		cru.readLine();
	}

	private static void read() throws IOException {
		System.out.println("Hello there");
		CsvUtility csvUtility = new CsvUtility();
		csvUtility.read(FilePathConstants.EMPLOYEE_CSV);
	}
	
	
}
