package com.ebs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.UsersEnum;
import com.ebs.db.CsvUtility;
import com.ebs.domain.Employee;
import com.ebs.domain.User;

public class BiReportingController {

	public List<User> generateReportforEmployeeWithNoEnrollment() throws IOException {
		List<CSVRecord> userRecordsEmployee;

		CsvUtility csvUtility = new CsvUtility();
		userRecordsEmployee = csvUtility.read(FilePathConstants.USERS_CSV);
		List<User> userWithNoInsurance = new ArrayList<User>();

		for (CSVRecord csvRecord : userRecordsEmployee) {
			if ("".contentEquals(csvRecord.get(UsersEnum.policytype))
					|| "".contentEquals(csvRecord.get(UsersEnum.vendorName))) {
				User user = new User(csvRecord.get(UsersEnum.name), Integer.parseInt(csvRecord.get(UsersEnum.empId)),
						"", "", "", "", Integer.parseInt(csvRecord.get(UsersEnum.ssn)));
				userWithNoInsurance.add(user);
			}
		}
		return userWithNoInsurance;

	}

	public List<User> generateReportForEmployeeInsuranceType() throws IOException {
		List<CSVRecord> userRecordsEmployee;

		CsvUtility csvUtility = new CsvUtility();
		userRecordsEmployee = csvUtility.read(FilePathConstants.USERS_CSV);
		List<User> userWithInsuranceType = new ArrayList<User>();

		for (CSVRecord csvRecord : userRecordsEmployee) {
			if (!"".contentEquals(csvRecord.get(UsersEnum.policytype))
					&& !"".contentEquals(csvRecord.get(UsersEnum.vendorName))) {
				User user = new Employee(csvRecord.get(UsersEnum.name), Integer.parseInt(csvRecord.get(UsersEnum.empId)),
						"", "", "", "", 0, csvRecord.get(UsersEnum.policytype), Integer.parseInt(csvRecord.get(UsersEnum.ssn)), csvRecord.get(UsersEnum.vendorName));
				userWithInsuranceType.add(user);
			}
		}
		return userWithInsuranceType;

	}

	public void generateReportforEmployeeWithVendor() {
		// TODO Auto-generated method stub
		
	}
}
