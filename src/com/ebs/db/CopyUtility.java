package com.ebs.db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.ebs.constants.FilePathConstants;

@Deprecated
public class CopyUtility {

	public boolean copy() throws Exception {
		InputStream isUsers = getClass().getResourceAsStream("/Users.csv");
		// InputStream isVendor = getClass().getResourceAsStream("/vendor.csv");

		boolean succeess = true;
		String destination = FilePathConstants.USER_DIR;
		System.out.println("Copying DB File to " + destination);

		try {
			Files.copy(isUsers, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
			// Files.copy(isVendor, Paths.get(destination),
			// StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException ex) {
			succeess = false;
			throw new Exception(ex);

		} finally {
			isUsers.close();
		}
		return succeess;
	}
}
