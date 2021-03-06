package com.javaxmlexample;

import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

public class Main {

    // todo - put pictures in the ReadMe
    // todo - change the schema a bit maybe, and introduce further functionality
    // todo - create Ferrari and Maclaren templates

    public static void main(String[] args) throws ParserConfigurationException, TransformerException
    {
        boolean exportToFile = false;

        // Create our source car collection, which may be one of a number of templates.
        CarCollection carCollection = new CarCollection();

        carCollection
                .setSupercarName("Ferrari 999")
                .setSupercarManufacturer("Maserati");

        Document carCollectionDoc = CarCollectionDocBuilder.build(carCollection);

        // Export our car collection XML to a file if required
        if (exportToFile) exportToFile(carCollectionDoc);

        // Write our XML to the console so we can see what's going on
        writeXMLDocumentToConsole(carCollectionDoc);
    }

    // todo - create an XML utilities folder and this and the writeXMLtoconsole method in it

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
