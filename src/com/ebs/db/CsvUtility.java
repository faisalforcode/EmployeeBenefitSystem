package com.ebs.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.UsersEnum;
import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;

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
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
		
		if (obj instanceof Employee) {
			Employee employee = (Employee) obj;
			csvPrinter.print(100);
			
		} else if (obj instanceof Manager) {
				//TODO:
		} else if (obj instanceof Admin) {

		}

		csvPrinter.close();
		return false;
	}
}
