package com.convetion;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 * Created by Sergey on 21.05.2017.
 */
public class UnitsTest {
    @Test
    public void testCreationUnits() throws Exception {
        Units units = new Units("name", "abbr", 1, 0, 0, new UnitsType(0,""));
        assertNotNull(units);
    }

    @Test
    public void testGetName() throws Exception {
        String name = "value";
        Units units = new Units(name, "abbr", 1, 0, 0, new UnitsType(0,""));
        assertEquals(name, units.getName());
    }

    @Test
    public void testGetAbbreviation() throws Exception {
        String abbr = "value";
        Units units = new Units("name", abbr, 1, 0, 0, new UnitsType(0,""));
        assertEquals(abbr, units.getAbbreviation());
    }

    @Test
    public void testGetUnitsType() throws Exception {
        UnitsType type = new UnitsType(0,"");
        Units units = new Units("name", "abbr", 1, 0, 0, type);
        assertTrue(units.getType().compare(type));
    }

    @Test
    public void testGetIndex() throws Exception {
        int mult = 0;
        Units units = new Units("name", "abbr", mult, 0, 0, new UnitsType(0,""));
        assertEquals(mult, units.getMultiplier(), 0.000001);
    }

    @Test
    public void testConvertToSameType() throws Exception {
        Units units = new Units("","",0, 0, 0,new UnitsType(0,""));
        assertEquals(1,units.convertTo(1, units), 0.00001);
    }

    @Test
    public void testGetShiftBefore() throws Exception {
        Units units = new Units("","",0, 0, 0,new UnitsType(0,""));
        assertEquals(0, units.getShiftBefore(), 0.001);
    }

    @Test
    public void testGetShiftAfter() throws Exception {
        Units units = new Units("","",0, 0, 0,new UnitsType(0,""));
        assertEquals(0, units.getShiftAfter(), 0.001);
    }
}