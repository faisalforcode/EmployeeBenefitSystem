package com.ebs.techservicesinterfaces;

import java.io.IOException;

public interface LoggingHandler {
	
	void printLog(String logMsg, String className) throws IOException;

}
