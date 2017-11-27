package com.company;

import java.util.ArrayList;

public class UnitsInRoom {
    private String roomName;
    private int roomPower;

    private ArrayList<Unit> roomUnits;

    public UnitsInRoom(String roomName, int roomPower) {
        if (roomName == null || roomName.equals(""))
            throw new IllegalArgumentException("Название комнаты не может быть null");
        this.roomName = roomName;
        this.roomPower = roomPower;
        this.roomUnits = new ArrayList<>();
    }

    public void assignUnitToRoom(Unit unit) {
        if (unit == null) throw new IllegalArgumentException("Прибор не может быть null");
        if (!checkExistsUnit(unit)) roomUnits.add(unit);
    }

    public void deleteUnit(Unit unit) {
        if (unit == null) throw new IllegalArgumentException("Прибор не может быть null");
        if (checkExistsUnit(unit)) roomUnits.remove(unit);
    }

    public String getRoomName() {
        return roomName;
    }

    public ArrayList<Unit> getRoomUnits() {
        return roomUnits;
    }

    private boolean checkExistsUnit(Unit unit) {
        for (Unit un : roomUnits) {
            if (un.equals(unit)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitsInRoom unitsInRoom = (UnitsInRoom) o;

        return roomName.equalsIgnoreCase(unitsInRoom.roomName);

    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomPower() {
        return roomPower;
    }

    public void setRoomPower(int roomPower) {
        this.roomPower = roomPower;
    }

    public void setRoomUnits(ArrayList<Unit> roomUnits) {
        this.roomUnits = roomUnits;
    }

    @Override
    public String toString() {
        return roomName;
    }
}
