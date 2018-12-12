package com.ebs.domaininterfaces;

import java.io.IOException;
import java.util.List;

import com.ebs.domain.User;

public interface BiReportingInterface {

	List<User> getEmployeeWithNoEnrollment() throws IOException;

	List<User> getEmployeeInsuranceType() throws IOException;

	List<User> getEmployeeWithVendor();

	
	
}