package com.solvd.atm.dao.utils;

import com.solvd.atm.utils.MyLogger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Properties props = new Properties();

    static {
        try {
            props.load(new FileReader("mysql.properties"));
        } catch (FileNotFoundException e) {
            LOGGER.error("File was not found");
        } catch (IOException e) {
            LOGGER.error("Exception while loading properties file");
        }
    }

    private DBConfig() {

    }

    public static Properties getProps() {
        return props;
    }
}
