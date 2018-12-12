package com.ebs.domaininterfaces;

import java.io.IOException;
import java.util.List;

import com.ebs.domain.Employee;
import com.ebs.domain.Manager;

public interface ManageVendorInterface {

	void notifyVendor(Manager manager) throws Exception;

	void notifyUsersToVendor(List<Employee> employees) throws Exception;
	
	void addVendorDetails() throws IOException;
}