package com.ebs.controllers;

import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.ebs.constants.FilePathConstants;
import com.ebs.constants.VendorEnum;
import com.ebs.domain.Employee;
import com.ebs.domaininterfaces.ConsoleReaderInterface;
import com.ebs.domaininterfaces.MakeElectionInterface;
import com.ebs.loggingServices.JavaLogging;
import com.ebs.techservices.CsvUtility;
import com.ebs.techservicesinterfaces.CsvUtilitiesInterface;
import com.ebs.techservicesinterfaces.LoggingHandler;

public class MakeElectionsController implements MakeElectionInterface {
	
	LoggingHandler loggerJava = new JavaLogging();
	/* (non-Javadoc)
	 * @see com.ebs.controllers.MakeElectionInterface#makeElection(com.ebs.domain.Employee)
	 */
	@Override
	public void makeElection(Employee emp) throws Exception {
		
		ConsoleReaderInterface cru = new ConsoleReaderUtility();
		CsvUtilitiesInterface csvUtility = new CsvUtility();
		if ((null == emp.getVendorName() || null == emp.getPolicyType()) && ("".equals(emp.getVendorName()))
				|| "".equals(emp.getPolicyType())) {
			List<CSVRecord> records = csvUtility.read(FilePathConstants.VENDOR_CSV);

			System.out.println("\nPlease select from below options");
			for (CSVRecord csvRecord : records) {
				System.out.println(csvRecord.getRecordNumber() + ". " + csvRecord.get(VendorEnum.vname) + "\t"
						+ csvRecord.get(VendorEnum.vtype));
			}
			System.out.println("\nEnter your Choice: ");

			int selection = cru.readInt();

			CSVRecord recordSelected = records.get(selection - 1);

			System.out.println("You have selected.." + recordSelected.get(VendorEnum.vname) + " Vendor and "
					+ recordSelected.get(VendorEnum.vtype) + " Type of insurance");
			loggerJava.printLog("You have selected.." + recordSelected.get(VendorEnum.vname) + " Vendor and "
					+ recordSelected.get(VendorEnum.vtype) + " Type of insurance", MakeElectionsController.class.getName());
			csvUtility.updateCsvFile(emp, recordSelected);
			loggerJava.printLog("Make Election Information is updated in the Database", MakeElectionsController.class.getName());

		} else {
			System.out.println("\nYou are already enrolled\n");
		}
	}
}
