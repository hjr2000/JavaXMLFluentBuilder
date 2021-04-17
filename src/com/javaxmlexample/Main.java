package com.javaxmlexample;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException
    {
	    // Source material: https://www.tutorialspoint.com/java_xml/java_dom_create_document.htm
        boolean exportToFile = false;

        Document carCollectionDoc = CarCollectionBuilder
                .create()
                //.setSupercarManufacturer("Maserati")
                .build();

        if (exportToFile){
            exportToFile(carCollectionDoc);
        }

        // Write our XML to the console so we can see what's going on
        writeXMLDocumentToConsole(carCollectionDoc);

    }

    private static void exportToFile(Document carCollectionDoc) throws TransformerException {
        /////////////////////////////////////////////////////////////////////////
        // write the content into xml file (writes into top level project folder
        /////////////////////////////////////////////////////////////////////////
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(carCollectionDoc);
        // Write the file to the present working directory which should be the top level folder of this project
        StreamResult result = new StreamResult(new File("cars.xml"));
        transformer.transform(source, result);
    }

    private static void writeXMLDocumentToConsole(Document carCollectionDoc) throws TransformerException {
        System.out.println("-------------------------------------------------------------------------\n");

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        // Nicely format the XML as a string
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        Transformer transformerStringFormatting = TransformerFactory.newInstance().newTransformer();
        transformerStringFormatting.setOutputProperty(OutputKeys.INDENT, "yes");
        int indentAmount = 2;
        transformerStringFormatting.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(indentAmount));

        StreamResult resultStringFormatting = new StreamResult(new StringWriter());
        DOMSource sourceStringFormatting = new DOMSource(carCollectionDoc);
        transformerStringFormatting.transform(sourceStringFormatting, resultStringFormatting);
        String xmlAsString = resultStringFormatting.getWriter().toString();
        System.out.println(xmlAsString);

        System.out.println("-------------------------------------------------------------------------");
    }
}
