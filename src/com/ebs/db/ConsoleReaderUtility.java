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
	public int readInt() {
		in = new Scanner(System.in);

		int readString = in.nextInt();

		return readString;
	}

}
