package com.company;

import java.util.Scanner;

public class Main {

    private static Methods sUsingMethods;

    private static String[] operationNames = {
            "\n1. Добавить комнату",
            "2. Добавить прибор",
            "3. Добавить прибор в комнату",
            "4. Удалить прибор из комнаты",
            "5. Включить прибор",
            "6. Выключить прибор",
            "7. Показать все приборы",
            "8. Показать отсортированные включенные приборы (в порядке увеличения используемой мощности)",
            "9. Показать всю используемую можность",
            "10. Найти прибор по имени",
            "11. Найти прибор по установленным значениям мощности",
            "0. Выйти\n"};

    public static void main(String[] args) {
        sUsingMethods = new Methods();
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
                    sUsingMethods.addNewRoom(inputString("название комнаты"), inputInt("максимальную мощность комнаты"));
                    break;
                case 2: // Добавить прибор
                    sUsingMethods.addNewUnit(inputString("название прибора"), inputInt("мощность прибора"));
                    break;
                case 3: // Добавить прибор в комнату
                    sUsingMethods.addUnitToRoom(inputInt("id прибора"), inputString("название комнаты"));
                    break;
                case 4: // Удалить прибор
                    sUsingMethods.deleteUnit(inputInt("существующий ID прибора"));
                    break;
                case 5: // Включить прибор
                    sUsingMethods.powerOnUnit(inputInt("существующий ID прибора"));
                    break;
                case 6: // Выключить прибор
                    sUsingMethods.powerOffUnit(inputInt("существующий ID прибора"));
                    break;
                case 7: // Показать все приборы
                    sUsingMethods.printAllUnits();
                    break;
                case 8: // Показать отсортированные включенные приборы (в порядке увеличения используемой мощности)
                    sUsingMethods.printAllSortedUnits();
                    break;
                case 9: // Показать всю используемую можность
                    sUsingMethods.showActualPower();
                    break;
                case 10: // Найти прибор по имени
                    sUsingMethods.findUnit(inputString("название прибора или его часть"));
                    break;
                case 11: //  Найти прибор по установленным значениям мощности
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
