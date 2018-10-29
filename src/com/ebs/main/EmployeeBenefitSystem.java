package com.ebs.main;

import java.io.IOException;

import com.ebs.controllers.Menus;

public class EmployeeBenefitSystem {
	public static void main(String[] args) throws IOException {
		System.out.println("╔═╗┌┬┐┌─┐┬  ┌─┐┬ ┬┌─┐┌─┐  ╔╗ ┌─┐┌┐┌┌─┐┌─┐┬┌┬┐  ╔═╗┬ ┬┌─┐┌┬┐┌─┐┌┬┐\r\n"
				+ "║╣ │││├─┘│  │ │└┬┘├┤ ├┤   ╠╩╗├┤ │││├┤ ├┤ │ │   ╚═╗└┬┘└─┐ │ ├┤ │││\r\n"
				+ "╚═╝┴ ┴┴  ┴─┘└─┘ ┴ └─┘└─┘  ╚═╝└─┘┘└┘└─┘└  ┴ ┴   ╚═╝ ┴ └─┘ ┴ └─┘┴ ┴\r\n" + "");
		startProgram();
	}

	private static void startProgram() {
		Menus menu = new Menus();
		menu.displayMainMenu();
	}
}
