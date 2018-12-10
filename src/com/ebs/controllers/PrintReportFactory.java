package com.ebs.controllers;

import com.ebs.domaininterfaces.PrintReportInterface;

public class PrintReportFactory {

	/**
	 * Factory for Generating Reports
	 * 
	 * @param reportType
	 * @return
	 */
	PrintReportInterface printReportImpl(String reportType) {
		PrintReportInterface printReportImpl = null;
		if ("InsuranceType".equalsIgnoreCase(reportType)) {
			printReportImpl = new PrintReportForInsuranceType();
		} else if ("NoInsuranceUsers".equalsIgnoreCase(reportType)) {
			printReportImpl = new PrintReportForNoInsuranceUsers();
		} else if ("VendorDistribution".equalsIgnoreCase(reportType)) {
			printReportImpl = new PrintReportForVendorDistribution();
		}
		return printReportImpl;
	}
}
