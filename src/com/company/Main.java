package com.company;

import java.util.InputMismatchException;
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
        try {
            menu();
        } catch (InputMismatchException e) {
            System.out.println("Вводите целое число от 0 до 11");
            menu();
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка ввода");
            menu();
        }

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
            if ((k < 0) || (k > 11)) {
                System.out.println("Вводите целое число от 0 до 11");
            }
            try {
                switch (k) {
                    case 1: // Добавить комнату
                        try {
                            sUsingMethods.addNewRoom(inputString("название комнаты"), inputInt("максимальную мощность комнаты"));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Комната уже существует");
                        } catch (InputMismatchException e) {
                            System.out.println("Мощность представляет собой целое число. Комната не добавлена");
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка ввода");
                        }
                        break;
                    case 2: // Добавить прибор
                        try {
                            sUsingMethods.addNewUnit(inputString("название прибора"), inputInt("мощность прибора"));
                        } catch (InputMismatchException e) {
                            System.out.println("Мощность представляет собой целое число. Прибор не добавлен");
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка ввода");
                        }
                        break;
                    case 3: // Добавить прибор в комнату
                        try {
                            sUsingMethods.addUnitToRoom(inputInt("id прибора"), inputString("название комнаты"));
                        } catch (InputMismatchException e) {
                            System.out.println("id прибора представляет собой целое число. Прибор не добавлен");
                        } catch (PowerException e) {
                            System.out.println("Прибор не может быть добавлен из-за нехватки мощности комнаты");
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка ввода");
                        }
                        break;
                    case 4: // Удалить прибор
                        try {
                            sUsingMethods.deleteUnit(inputInt("существующий ID прибора"));
                        } catch (InputMismatchException e) {
                            System.out.println("id прибора представляет собой целое число. Прибор не удален из комнаты");
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка ввода");
                        }
                        break;
                    case 5: // Включить прибор
                        try {
                            sUsingMethods.powerOnUnit(inputInt("существующий ID прибора"));
                        } catch (InputMismatchException e) {
                            System.out.println("id прибора представляет собой целое число. Прибор не удален из комнаты");
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка ввода");
                        }
                        break;
                    case 6: // Выключить прибор
                        try {
                            sUsingMethods.powerOffUnit(inputInt("существующий ID прибора"));
                        } catch (InputMismatchException e) {
                            System.out.println("id прибора представляет собой целое число. Прибор не удален из комнаты");
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка ввода");
                        }
                        break;
                    case 7: // Показать все приборы
                        try {
                            sUsingMethods.printAllUnits();
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка");
                        }
                        break;
                    case 8: // Показать отсортированные включенные приборы (в порядке увеличения используемой мощности)
                        try {
                            sUsingMethods.printAllSortedUnits();
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка");
                        }
                        break;
                    case 9: // Показать всю используемую можность
                        try {
                            sUsingMethods.showActualPower();
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка");
                        }
                        break;
                    case 10: // Найти прибор по имени
                        try {
                            sUsingMethods.findUnit(inputString("название прибора или его часть"));
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка");
                        }
                        break;
                    case 11: //  Найти прибор по установленным значениям мощности
                        try {
                            sUsingMethods.findUnitPower(inputInt("минимальную мощность"),
                                    inputInt("максимальную мощность"));
                        } catch (InputMismatchException e) {
                            System.out.println("Мощность прибора представляет собой целое число. Приборы не найдены");
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка ввода");
                        }
                        break;

                    case 0: // Выйти
                        try {
                            runWhile = false;
                        } catch (Exception e) {
                            System.out.println("Неизвестная ошибка выхода");
                        }
                }
            } catch (Exception e) {
                System.out.println("Неизвестная ошибка ввода");
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
