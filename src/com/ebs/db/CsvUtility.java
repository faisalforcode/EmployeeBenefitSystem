package com.ebs.db;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.UsersEnum;
import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.Vendor;

public class CsvUtility {
	// String[] HEADERS = { "name", "empId", "vendorName", "ssn", "policyId",
	// "phone", "noOfDependents", "username","password" };

	public List<CSVRecord> read(String filePath) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(filePath));
		File file = new File(filePath);
		if (!file.isFile()) {
			System.out.println("Error: File Does not exist " + file);
		}
		CSVParser csvParser = new CSVParser(reader,
				CSVFormat.DEFAULT.withHeader(UsersEnum.class).withFirstRecordAsHeader());
		List<CSVRecord> csvRecords = csvParser.getRecords();
		csvParser.close();

		return csvRecords;
	}

	public boolean write(String filePath, Object obj) throws IOException {
		final String NEW_LINE_SEPARATOR = "\n";
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		if (obj instanceof Employee) {
			FileWriter fileWriter = new FileWriter(FilePathConstants.USERS_CSV, true);
			CSVPrinter csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			Employee employee = (Employee) obj;
			List<String> employeeDataRecord = new ArrayList<String>();
			employeeDataRecord.add(employee.getName());
			employeeDataRecord.add(String.valueOf(employee.getEmpId()));
			employeeDataRecord.add(null);
			employeeDataRecord.add(String.valueOf(employee.getSsn()));
			employeeDataRecord.add(employee.getPolicyType());
			employeeDataRecord.add(employee.getPhone());
			employeeDataRecord.add(String.valueOf(0));
			employeeDataRecord.add(employee.getUsername());
			employeeDataRecord.add(employee.getPassword());
			employeeDataRecord.add(employee.getType());

			csvFilePrinter.printRecord(employeeDataRecord);

			System.out.println("\nNew user updated...");
			fileWriter.flush();
			fileWriter.close();
			csvFilePrinter.close();
		} else if (obj instanceof Manager) {
			Manager employee = (Manager) obj;
		} else if (obj instanceof Admin) {

		} else if (obj instanceof Vendor) {

			FileWriter fileWriterVendor = new FileWriter(FilePathConstants.VENDOR_CSV, true);
			CSVPrinter csvFilePrinterVendor = new CSVPrinter(fileWriterVendor, csvFileFormat);
			Vendor vendor = (Vendor) obj;
			System.out.println(vendor.getName());
			List<String> vendorDataRecord = new ArrayList<String>();
			vendorDataRecord.add(vendor.getName());
			vendorDataRecord.add(vendor.getType());
			vendorDataRecord.add(vendor.getContact());
			csvFilePrinterVendor.printRecord(vendorDataRecord);
			System.out.println("\nVendor Updated");
			fileWriterVendor.flush();
			fileWriterVendor.close();
			csvFilePrinterVendor.close();
		}

		return false;
	}
}
