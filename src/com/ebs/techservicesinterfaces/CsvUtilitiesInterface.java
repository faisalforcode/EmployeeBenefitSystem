package com.ebs.techservicesinterfaces;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVRecord;

import com.ebs.domain.Employee;

public interface CsvUtilitiesInterface {

	List<CSVRecord> read(String filePath) throws IOException;

	boolean write(String filePath, Object obj) throws IOException;

	boolean writeNotifyVendor(Set<Employee> employees) throws IOException;

	void updateCsvFile(Object obj, CSVRecord recordSelected) throws Exception;

}