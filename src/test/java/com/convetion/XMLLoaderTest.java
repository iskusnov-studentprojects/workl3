package com.convetion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey on 21.05.2017.
 */
public class XMLLoaderTest {
    @Test
    public void testLoadUnitsType() throws Exception {
        assertNotNull(XMLLoader.loadUnitsType(""));
    }

    @Test
    public void testLoadUnitsTypeNumberRows() throws Exception {
        assertTrue(XMLLoader.loadUnitsType("src/main/java/resources/units.xml").size() > 0);
    }

    @Test
    public void testLoadUnits() throws Exception {
        assertNotNull(XMLLoader.loadUnits(""));
    }

    @Test
    public void testLoadUnitsNumberRows() throws Exception {
        assertTrue(XMLLoader.loadUnits("src/main/java/resources/units.xml").size() > 0);
    }
}