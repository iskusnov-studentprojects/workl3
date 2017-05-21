package com.convetion;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Converter {
    private static Converter instance;

    private Converter(){

    }

    public static Converter getInstance() {
        return instance;
    }
}
