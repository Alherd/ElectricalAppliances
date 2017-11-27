package com.company;

import java.util.ArrayList;

public class Unit {
    private static int unitIdCounter = 0;
    private int unitId;
    private String unitName;
    private UnitsInRoom unitsInRoom;
    private int power;
    private boolean isPowerOn;

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    private ArrayList<Unit> units;

    public Unit(String unitName, int power, UnitsInRoom unitsInRoom) {
        this.unitId = unitIdCounter++;
        System.out.println("ID прибора: " + unitId);
        this.unitName = unitName;
        this.power = power;
        this.unitsInRoom = unitsInRoom;
    }

    public Unit(String unitName, int power) {
        unitId = unitIdCounter++;
        System.out.println("ID прибора: " + unitId);
        this.unitName = unitName;
        this.power = power;
    }

    public int getUnitId() {
        return unitId;
    }

    public int getUnitPower() {
        return power;
    }

    public String getUnitName() {
        return unitName;
    }

    public void removeRoomFromUnit() {
        unitsInRoom = null;
    }

    public void powerOnUnit() {
        this.isPowerOn = true;
    }

    public void powerOffUnit() {
        this.isPowerOn = false;
    }

    public boolean isUnitPoweredOn() {
        return isPowerOn;
    }

    @Override
    public String toString() {
        return "Прибор{" +
                "Id прибора=" + unitId +
                ", Название прыбора='" + unitName + '\'' +
                ", комната = " + unitsInRoom +
                ", мощность = " + power +
                ", включен? = " + isPowerOn +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        if (unitId != unit.unitId) return false;
        if (power != unit.power) return false;
        if (!unitName.equals(unit.unitName)) return false;
        return !(unitsInRoom != null ? !unitsInRoom.equals(unit.unitsInRoom) : unit.unitsInRoom != null);
    }

}
