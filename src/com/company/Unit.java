package com.company;

public class Unit {
    private static int unitIdCounter = 0;
    private int unitId;
    private String unitName;
    private Room room;
    private int power;
    private boolean isPowerOn;

    public Unit(String unitName, int power, Room room) {
        unitId = unitIdCounter++;
        System.out.println("ID прибора: " + unitId);
        this.unitName = unitName;
        this.power = power;
        this.room = room;
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
        room = null;
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
                ", комната = " + room +
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
        return !(room != null ? !room.equals(unit.room) : unit.room != null);
    }
}
