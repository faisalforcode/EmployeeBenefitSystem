package com.ebs.domaininterfaces;

import com.ebs.domain.Admin;
import com.ebs.domain.Manager;

public interface MenusInterface {

	/* (non-Javadoc)
	 * @see com.ebs.controllers.MenusInterface#displayMainMenu()
	 */
	void displayMainMenu() throws Exception;

	/* (non-Javadoc)
	 * @see com.ebs.controllers.MenusInterface#displayMenu()
	 */
	void displayMenu() throws Exception;

	/**
	 * admin main menu
	 * 
	 * @throws Exception
	 */
	void adminMainMenu(Admin admin) throws Exception;

	/* (non-Javadoc)
	 * @see com.ebs.controllers.MenusInterface#managerMainMenu(com.ebs.domain.Manager)
	 */
	void managerMainMenu(Manager manager) throws Exception;

	/**
	 * vendor main menu
	 * 
	 * @param manager
	 * @throws Exception
	 */
	void vendorMainMenu(Manager manager) throws Exception;
	
	/**
	 * Generate BI Reports
	 * @param manager
	 * @throws Exception
	 */
	void generateBiReports(Manager manager) throws Exception; 
	
}