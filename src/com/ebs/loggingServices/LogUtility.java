package com.ebs.loggingServices;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ebs.constants.FilePathConstants;

public class LogUtility{

	public static Logger getlogger(String loggername) throws IOException {
		final Logger LOGGER = Logger.getLogger(loggername);
		FileHandler handler = new FileHandler(FilePathConstants.LOGGER_DIR, 2000, 5);
		handler.setFormatter(new MyFormatter());

		if (LOGGER.getLevel() != Level.CONFIG) {
			LOGGER.addHandler(handler);
		}
		return LOGGER;
	}

}
