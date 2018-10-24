package com.ebs.db;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.ebs.domain.Employee;

public class CsvUtility {

	public Employee read(String filePath) throws IOException {

		System.out.println("In there");
		Reader reader = Files.newBufferedReader(Paths.get(filePath));
		File file = new File(filePath);
		if(file.isDirectory());
		{
			System.out.println("True");
		}
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			System.out.println(csvRecord + "There" + reader.ready());
			// Accessing Values by Column Index
			String name = csvRecord.get(0);
			String email = csvRecord.get(1);
			String phone = csvRecord.get(2);
			String country = csvRecord.get(3);

			System.out.println("Record No - " + csvRecord.getRecordNumber());
			System.out.println("---------------");
			System.out.println("Name : " + name);
			System.out.println("Email : " + email);
			System.out.println("Phone : " + phone);
			System.out.println("Country : " + country);
			System.out.println("---------------\n\n");
		}
		csvParser.close();

		return null;
	}
}
