package com.convetion;

import com.sun.istack.internal.NotNull;

/**
 * Created by Sergey on 21.05.2017.
 */
public class UnitsType {
    private String name;
    private int index;

    public UnitsType(int index,@NotNull String name) {
        this.index=index;
        this.name=name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public boolean compare(UnitsType unitsType) {
        if(unitsType == null)
            return false;
        if(unitsType.index==index)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
