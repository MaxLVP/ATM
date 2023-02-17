package com.solvd.atm.utils.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.atm.models.ChecksList;
import com.solvd.atm.utils.collections.AllChecksCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public  class JsonParser {

    protected final static Logger LOGGER = LogManager.getLogger(JsonParser.class);
    private static final File JSON_FILE = new File("src/main/resources/checks/cheks.json");

    public static void writeToJSON() {

        ChecksList checksList = new ChecksList();
        checksList.setCheckList(AllChecksCollection.indexCheckList());
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(JSON_FILE,checksList);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}



