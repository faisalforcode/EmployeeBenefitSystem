package com.ebs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.UsersEnum;
import com.ebs.domain.Employee;
import com.ebs.domain.User;
import com.ebs.domaininterfaces.BiReportingInterface;
import com.ebs.domaininterfaces.ConsoleReaderInterface;
import com.ebs.domaininterfaces.MenusInterface;
import com.ebs.techservices.CsvUtility;
import com.ebs.techservicesinterfaces.CsvUtilitiesInterface;

public class BiReportingController implements BiReportingInterface {

	ConsoleReaderInterface cru = new ConsoleReaderUtility();
	MenusInterface menuController = new Menus();

	/* (non-Javadoc)
	 * @see com.ebs.controllers.BiReportingInterface#generateReportforEmployeeWithNoEnrollment()
	 */
	@Override
	public List<User> getEmployeeWithNoEnrollment() throws IOException {
		List<CSVRecord> userRecordsEmployee;

		CsvUtilitiesInterface csvUtility = new CsvUtility();
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

	/* (non-Javadoc)
	 * @see com.ebs.controllers.BiReportingInterface#generateReportForEmployeeInsuranceType()
	 */
	@Override
	public List<User> getEmployeeInsuranceType() throws IOException {
		List<CSVRecord> userRecordsEmployee;

		CsvUtilitiesInterface csvUtility = new CsvUtility();
		userRecordsEmployee = csvUtility.read(FilePathConstants.USERS_CSV);
		List<User> userWithInsuranceType = new ArrayList<User>();

		for (CSVRecord csvRecord : userRecordsEmployee) {
			if (!"".contentEquals(csvRecord.get(UsersEnum.policytype))
					&& !"".contentEquals(csvRecord.get(UsersEnum.vendorName))) {
				User user = new Employee(csvRecord.get(UsersEnum.name),
						Integer.parseInt(csvRecord.get(UsersEnum.empId)), "", "", "", "", 0,
						csvRecord.get(UsersEnum.policytype), Integer.parseInt(csvRecord.get(UsersEnum.ssn)),
						csvRecord.get(UsersEnum.vendorName));
				userWithInsuranceType.add(user);
			}
		}
		return userWithInsuranceType;

	}

	/* (non-Javadoc)
	 * @see com.ebs.controllers.BiReportingInterface#generateReportforEmployeeWithVendor()
	 */
	@Override
	public List<User> getEmployeeWithVendor() {
		// TODO Auto-generated method stub
		return null;

	}
	
	
}
