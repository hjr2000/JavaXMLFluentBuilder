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

    public static void main(String[] args) throws ParserConfigurationException, TransformerException
    {
	    // Source material:
        //  https://www.tutorialspoint.com/java_xml/java_dom_create_document.htm
        //  https://en.wikipedia.org/wiki/Builder_pattern
        //  https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/

        boolean exportToFile = false;

        // todo - Set up the car collection prior to creating the CarCollectionBuilder below? Otherwise you get duplication
        // todo - which isn't a good look??? or not?!

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
