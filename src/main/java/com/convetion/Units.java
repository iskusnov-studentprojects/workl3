package com.convetion;

import com.sun.istack.internal.NotNull;

/**
 * Created by Sergey on 21.05.2017.
 */
public class Units {
    String name;
    String abbr;
    int multiplier;
    UnitsType type;

    public Units(@NotNull String name,@NotNull String abbr, int multiplier, @NotNull UnitsType type) {
        this.name=name;
        this.abbr=abbr;
        this.multiplier=multiplier;
        this.type=type;
    }
}
