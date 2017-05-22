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

    @Test
    public void testConvertSameTypes() throws Exception {
        Units units = new Units("","",0, 0, 0,new UnitsType(0,""));
        assertEquals(1, Converter.getInstance().convert(1, units, units), 0.00001);
    }

    @Test
    public void testConvertMetrToArshin() throws Exception {
        Units metr = new Units("Метры", "м", 1, 0, 0,new UnitsType(0,"Расстояние")),
                arshin = new Units("Аршины", "а", 1.406, 0, 0,new UnitsType(0,"Расстояние"));
        assertEquals(14.06, Converter.getInstance().convert(10, metr, arshin), 0.01);
    }

    @Test
    public void testConvertCelsiiToFaringate() throws Exception {
        Units celsii = new Units("Цельсий", "C", 1, 0, 0,new UnitsType(0,"Темпиратура")),
                faringate = new Units("Фарингейт", "F", 1.8, 0, 32,new UnitsType(0,"Темпиратура"));
        assertEquals(50, Converter.getInstance().convert(10, celsii, faringate), 0.01);
    }

    @Test
    public void testConvertFaringateToKelvin() throws Exception {
        Units kelvin = new Units("Кельвин", "C", 1, 0, 273.15, new UnitsType(0,"Темпиратура")),
                faringate = new Units("Фарингейт", "F", 1.8, 0, 32,new UnitsType(0,"Темпиратура"));
        assertEquals(260.928, Converter.getInstance().convert(10, faringate, kelvin), 0.01);
    }
}