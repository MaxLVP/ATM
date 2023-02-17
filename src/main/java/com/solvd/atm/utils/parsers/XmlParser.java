package com.solvd.atm.utils.parsers;

import com.solvd.atm.utils.collections.AllChecksCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlParser {

    public static void writeToXml() throws JAXBException {
        ChecksCollection checksCollection = new ChecksCollection();
        checksCollection.setCheckList(AllChecksCollection.indexCheckList());
        JAXBContext jaxB = JAXBContext.newInstance(ChecksCollection.class);
        Marshaller m = jaxB.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(checksCollection,
                new File("src/main/resources/checks/checks.xml"));
    }
}
