package com.ebs.loggingServices;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebs.techservicesinterfaces.LoggingHandler;

public class ApacheLogging implements LoggingHandler {

	@Override
	public void printLog(String logMsg, String className) throws IOException {
		Log log = LogFactory.getLog(className);
		log.info(logMsg);
	}

}
