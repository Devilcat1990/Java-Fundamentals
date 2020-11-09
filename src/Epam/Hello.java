package Epam;

import java.util.Scanner;


public class Hello {
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
    public static int menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nОСНОВНОЕ МЕНЮ\n");
        System.out.println("1: Перейти к заданиям из MAIN TASK");
        System.out.println("2: Перейти к заданиям из OPTIONAL TASK 1");
        System.out.println("3: Перейти к заданиям из OPTIONAL TASK 2");
        System.out.println("4: Выход.");
        System.out.print("Пожалуйста сделайте выбор: ");
        int choice = in.nextInt();
        System.out.println(" ");
        return choice;
    }

    public static void main(String[] args) {
        boolean exit = true;
        do {
            switch (menu()) {
                case 1:
                    cls();
                    MenuMainTask mainTask = new MenuMainTask();
                    mainTask.menu(args);
                    break;
                case 2:
                    cls();
                    OptionalTask1 optTask1 = new OptionalTask1();
                    optTask1.menu(args);
                    break;
                case 3:
                    cls();
                    break;
                case 4:
                    cls();
                    exit = false;
                    break;
                default:
                    System.out.println("Вы выбрали не существующий пункт меню!!");
            }
        } while (exit);
    }
}
