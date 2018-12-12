package com.ebs.domaininterfaces;

import java.util.List;

import com.ebs.domain.Manager;
import com.ebs.domain.User;

public interface PrintReportInterface {

	/**
	 * Print report of Users having multiple Implementations
	 * 
	 * @param users
	 * @param manager
	 * @throws Exception
	 */
	void printReport(List<User> users, Manager manager) throws Exception;

}