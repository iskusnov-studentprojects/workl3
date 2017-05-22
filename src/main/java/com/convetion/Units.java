package com.convetion;

import com.sun.istack.internal.NotNull;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Units {
    private String name;
    private String abbreviation;
    private double multiplier;
    private UnitsType type;
    private double shiftBefore;
    private double shiftAfter;


    public Units(@NotNull String name,@NotNull String abbreviation, double multiplier, double shiftBefore, double shiftAfter, @NotNull UnitsType type) {
        this.name=name;
        this.abbreviation=abbreviation;
        this.multiplier=multiplier;
        this.type=type;
        this.shiftBefore=shiftBefore;
        this.shiftAfter=shiftAfter;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public UnitsType getType() {
        return type;
    }

    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public String toString() {
        return name;
    }

    public double convertTo(double value, Units units) {
        //// TODO: 21.05.2017 реализовать перевод
        return 1;
    }

    public double getShiftBefore() {
        return shiftBefore;
    }

    public double getShiftAfter() {
        return shiftAfter;
    }
}
