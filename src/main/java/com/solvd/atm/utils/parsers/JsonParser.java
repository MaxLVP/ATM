package com.solvd.atm.utils.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.atm.models.Check;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public  class JsonParser {
    protected final static Logger LOGGER = LogManager.getLogger(JsonParser.class);
    //сюда путь к файлу, принмиаем мы лист


    public static void writeToJSON(Check check) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/resources/checks/cheks.json"), check);
            String jsonString = mapper.writeValueAsString(check);
            LOGGER.info(jsonString);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}



