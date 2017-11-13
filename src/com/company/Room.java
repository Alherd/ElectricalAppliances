package com.company;

import java.util.ArrayList;

public class Room {
    private String roomName;

    private ArrayList<Unit> roomUnits;

    public Room(String roomName) {
        if (roomName == null || roomName.equals(""))
            throw new IllegalArgumentException("Название комнаты не может быть null");
        this.roomName = roomName;
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

        Room room = (Room) o;

        return roomName.equalsIgnoreCase(room.roomName);

    }

    @Override
    public String toString() {
        return roomName;
    }
}
