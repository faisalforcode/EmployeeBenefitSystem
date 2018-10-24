package com.ebs.main;

import java.io.IOException;

import com.ebs.constants.Constants;
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

		read();

	}

	private static void read() throws IOException {
		System.out.println("Hello there");
		CsvUtility csvUtility = new CsvUtility();
		csvUtility.read(Constants.EMPLOYEE_CSV);
	}
}
