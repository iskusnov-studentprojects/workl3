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
    public void testLoadUnits() throws Exception {
        assertNotNull(XMLLoader.loadUnits(""));
    }
}