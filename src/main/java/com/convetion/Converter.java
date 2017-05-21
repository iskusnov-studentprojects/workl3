package com.convetion;

import java.util.List;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Converter {
    private static Converter instance;
    private List<Units> units;
    private List<UnitsType> unitsType;

    private Converter(){

    }

    public static Converter getInstance() {
        return instance;
    }

    public List<Units> getUnits() {
        return units;
    }

    public List<UnitsType> getUnitsType() {
        return unitsType;
    }
}
