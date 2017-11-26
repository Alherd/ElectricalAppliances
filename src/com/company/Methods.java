package com.company;

import java.util.ArrayList;

public class Methods extends AbstractMethods implements InterfaceMethods {
    private ArrayList<UnitsInRoom> unitsInUnitsInRooms;
    private ArrayList<Unit> units;

    public Methods() {
        unitsInUnitsInRooms = new ArrayList<>();
        units = new ArrayList<>();
    }

    public void addNewRoom(String roomName, int roomPower) {
        if (roomName == null || roomName.equals("")) {
            System.out.println("Название комнаты не может быть пустоым или null");
            return;
        } else {
            if (roomPower <= 0) {
                System.out.println("Мощность прибора требует положительного значения");
                return;
            }
        }
        if (findRoom(roomName) != null) throw new IllegalArgumentException("Комната уже существует");
        unitsInUnitsInRooms.add(new UnitsInRoom(roomName, roomPower));
        System.out.println("Комната добавлена");
    }

    public void addNewUnit(String unitName, int unitPower) {
        if (unitName == null || unitName.equals("")) {
            System.out.println("Название прибора не может быть пустым или null");
            return;
        } else {
            if (unitPower <= 0) {
                System.out.println("Мощность прибора требует положительного значения");
                return;
            }
        }
        Unit tempUnit = new Unit(unitName, unitPower);
        units.add(tempUnit);
        System.out.println("Прибор добавлен в список бескомнатных");
    }

    public void addUnitToRoom(int unitID, String roomName) {
        Unit opUnit = getUnit(unitID);
        if (opUnit != null) {
            String unitName = opUnit.getUnitName();
            int unitPower = opUnit.getUnitPower();
            UnitsInRoom tempUnitsInRoom = findRoom(roomName);
            if (tempUnitsInRoom == null) {
                System.out.println("Комната не найдена");
                return;
            }
            tempUnitsInRoom.setRoomPower(tempUnitsInRoom.getRoomPower() - opUnit.getUnitPower());
            int a = tempUnitsInRoom.getRoomPower();
            Unit tempUnit = new Unit(unitName, unitPower, tempUnitsInRoom);
            tempUnitsInRoom.assignUnitToRoom(tempUnit);
            System.out.println("Прибор в комнату добавлен, оставшаяся мощность " + a);
            units.remove(opUnit);
            return;
        } else System.out.println("Прибор не найден");
    }

    public void deleteUnit(int unitId) {
        if (unitId < 0) {
            System.out.println("Индекс прибора может быть только положительным");
            return;
        }
        for (UnitsInRoom unitsInRoom : unitsInUnitsInRooms) {
            for (Unit unit : unitsInRoom.getRoomUnits()) {
                if (unit.getUnitId() == unitId) {
                    Unit unit1 = getOneUnit(unitId);
                    unitsInRoom.setRoomPower(unitsInRoom.getRoomPower() + unit1.getUnitPower());
                    int a = unitsInRoom.getRoomPower();
                    addNewUnit(unit1.getUnitName(), unit1.getUnitPower());
                    unit.removeRoomFromUnit();
                    unitsInRoom.deleteUnit(unit);
                    System.out.println("Прибор из комнаты удален, оставшаяся мощность: " + a);
                    return;
                }
            }
        }
        System.out.println("Прибор не найден");
    }

    public void powerOnUnit(int unitId) {
        if (unitId < 0) {
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
        if (unitId < 0) {
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


    public void printAllSortedUnits() {
        System.out.println("отсортированные включенные приборы (в порядке увеличения используемой мощности)");
        ArrayList<Unit> units = getAllUnits();
        units.sort(new UnitPowerComparator());
        for (Unit unit : units) {
           /* if (unit.isUnitPoweredOn())*/
            System.out.println(unit);
        }
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


    private Unit getOneUnit(int unitId) {
        for (UnitsInRoom unitsInRoom : unitsInUnitsInRooms) {
            for (Unit unit : unitsInRoom.getRoomUnits()) {
                if (unit.getUnitId() == unitId) return unit;
            }
        }
        return null;
    }

    private Unit getUnit(int unitId) {
        for (Unit unit : units) {
            if (unit.getUnitId() == unitId) return unit;
        }
        return null;
    }

    private UnitsInRoom findRoom(String roomName) {
        for (UnitsInRoom elem : unitsInUnitsInRooms) {
            if (elem.getRoomName().equalsIgnoreCase(roomName)) return elem;
        }
        return null;
    }

    public ArrayList<Unit> getAllUnits() {
        ArrayList<Unit> units = new ArrayList<>();
        for (UnitsInRoom unitsInRoom : unitsInUnitsInRooms) {
            for (Unit unit : unitsInRoom.getRoomUnits()) {
                units.add(unit);
            }
        }
        return units;
    }

    @Override
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

    @Override
    public void printAllUnits() {
        for (Unit unit : getAllUnits()) System.out.println(unit);
    }
}
