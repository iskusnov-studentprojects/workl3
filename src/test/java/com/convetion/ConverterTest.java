package com.convetion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sergey on 21.05.2017.
 */
public class ConverterTest {
    @Test
    public void testGetInstance() throws Exception {
        assertNotNull(Converter.getInstance());
    }

    @Test
    public void testGetUnits() throws Exception {
        assertNotNull(Converter.getInstance().getUnits());
    }

    @Test
    public void testGetUnitsType() throws Exception {
        assertNotNull(Converter.getInstance().getUnitsType());
    }
}