package com.ebs.domaininterfaces;

import java.util.List;

import com.ebs.domain.Employee;
import com.ebs.domain.Manager;

public interface NotifyVendorInterface {

	void notifyVendor(Manager manager) throws Exception;

	void notifyUsersToVendor(List<Employee> employees) throws Exception;

}