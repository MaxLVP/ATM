package com.solvd.atm.utils.parsers;

import com.solvd.atm.models.ChecksList;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.utils.collections.AllChecksCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlParser {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final File XML_FILE = new File("src/main/resources/checks/checks.xml");

    public static void writeToXml() {
        ChecksList checksList = new ChecksList();
        checksList.setCheckList(AllChecksCollection.indexCheckList());
        try {
            JAXBContext jaxB = JAXBContext.newInstance(ChecksList.class);
            Marshaller m = jaxB.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(checksList,
                    XML_FILE);
        } catch (JAXBException ex) {
            LOGGER.error("Failed to print xml file");
            LOGGER.error(ex.getMessage());
        }

    }
}
