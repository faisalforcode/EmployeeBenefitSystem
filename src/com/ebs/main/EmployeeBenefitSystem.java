package com.ebs.main;

import com.ebs.controllers.Menus;

public class EmployeeBenefitSystem {

	public static void main(String[] args) throws Exception {
		System.out.println("*************************************************");
		System.out.println("Employee Benefit System");
		System.out.println("*************************************************");
		startMenu();
	}

	/**
	 * cd d
	 * 
	 * @throws Exception
	 */
	private static void startMenu() throws Exception {
		/*
		 * CopyUtility cp = new CopyUtility(); cp.copy();
		 */
		Menus menu = new Menus();
		menu.displayMainMenu();
	}

}
