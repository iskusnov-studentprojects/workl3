package com.convetion;

import com.sun.org.apache.xerces.internal.impl.xs.util.ObjectListImpl;
import org.dom4j.DocumentException;
import org.xml.sax.SAXException;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Converter {
    private static Converter instance;
    private List<Units> units;
    private List<UnitsType> unitsType;

    private Converter() throws DocumentException, SAXException {
        units = XMLLoader.loadUnits("src/main/java/resources/units.xml");
        unitsType = XMLLoader.loadUnitsType("src/main/java/resources/units.xml");
    }

    public static Converter getInstance() throws SAXException, DocumentException {
        if(instance == null)
            instance = new Converter();
        return instance;
    }

    public List<Units> getUnits() {
        return Collections.unmodifiableList(units);
    }

    public List<UnitsType> getUnitsType() {
        return Collections.unmodifiableList(unitsType);
    }

    public double convert(double value, Units unitsSrc, Units unitsTrg) {
        //// TODO: 21.05.2017 реализовать перевод
        return 1;
    }
}
