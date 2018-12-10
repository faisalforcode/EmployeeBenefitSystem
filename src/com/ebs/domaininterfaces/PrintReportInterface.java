package com.ebs.domaininterfaces;

import java.util.List;

import com.ebs.domain.Manager;
import com.ebs.domain.User;

public interface PrintReportInterface {

	/**
	 * 
	 * @param users
	 * @param manager
	 * @throws Exception
	 */
	void printReport(List<User> users, Manager manager) throws Exception;

}