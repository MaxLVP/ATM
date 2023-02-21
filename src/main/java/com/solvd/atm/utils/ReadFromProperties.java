package com.solvd.atm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {
    private static final MyLogger LOGGER = MyLogger.getInstance();

    public static String getProperty(String filename, String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filename));
            return properties.getProperty(key);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
            return null;
        }
    }
}
