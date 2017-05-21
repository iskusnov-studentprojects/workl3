package com.convetion;

import com.sun.istack.internal.NotNull;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Units {
    private String name;
    private String abbreviation;
    private int multiplier;
    private UnitsType type;


    public Units(@NotNull String name,@NotNull String abbreviation, int multiplier, @NotNull UnitsType type) {
        this.name=name;
        this.abbreviation=abbreviation;
        this.multiplier=multiplier;
        this.type=type;
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

    public int getMultiplier() {
        return multiplier;
    }
}
