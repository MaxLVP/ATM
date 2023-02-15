package com.solvd.atm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    private static MyLogger instance = null;
    protected final static Logger LOGGER = LogManager.getLogger(MyLogger.class);

    private MyLogger() {
        super();
    }

    public static MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
        }
        return instance;
    }

    public void info(String msg) {
        LOGGER.info(msg);
    }

    public void info(Object obj) {
        LOGGER.info(obj);
    }

    public void warn(String msg) {
        LOGGER.warn(msg);
    }

    public void error(String msg) {LOGGER.error(msg);}

}
