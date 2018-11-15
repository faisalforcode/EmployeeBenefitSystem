package com.ebs.controllers;

import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.VendorEnum;
import com.ebs.db.ConsoleReaderUtility;
import com.ebs.db.CsvUtility;
import com.ebs.domain.Employee;

public class MakeElectionsController {

	public void makeElection(Employee emp) throws Exception {
		ConsoleReaderUtility cru = new ConsoleReaderUtility();
		CsvUtility csvUtility = new CsvUtility();
		if ((null == emp.getVendorName() || null == emp.getPolicyType()) && ("".equals(emp.getVendorName()))
				|| "".equals(emp.getPolicyType())) {
			List<CSVRecord> records = csvUtility.read(FilePathConstants.VENDOR_CSV);

			System.out.println("\nPlease select from below options");
			for (CSVRecord csvRecord : records) {
				System.out.println(csvRecord.getRecordNumber() + ". " + csvRecord.get(VendorEnum.vname) + "\t"
						+ csvRecord.get(VendorEnum.vtype));
			}
			System.out.println("\n Enter your Choice: ");

			int selection = cru.readInt();

			CSVRecord recordSelected = records.get(selection - 1);

			System.out.println("You have selected.." + recordSelected.get(VendorEnum.vname) + " Vendor and "
					+ recordSelected.get(VendorEnum.vtype) + " Type of insurance");

			csvUtility.updateCsvFile(emp, recordSelected);

		} else {
			System.out.println("\nYou are already enrolled\n");
		}
	}
}
