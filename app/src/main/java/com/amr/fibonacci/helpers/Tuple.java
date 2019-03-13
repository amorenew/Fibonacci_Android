package com.amr.fibonacci.helpers;

public class Tuple {
    public final Long value1;
    public final Long value2;

    public Tuple(Long value1, Long value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public static Long value2(Tuple tuple) {
        return tuple.value2;
    }
}