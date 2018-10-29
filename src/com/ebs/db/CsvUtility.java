package com.ebs.db;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.EmployeeEnum;

public class CsvUtility {
	//String[] HEADERS = { "name", "empId", "vendorName", "ssn", "policyId", "phone", "noOfDependents", "username","password" };

	public List<CSVRecord> read(String filePath) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(filePath));
		File file = new File(filePath);
		if (!file.isFile()) {
			System.out.println("Error: File Does not exist " + file);
		}
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(EmployeeEnum.class).withFirstRecordAsHeader());
		List<CSVRecord> csvRecords = csvParser.getRecords();
		csvParser.close();

		return csvRecords;
	}
}
