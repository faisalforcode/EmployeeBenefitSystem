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

		int readInt = in.nextInt();

		return readInt;
	}

	public String readString(){
		in = new Scanner(System.in);
		String readString = in.next();

		return readString;
	}

}
