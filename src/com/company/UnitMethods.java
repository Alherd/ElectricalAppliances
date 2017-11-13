package com.company;

import java.util.ArrayList;

public class UnitMethods {
    private ArrayList<Room> rooms;

    public UnitMethods() {
        rooms = new ArrayList<>();
    }

    public void addNewRoom(String roomName) {
        if (roomName == null || roomName.equals("")) {
            System.out.println("Название комнаты не может быть пустоым или null");
            return;
        }
        if (findRoom(roomName) != null) throw new IllegalArgumentException("Комната уже существует");
        rooms.add(new Room(roomName));
        System.out.println("Комната добавлена");
    }

    public void addNewUnit(String unitName, int unitPower, String roomName) {
        if (unitName == null || unitName.equals("")) {
            System.out.println("Название прибора не может быть пустым или null");
            return;
        } else {
            if (unitPower <= 0) {
                System.out.println("Мощность прыбора требует положительного значения");
                return;
            }
        }
        Room tempRoom = findRoom(roomName);
        if (tempRoom == null) {
            System.out.println("Комната не найдена");
            return;
        }
        Unit tempUnit = new Unit(unitName, unitPower, tempRoom);
        tempRoom.assignUnitToRoom(tempUnit);
        System.out.println("Прибор добавлен");
    }

    public void deleteUnit(int unitId) {
        if (unitId <= 0) {
            System.out.println("Индекс прибора может быцть только положительным");
            return;
        }
        for (Room room : rooms) {
            for (Unit unit : room.getRoomUnits()) {
                if (unit.getUnitId() == unitId) {
                    unit.removeRoomFromUnit();
                    room.deleteUnit(unit);
                    System.out.println("Прибор удален");
                    return;
                }
            }
        }
        System.out.println("Прибор не найден");
    }

    public void powerOnUnit(int unitId) {
        if (unitId <= 0) {
            System.out.println("Индекс прибора может быть только полжительным");
            return;
        }
        Unit opUnit = getOneUnit(unitId);
        if (opUnit != null) {
            opUnit.powerOnUnit();
            System.out.println("Прибор включен");
            return;
        } else System.out.println("Прибор не найден");
    }

    public void powerOffUnit(int unitId) {
        if (unitId <= 0) {
            System.out.println("Индекс прибора может быть только полжительным");
            return;
        }
        Unit opUnit = getOneUnit(unitId);
        if (opUnit != null) {
            opUnit.powerOffUnit();
            System.out.println("Прибор выключен");
            return;
        } else System.out.println("Прибор не найден");
    }

    public void printAllUnits() {
        for (Unit unit : getAllUnits()) System.out.println(unit);
    }

    public void printAllSortedUnits() {
        System.out.println("отсортированные включенные приборы (в порядке увеличения используемой мощности)");
        ArrayList<Unit> units = getAllUnits();
        units.sort(new UnitPowerComparator());
        for (Unit unit : units) {
           /* if (unit.isUnitPoweredOn())*/ System.out.println(unit);
        }
    }

    public void showActualPower() {
        int totalPower = 0;
        ArrayList<Unit> units = getAllUnits();
        for (Unit unit : units) {
            if (unit.isUnitPoweredOn()) totalPower = totalPower + unit.getUnitPower();
        }
        printAllSortedUnits();
        System.out.println();
        System.out.println("Общая используемая мощность: " + totalPower + "  ват");

    }

    public void findUnit(String unitName) {
        ArrayList<Unit> units = getAllUnits();
        System.out.println("Найден прибор с именем:");
        for (Unit unit : units) {
            if (unit.getUnitName().contains(unitName) || unit.getUnitName().equalsIgnoreCase(unitName))
                System.out.println(unit);
        }
    }

    public void findUnitPower(int minPower, int maxPower) {
        ArrayList<Unit> units = getAllUnits();
        System.out.println("Найден прибор с именем:");
        for (Unit unit : units) {
            if ((minPower <= unit.getUnitPower()) && (maxPower >= unit.getUnitPower()))
                System.out.println("Найден прибор с именем: " + unit);
            else
                System.out.println("Не нашлось прибора, который отвечает вашим требованиям");
        }
    }

    private ArrayList<Unit> getAllUnits() {
        ArrayList<Unit> units = new ArrayList<>();
        for (Room room : rooms) {
            for (Unit unit : room.getRoomUnits()) {
                units.add(unit);
            }
        }
        return units;
    }

    private Unit getOneUnit(int unitId) {
        for (Room room : rooms) {
            for (Unit unit : room.getRoomUnits()) {
                if (unit.getUnitId() == unitId) return unit;
            }
        }
        return null;
    }

    private Room findRoom(String roomName) {
        for (Room elem : rooms) {
            if (elem.getRoomName().equalsIgnoreCase(roomName)) return elem;
        }
        return null;
    }
}
