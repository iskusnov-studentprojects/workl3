package com.convetion;

import com.sun.istack.internal.NotNull;

/**
 * Created by Sergey on 21.05.2017.
 */
public class UnitsType {
    String name;
    int index;

    public UnitsType(int index,@NotNull String name) {
        this.index=index;
        this.name=name;
    }
}
