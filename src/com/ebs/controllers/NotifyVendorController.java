package com.ebs.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.VendorEnum;
import com.ebs.db.ConsoleReaderUtility;
import com.ebs.db.CsvUtility;

public class NotifyVendorController {

	public void notifyVendor() throws IOException {
		int recordNumber = 0;

		System.out.println("\nThese Vendors are available in the system. Whcih one do you want to notify");
		CsvUtility csvUtility = new CsvUtility();

		List<CSVRecord> records = csvUtility.read(FilePathConstants.VENDOR_CSV);

		for (CSVRecord csvRecord : records) {
			recordNumber = (int) csvRecord.getRecordNumber();
			System.out.println(csvRecord.getRecordNumber() + ". " + csvRecord.get(VendorEnum.vname) + "("
					+ csvRecord.get(VendorEnum.vtype) + ")");
		}

		ConsoleReaderUtility csvReaderUtility = new ConsoleReaderUtility();
		int selection = csvReaderUtility.readInt();
		CSVRecord recordSelected = records.get(selection - 1);

		System.out
				.println("You have selected option " + records.get(selection - 1) + recordSelected.get(VendorEnum.vname)
						+ " Vendor and " + recordSelected.get(VendorEnum.vtype) + " Type of insurance");

	}

}
