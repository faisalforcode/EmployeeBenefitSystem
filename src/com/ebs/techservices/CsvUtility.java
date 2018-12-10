package com.ebs.techservices;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.UsersEnum;
import com.ebs.constants.VendorEnum;
import com.ebs.domain.Admin;
import com.ebs.domain.Employee;
import com.ebs.domain.Manager;
import com.ebs.domain.User;
import com.ebs.domain.Vendor;
import com.ebs.techservicesinterfaces.CsvUtilitiesInterface;

public class CsvUtility implements CsvUtilitiesInterface {

	/* (non-Javadoc)
	 * @see com.ebs.techservices.CsvUtilitiesInterface#read(java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.ebs.techservices.CsvUtilitiesInterface#write(java.lang.String, java.lang.Object)
	 */
	@Override
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
			// Manager employee = (Manager) obj;
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

	/* (non-Javadoc)
	 * @see com.ebs.techservices.CsvUtilitiesInterface#writeNotifyVendor(java.util.Set)
	 */
	@Override
	public boolean writeNotifyVendor(Set<Employee> employees) throws IOException {
		boolean success = false;
		final String NEW_LINE_SEPARATOR = "\n";
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		FileWriter fileWriterVendor = new FileWriter(FilePathConstants.NOTIFY_VENDOR_CSV, true);
		CSVPrinter csvFilePrinterVendor = new CSVPrinter(fileWriterVendor, csvFileFormat);

		for (Employee employee : employees) {
			List<String> employeeToPrint = new ArrayList<String>();
			employeeToPrint.add(employee.getName());
			employeeToPrint.add(employee.getPolicyType());
			employeeToPrint.add(employee.getVendorName());
			csvFilePrinterVendor.printRecord(employeeToPrint);
		}
		fileWriterVendor.flush();
		fileWriterVendor.close();
		csvFilePrinterVendor.close();
		success = true;
		return success;

	}

	/* (non-Javadoc)
	 * @see com.ebs.techservices.CsvUtilitiesInterface#updateCsvFile(java.lang.Object, org.apache.commons.csv.CSVRecord)
	 */
	@Override
	public void updateCsvFile(Object obj, CSVRecord recordSelected) throws Exception {
		String filePath = null;

		if (obj instanceof Vendor) {

			filePath = FilePathConstants.VENDOR_CSV;
		} else if (obj instanceof User) {
			filePath = FilePathConstants.USERS_CSV;
		}

		CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT);
		List<CSVRecord> list = parser.getRecords();
		File f = new File(filePath);
		String edited = f.getAbsolutePath();

		f.delete();
		Employee user = (Employee) obj;
		CSVPrinter printer = new CSVPrinter(new FileWriter(edited), CSVFormat.DEFAULT.withRecordSeparator("\n"));

		for (CSVRecord record : list) {
			String[] recordArray = toArray(record);
			if (record.get(0).equalsIgnoreCase(user.getName())) {
				recordArray[2] = recordSelected.get(VendorEnum.vname);
				recordArray[4] = recordSelected.get(VendorEnum.vtype);
			}
			print(printer, recordArray);
		}
		parser.close();
		printer.close();

		System.out.println("CSV file was updated successfully !!!");
	}

	public static String[] toArray(CSVRecord rec) {
		String[] arr = new String[rec.size()];
		int i = 0;
		for (String str : rec) {
			arr[i++] = str;
		}
		return arr;
	}

	public static void print(CSVPrinter printer, String[] s) throws Exception {
		for (String val : s) {
			printer.print(val != null ? String.valueOf(val) : "");
		}
		printer.println();
	}
}
