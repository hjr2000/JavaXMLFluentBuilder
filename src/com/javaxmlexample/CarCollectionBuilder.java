package com.javaxmlexample;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CarCollectionBuilder {

    protected CarCollection carCollection;

    // Constructor
    protected CarCollectionBuilder(CarCollection carCollection) {
        this.carCollection = carCollection;
    }

    public static CarCollectionBuilder create(){
        return new CarCollectionBuilder(new CarCollection());
    }

    public CarCollectionBuilder setSupercarManufacturer(String brand){
        carCollection.setSupercarManufacturer(brand);
        return this;
    }

    public Document build() throws ParserConfigurationException
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
        carName.appendChild(doc.createTextNode("Ferrari 101"));
        supercar.appendChild(carName);

        Element carName1 = doc.createElement("carname");
        Attr attrType1 = doc.createAttribute("type");
        attrType1.setValue("sports");
        carName1.setAttributeNode(attrType1);
        carName1.appendChild(doc.createTextNode("Ferrari 203"));
        supercar.appendChild(carName1);

        return doc;
    }
}
