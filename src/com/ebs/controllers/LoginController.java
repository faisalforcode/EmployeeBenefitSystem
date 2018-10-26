/**
 * 
 */
package com.ebs.controllers;

import java.io.IOException;

import com.ebs.constants.FilePathConstants;
import com.ebs.db.CsvUtility;

/**
 * @author faisal
 *
 */
public class LoginController {

	public boolean login() throws IOException {

		boolean authenticated = false;
		CsvUtility csvUtility = new CsvUtility();
		csvUtility.read(FilePathConstants.EMPLOYEE_CSV);
		return authenticated;

	}
}
