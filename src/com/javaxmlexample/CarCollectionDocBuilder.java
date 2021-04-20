package com.javaxmlexample;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CarCollectionDocBuilder {

    public static Document build(CarCollection carCollection) throws ParserConfigurationException
    {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        // root element
        Element rootElement = doc.createElement("cars");
        doc.appendChild(rootElement);

        // supercars element
        Element supercar = doc.createElement("supercars");
        rootElement.appendChild(supercar);

        // setting attribute to element
        Attr attr = doc.createAttribute("company");
        attr.setValue(carCollection.getSupercarManufacturer());
        supercar.setAttributeNode(attr);

        // carName element
        Element carName = doc.createElement("carname");
        carName.appendChild(doc.createTextNode(carCollection.getSupercarName()));
        supercar.appendChild(carName);

        Element carName1 = doc.createElement("carname");
        Attr attrType1 = doc.createAttribute("type");
        attrType1.setValue(carCollection.getSupercarType());
        carName1.setAttributeNode(attrType1);
        carName1.appendChild(doc.createTextNode(carCollection.getSupercarSportscarName()));
        supercar.appendChild(carName1);

        return doc;
    }
}
