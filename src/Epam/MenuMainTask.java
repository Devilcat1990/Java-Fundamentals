package Epam;

import java.util.Scanner;

public class MenuMainTask {
    public void menu(String[] argument) {
        Hello cls=new Hello();
        boolean exit = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("\nMAIN TASK\n");
            System.out.println("1: Приветствовать любого пользователя при вводе его имени через командную строку.");
            System.out.println("2: Отобразить в окне консоли аргументы командной строки в обратном порядке.");
            System.out.println("3: Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.");
            System.out.println("4: Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.");
            System.out.println("5: Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.");
            System.out.println("6: Вернуться в Основное меню.");
            System.out.print("Пожалуйста сделайте выбор: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    cls.cls();
                    cls.otvet(choice);
                    task1();
                    break;
                case 2:
                    cls.cls();
                    cls.otvet(choice);
                    task2(argument);
                    break;
                case 3:
                    cls.cls();
                    cls.otvet(choice);
                    task3();
                    break;
                case 4:
                    cls.cls();
                    cls.otvet(choice);
                    task4(argument);
                    break;
                case 5:
                    cls.cls();
                    cls.otvet(choice);
                    task5();
                    break;
                case 6:
                    cls.cls();
                    exit = false;
                    break;
                default:
                    cls.cls();
                    System.out.println("Вы выбрали не существующий пункт меню!!");
            }
        } while (exit);
    }

    private void task1() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nПожалуйста введите своё имя: ");
        String name = in.nextLine();
        System.out.println("Привет " + name);
    }

    private void task2(String[] argument) {
        if (argument.length == 0) {
            System.out.println("\nВы не ввели аргументы командной строки, перезапустити программу с аргументами!");
        } else {
            for (int i = argument.length - 1; i >= 0; i--) {
                System.out.print(argument[i] + " ");
            }
        }
    }

    private void task3() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nПожалуйста введите количество случайных чисел: ");
        int quantity = in.nextInt();
        System.out.println(" ");
        int[] quantityArray = new int[quantity];
        for (int i = 0; i < quantityArray.length; i++) {
            quantityArray[i] += ((int) (Math.random() * 100));
            System.out.print(quantityArray[i] + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < quantityArray.length; i++) {
            System.out.println(quantityArray[i]);
        }

    }

    private void task4(String[] argument) {
        int summa = 0;
        int summa2 = 1;
        if (argument.length == 0) {
            System.out.println("\nВы не ввели аргументы командной строки, перезапустити программу с аргументами!");
        } else {
            for (int i = 0; i < argument.length; i++) {
                summa += Integer.parseInt(argument[i]);
                summa2 *= Integer.parseInt(argument[i]);
            }
            System.out.println("Сумма аргументов = " + summa);
            System.out.println("Произведение аргументов = " + summa2);
        }
    }

    private void task5() {
        Scanner in = new Scanner(System.in);
        String[] monthArr = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь", "Январь"};
        boolean exit = true;
        while (exit) {
            System.out.print("\nПожалуйста введите номер месяца: ");
            int month = in.nextInt();
            if ((month < 1) || (month > 12)) {
                System.out.print("\nНекоректный ввод, попробуйте ещё раз!");
            } else {
                System.out.print("\nЭтому числу соответствует месяц: " + monthArr[month - 1]);
            }
            exit = false;
        }
    }
}
