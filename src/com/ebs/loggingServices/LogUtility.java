package com.ebs.loggingServices;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtility{
	/*public static void main(String[] args) throws IOException {
		LoggingHandler logInterface = new JavaLogging();
		//logInterface.printLog("Log Test",);
	}*/

	public static Logger getlogger(String loggername) throws IOException {
		Logger logger = Logger.getLogger(loggername);
		FileHandler handler = new FileHandler("logger.log", 2000, 5);
		handler.setFormatter(new MyFormatter());

		if (logger.getLevel() != Level.CONFIG) {
			logger.addHandler(handler);
		}
		return logger;
	}

}
