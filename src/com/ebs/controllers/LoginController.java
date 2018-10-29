/**
 * 
 */
package com.ebs.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.ebs.constants.EmployeeEnum;
import com.ebs.constants.FilePathConstants;
import com.ebs.db.CsvUtility;
import com.ebs.domain.Employee;
import com.ebs.domain.User;
import org.apache.commons.csv.CSVRecord;

/**
 * @author faisal
 *
 */
public class LoginController {

	Employee emp = null;
	public User login(String username, String pwd) throws IOException {
		AtomicBoolean authenticated = new AtomicBoolean(false);
		List<CSVRecord> userRecords;
		CsvUtility csvUtility = new CsvUtility();
		userRecords=csvUtility.read(FilePathConstants.EMPLOYEE_CSV);

		userRecords.forEach(record-> {
			if(username.contentEquals(record.get(EmployeeEnum.username))&& pwd.contentEquals(record.get(EmployeeEnum.password))){
                authenticated.set(true);
                emp = mapToUserObject(record);
            }
		});

		return emp;

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

