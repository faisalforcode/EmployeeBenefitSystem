package com.ebs.db;

import java.util.Scanner;

/**
 * @author faisal
 *
 */
public class ConsoleReaderUtility {

	private Scanner in;

	/**
	 * 
	 * @return
	 */
	public String readLine() {
		in = new Scanner(System.in);

		String readString = in.nextLine();

		return readString;
	}

}
