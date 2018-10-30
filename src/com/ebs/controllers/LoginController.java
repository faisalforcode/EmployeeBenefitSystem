package com.ebs.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.AdminEnum;
import com.ebs.constants.EmployeeEnum;
import com.ebs.constants.FilePathConstants;
import com.ebs.constants.ManagerEnum;
import com.ebs.db.CsvUtility;
import com.ebs.domain.Employee;
import com.ebs.domain.User;

/**
 * @author faisal
 *
 */
public class LoginController {

	public boolean login(String username, String pwd) throws IOException {

		AtomicBoolean authenticated = new AtomicBoolean(false);
		List<CSVRecord> userRecordsEmployee;
		List<CSVRecord> userRecordsAdmin;
		List<CSVRecord> userRecordsManager;
		
		CsvUtility csvUtility = new CsvUtility();
		userRecordsEmployee=csvUtility.read(FilePathConstants.EMPLOYEE_CSV);
		userRecordsAdmin=csvUtility.read(FilePathConstants.ADMIN_CSV);
		userRecordsManager=csvUtility.read(FilePathConstants.MANAGER_CSV);
		
		userRecordsEmployee.forEach(record-> {
			if(username.contentEquals(record.get(EmployeeEnum.username))&& pwd.contentEquals(record.get(EmployeeEnum.password))){
                authenticated.set(true);
                mapToUserObject(record);
            }
		});
		
		userRecordsAdmin.forEach(record-> {
			if(username.contentEquals(record.get(AdminEnum.username))&& pwd.contentEquals(record.get(AdminEnum.password))){
                authenticated.set(true);
                mapToUserObject(record);
            }
		});
		
		userRecordsManager.forEach(record-> {
			if(username.contentEquals(record.get(ManagerEnum.username))&& pwd.contentEquals(record.get(ManagerEnum.password))){
                authenticated.set(true);
                mapToUserObject(record);
            }
		});

		return authenticated.get();

	}

    private Employee mapToUserObject(CSVRecord record) {

	    Employee empRecord = new Employee();
	    empRecord.setEmpId(Integer.parseInt(record.get(EmployeeEnum.empId)));
	    empRecord.setName(record.get(EmployeeEnum.name));
	    empRecord.setNoOfDependents(Integer.parseInt(record.get(EmployeeEnum.noOfDependents)));
	    empRecord.setPhone(Double.parseDouble(record.get(EmployeeEnum.phone)));
	    empRecord.setPolicyId(Integer.parseInt(record.get(EmployeeEnum.policyId)));
	    empRecord.setSsn(Integer.parseInt(record.get(EmployeeEnum.ssn)));
	    empRecord.setVendorName(record.get(EmployeeEnum.vendorName));
	    empRecord.setUsername(record.get(EmployeeEnum.username));
	    empRecord.setPassword(record.get(EmployeeEnum.password));
        System.out.println(empRecord.toString());
        return empRecord;
    }
}