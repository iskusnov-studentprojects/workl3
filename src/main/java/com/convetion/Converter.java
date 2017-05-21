package com.convetion;

import com.sun.org.apache.xerces.internal.impl.xs.util.ObjectListImpl;

import java.util.List;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Converter {
    private static Converter instance;
    private List<Units> units;
    private List<UnitsType> unitsType;

    private Converter(){
        units = new ObjectListImpl(null, 0);
        unitsType = new ObjectListImpl(null, 0);
    }

    public static Converter getInstance() {
        if(instance == null)
            instance = new Converter();
        return instance;
    }

    public List<Units> getUnits() {
        //// TODO: 21.05.2017 сделать нередактируемым
        return units;
    }

    public List<UnitsType> getUnitsType() {
        //// TODO: 21.05.2017 сделать нередактируемым
        return unitsType;
    }

    public double convert(double value, Units unitsSrc, Units unitsTrg) {
        //// TODO: 21.05.2017 реализовать перевод
        return 1;
    }
}
