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
        Units units = new Units("name", "abbr", 1, new UnitsType(0,""));
        assertNotNull(units);
    }

    @Test
    public void testGetName() throws Exception {
        String name = "value";
        Units units = new Units(name, "abbr", 1, new UnitsType(0,""));
        assertEquals(name, units.getName());
    }

    @Test
    public void testGetAbbreviation() throws Exception {
        String abbr = "value";
        Units units = new Units("name", abbr, 1, new UnitsType(0,""));
        assertEquals(abbr, units.getAbbreviation());
    }

    @Test
    public void testGetUnitsType() throws Exception {
        UnitsType type = new UnitsType(0,"");
        Units units = new Units("name", "abbr", 1, type);
        assertTrue(units.getType().compare(type));
    }

    @Test
    public void testGetIndex() throws Exception {
        int mult = 0;
        Units units = new Units("name", "abbr", mult, new UnitsType(0,""));
        assertEquals(mult, units.getMultiplier());
    }

    @Test
    public void testConvertToSameType() throws Exception {
        Units units = new Units("","",0,new UnitsType(0,""));
        assertEquals(1,units.convertTo(1, units));
    }
}