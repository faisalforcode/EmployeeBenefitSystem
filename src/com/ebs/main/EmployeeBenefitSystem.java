package com.ebs.main;

import java.io.IOException;

import com.ebs.constants.FilePathConstants;
import com.ebs.controllers.Menus;
import com.ebs.db.CsvUtility;

public class EmployeeBenefitSystem {

	public static void main(String[] args) throws IOException {
		System.out.println(
		          "╔═╗┌┬┐┌─┐┬  ┌─┐┬ ┬┌─┐┌─┐  ╔╗ ┌─┐┌┐┌┌─┐┌─┐┬┌┬┐  ╔═╗┬ ┬┌─┐┌┬┐┌─┐┌┬┐\r\n"
				+ "║╣ │││├─┘│  │ │└┬┘├┤ ├┤   ╠╩╗├┤ │││├┤ ├┤ │ │   ╚═╗└┬┘└─┐ │ ├┤ │││\r\n"
				+ "╚═╝┴ ┴┴  ┴─┘└─┘ ┴ └─┘└─┘  ╚═╝└─┘┘└┘└─┘└  ┴ ┴   ╚═╝ ┴ └─┘ ┴ └─┘┴ ┴\r\n" + "");
		startMenu();
		readCsv();
	}

	/**
	 * cd d
	 */
	private static void startMenu() {
		Menus menu = new Menus();
		menu.displayMainMenu();
	}

	private static void readCsv() throws IOException {
		CsvUtility csvUtility = new CsvUtility();
		csvUtility.read(FilePathConstants.EMPLOYEE_CSV);
	}

}
