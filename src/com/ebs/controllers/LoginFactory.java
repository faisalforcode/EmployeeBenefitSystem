/**
 * 
 */
package com.ebs.controllers;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.UsersEnum;
import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;

/**
 * @author faisal
 *
 */
public class LoginFactory {
	public User getUser(CSVRecord record) {
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
