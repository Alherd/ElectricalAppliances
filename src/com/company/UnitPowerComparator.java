package com.company;

import java.util.Comparator;

public class UnitPowerComparator implements Comparator<Unit> {
    @Override
    public int compare(Unit un1, Unit un2) {
        return (un1.getUnitPower() - un2.getUnitPower());
    }
}