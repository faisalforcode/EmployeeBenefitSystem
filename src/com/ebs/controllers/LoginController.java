package com.ebs.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.UsersEnum;
import com.ebs.db.CsvUtility;
import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;

/**
 * @author faisal
 *
 */
public class LoginController {

	public User login(String username, String pwd) throws IOException {

		User user = null;
		List<CSVRecord> userRecordsEmployee;

		CsvUtility csvUtility = new CsvUtility();
		userRecordsEmployee = csvUtility.read(FilePathConstants.USERS_CSV);

		for (CSVRecord csvRecord : userRecordsEmployee) {
			if (username.contentEquals(csvRecord.get(UsersEnum.username))
					&& pwd.contentEquals(csvRecord.get(UsersEnum.password))) {
				user = getUserInstance(csvRecord);
				break;
			}
		}
		return user;
	}

	public User getUserInstance(CSVRecord record) {
		String type = record.get(UsersEnum.type);
		User user = null;
		if (type.equals("E")) {
			user = new Employee(record.get(UsersEnum.name), Integer.parseInt(record.get(UsersEnum.empId)),
					record.get(UsersEnum.phone), record.get(UsersEnum.username), record.get(UsersEnum.password),
					record.get(UsersEnum.type), Integer.parseInt(record.get(UsersEnum.noOfDependents)),
					record.get(UsersEnum.policytype), Integer.parseInt(record.get(UsersEnum.ssn)),
					record.get(UsersEnum.vendorName));
		} else if (type.equals("M")) {
			user = new Manager(record.get(UsersEnum.name), Integer.parseInt(record.get(UsersEnum.empId)),
					record.get(UsersEnum.phone), record.get(UsersEnum.username), record.get(UsersEnum.password),
					record.get(UsersEnum.type), Integer.parseInt(record.get(UsersEnum.ssn)));
		} else if (type.equals("A")) {
			user = new Admin(record.get(UsersEnum.name), Integer.parseInt(record.get(UsersEnum.empId)),
					record.get(UsersEnum.phone), record.get(UsersEnum.username), record.get(UsersEnum.password),
					record.get(UsersEnum.type), Integer.parseInt(record.get(UsersEnum.ssn)));
		}
		return user;
	}
}