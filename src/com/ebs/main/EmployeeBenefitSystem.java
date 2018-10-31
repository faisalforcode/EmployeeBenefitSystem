package com.ebs.main;

import java.io.IOException;

import com.ebs.controllers.Menus;

public class EmployeeBenefitSystem {

	public static void main(String[] args) throws Exception {
		System.out.println("╔═╗┌┬┐┌─┐┬  ┌─┐┬ ┬┌─┐┌─┐  ╔╗ ┌─┐┌┐┌┌─┐┌─┐┬┌┬┐  ╔═╗┬ ┬┌─┐┌┬┐┌─┐┌┬┐\r\n"
				+ "║╣ │││├─┘│  │ │└┬┘├┤ ├┤   ╠╩╗├┤ │││├┤ ├┤ │ │   ╚═╗└┬┘└─┐ │ ├┤ │││\r\n"
				+ "╚═╝┴ ┴┴  ┴─┘└─┘ ┴ └─┘└─┘  ╚═╝└─┘┘└┘└─┘└  ┴ ┴   ╚═╝ ┴ └─┘ ┴ └─┘┴ ┴\r\n" + "");
		startMenu();
	}

	/**
	 * cd d
	 * @throws Exception 
	 */
	private static void startMenu() throws Exception {
		Menus menu = new Menus();
		menu.displayMainMenu();
	}
}
