package com.fizzware.dramaticdoors.state.properties;

import net.minecraft.util.IStringSerializable;

public enum TripleBlockPart implements IStringSerializable {
    UPPER("upper"),
    MIDDLE("middle"),
    LOWER("lower");

    private final String name;

    private TripleBlockPart(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName();
    }

    public String getName() {
        return this == UPPER ? "upper" : this == MIDDLE ? "middle" : "lower";
    }

    public String func_176610_l() {
        return this.name;
    }
}