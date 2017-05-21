package com.convetion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey on 21.05.2017.
 */
public class UnitsTypeTest {
    @Test
    public void testCreationUnitsType() throws Exception {
        UnitsType unitsType = new UnitsType(0, "name");
        assertNotNull(unitsType);
    }

    @Test
    public void testGetIndex() throws Exception {
        int index = 0;
        UnitsType unitsType = new UnitsType(index, "name");
        assertEquals(index, unitsType.getIndex());
    }

    @Test
    public void testGetName() throws Exception {
        String name = "name";
        UnitsType unitsType = new UnitsType(0, name);
        assertEquals(name, unitsType.getName());
    }

    @Test
    public void testCompare() throws Exception {
        UnitsType unitsType1 = new UnitsType(0, "name"),
                unitsType2 = new UnitsType(0, "name");
        assertTrue(unitsType1.compare(unitsType2));
    }
}