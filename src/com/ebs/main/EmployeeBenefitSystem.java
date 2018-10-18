package com.ebs.main;

import com.ebs.db.DbConfig;

public class EmployeeBenefitSystem {

	public static void main(String[] args) {
		System.out.println("Employee Benefit System:");
		
		DbConfig dbConfig = new DbConfig();
		dbConfig.connect();
	}
}
