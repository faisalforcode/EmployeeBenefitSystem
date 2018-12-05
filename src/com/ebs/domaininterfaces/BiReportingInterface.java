package com.ebs.domaininterfaces;

import java.io.IOException;
import java.util.List;

import com.ebs.domain.User;

public interface BiReportingInterface {

	List<User> generateReportforEmployeeWithNoEnrollment() throws IOException;

	List<User> generateReportForEmployeeInsuranceType() throws IOException;

	void generateReportforEmployeeWithVendor();

}