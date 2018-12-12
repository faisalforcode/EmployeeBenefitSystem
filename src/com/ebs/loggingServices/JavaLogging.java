package com.ebs.loggingServices;

import com.ebs.techservicesinterfaces.LoggingHandler;

import java.io.IOException;
import java.util.logging.Level;

public class JavaLogging implements LoggingHandler {

    public void printLog(String logMsg, String className) throws IOException {
        LogUtility.getlogger(className).log(Level.INFO,logMsg);
    }
}