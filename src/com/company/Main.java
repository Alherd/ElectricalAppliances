package com.company;

import java.util.Scanner;

public class Main {

    private static UnitMethods sUsingMethods;

    private static String[] operationNames = {
            "\n1. Добавить комнату",
            "2. Добавить прибор",
            "3. Удалить прибор",
            "4. Включить прибор",
            "5. Выключить прибор",
            "6. Показать все приборы",
            "7. Показать отсортированные включенные приборы (в порядке увеличения используемой мощности)",
            "8. Показать всю используемую можность",
            "9. Найти прибор по имени",
            "10. Найти прибор по установленным значениям мощности",
            "0. Выйти\n"};

    public static void main(String[] args) {
        sUsingMethods = new UnitMethods();
        menu();
    }

    private static void printMenu() {
        for (String name : operationNames)
            System.out.println(name);
    }

    private static void menu() {
        boolean runWhile = true;
        while (runWhile) {
            printMenu();
            int k = inputInt("номер операции");
            switch (k) {
                case 1: // Добавить комнату
                    sUsingMethods.addNewRoom(inputString("название комнаты"));
                    break;
                case 2: // Добавить прибор
                    sUsingMethods.addNewUnit(inputString("название прибора"), inputInt("мощность прибора"),
                            inputString("существующее название комнаты"));
                    break;
                case 3: // Удалить прибор
                    sUsingMethods.deleteUnit(inputInt("существующий ID прибора"));
                    break;
                case 4: // Включить прибор
                    sUsingMethods.powerOnUnit(inputInt("существующий ID прибора"));
                    break;
                case 5: // Выключить прибор
                    sUsingMethods.powerOffUnit(inputInt("существующий ID прибора"));
                    break;
                case 6: // Показать все приборы
                    sUsingMethods.printAllUnits();
                    break;
                case 7: // Показать отсортированные включенные приборы (в порядке увеличения используемой мощности)
                    sUsingMethods.printAllSortedUnits();
                    break;
                case 8: // Показать всю используемую можность
                    sUsingMethods.showActualPower();
                    break;
                case 9: // Найти прибор по имени
                    sUsingMethods.findUnit(inputString("название прибора или его часть"));
                    break;
                case 10: //  Найти прибор по установленным значениям мощности
                    sUsingMethods.findUnitPower(inputInt("минимальную мощность"),
                            inputInt("максимальную мощность"));
                    break;
                case 0: // Выйти
                    runWhile = false;
            }
        }
    }

    private static int inputInt(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Пожалуйста, введите " + str);
        return scan.nextInt();
    }

    private static String inputString(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Пожалуйста, введите " + str);
        return scan.nextLine();
    }
}
