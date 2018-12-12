package com.ebs.loggingServices;

import com.ebs.techservicesinterfaces.loggingHandler;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class logUtility {
    public static void main(String[] args) throws IOException {
        loggingHandler logInterface = new logtest();
        ((logtest) logInterface).createLog();

    }
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
