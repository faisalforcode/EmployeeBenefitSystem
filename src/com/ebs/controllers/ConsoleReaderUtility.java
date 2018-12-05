package com.ebs.controllers;

import java.util.Scanner;

import com.ebs.domaininterfaces.ConsoleReaderInterface;

/**
 * @author faisal
 *
 */
public class ConsoleReaderUtility implements ConsoleReaderInterface {

	private Scanner in;

	/* (non-Javadoc)
	 * @see com.ebs.controllers.ConsoleReaderInterface#readInt()
	 */
	@Override
	public int readInt() {
		in = new Scanner(System.in);

		int readInt = in.nextInt();

		return readInt;
	}

	/* (non-Javadoc)
	 * @see com.ebs.controllers.ConsoleReaderInterface#readString()
	 */
	@Override
	public String readString(){
		in = new Scanner(System.in);
		String readString = in.next();

		return readString;
	}

}
