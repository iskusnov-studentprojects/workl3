package com.convetion;

import com.sun.org.apache.xerces.internal.impl.xs.util.ObjectListImpl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sergey on 21.05.2017.
 */
public class XMLLoader {
    public static List<UnitsType> loadUnitsType(String path) throws DocumentException {
        if(path.equals(""))
            return new ObjectListImpl(null, 0);

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(path);
        List<UnitsType> result = new ArrayList<UnitsType>();

        List<Element> types = document.selectNodes("//config/types/unitstype");
        for (Element el : types) {
            String index = el.attributeValue("index");
            String name = el.attributeValue("name");
            result.add(new UnitsType(Integer.valueOf(index), name));
        }
        return result;
    }

    public static List<Units> loadUnits(String path) throws SAXException, DocumentException {
        if(path.equals(""))
            return new ObjectListImpl(null, 0);

        List<UnitsType> unitsTypes = XMLLoader.loadUnitsType(path);

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(path);
        List<Element> units = document.selectNodes("//config/units/values");
        List<Units> result = new ArrayList<Units>();
        for (Element el : units) {
            String name = el.attributeValue("name");
            String abbreviation = el.attributeValue("abbreviation");
            String multiplier = el.attributeValue("multiplier");
            String shiftBefore = el.attributeValue("shiftBefore");
            String shiftAfter = el.attributeValue("shiftAfter");
            String typeIndex = el.attributeValue("type");
            int index = Integer.valueOf(typeIndex);
            UnitsType unitsType = unitsTypes.get(0);
            for (UnitsType i: unitsTypes) {
                if(i.getIndex() == index){
                    unitsType = i;
                    break;
                }
            }
            result.add(new Units(name, abbreviation, Double.valueOf(multiplier), Double.valueOf(shiftBefore), Double.valueOf(shiftAfter),  unitsType));
        }
        return result;
    }
}
