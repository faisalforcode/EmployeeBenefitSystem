package com.ebs.loggingServices;

import com.ebs.techservicesinterfaces.loggingHandler;

import java.io.IOException;
import java.util.logging.Level;

class logtest implements loggingHandler {

    void createLog() throws IOException {
        logUtility.getlogger(logtest.class.getName()).log(Level.INFO," I'm in a logtest file.");
    }
}
