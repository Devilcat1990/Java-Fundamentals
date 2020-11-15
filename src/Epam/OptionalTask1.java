package Epam;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask1 {
    public void menu(String[] argument) {
        Hello cls=new Hello();
        int[] value =makeValue();
        boolean exit = true;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("\nOPTIONAL TASK 1");
            System.out.println("1: Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
            System.out.println("2: Вывести числа в порядке возрастания (убывания) значений их длины.");
            System.out.println("3: Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.");
            System.out.println("4: Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.");
            System.out.println("5: Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.");
            System.out.println("6: Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.");
            System.out.println("7: Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.");
            System.out.println("8: Вернуться в Основное меню.\n");
            System.out.print("Пожалуйста сделайте выбор: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    cls.cls();
                    cls.otvet(choice);
                    task1(value);
                    break;
                case 2:
                    cls.cls();
                    cls.otvet(choice);
                    task2(value);
                    break;
                case 3:
                    cls.cls();
                    cls.otvet(choice);
                    task3(value);
                    break;
                case 4:
                    cls.cls();
                    cls.otvet(choice);
                    task4(value);
                    break;
                case 5:
                    cls.cls();
                    cls.otvet(choice);
                    task5(value);
                    break;
                case 6:
                    cls.cls();
                    cls.otvet(choice);
                    task6(value);
                    break;
                case 7:
                    cls.cls();
                    cls.otvet(choice);
                    task7(value);
                    break;
                case 8:
                    cls.cls();
                    exit = false;
                    break;
                default:
                    cls.cls();
                    System.out.println("Вы выбрали не существующий пункт меню!!");
            }
        } while (exit);
    }

    private void task1(int[] values)
    {
        listValues(values);
        int big=values[0];
        int small=values[0];
        int size=getSize(values[0]);;
        for (int i=0; i<values.length; i++)
        {
            if(size>getSize(values[i]))
            {size=getSize(values[i]);
                small=values[i];}
        }
        System.out.println("\nСамая маленькая длина числа ="+size+"\nЭто число ="+small);
        for (int i=0; i<values.length; i++)
        {
            if(size<getSize(values[i]))
            {size=getSize(values[i]);
                big=values[i];}
        }
        System.out.println("\nСамая большая длина числа ="+size+"\nЭто число ="+big);
    }
    private void task2(int[] values)
    {
        listValues(values);
        int rubbish=0;
        boolean Condition=true;
        while (Condition)
        {   Condition=false;
            for (int i=0; i< values.length-1; i++)
            {
                if (getSize(values[i])>getSize(values[i+1])){
                    Condition=true;
                    rubbish=values[i];
                    values[i]=values[i+1];
                    values[i+1]=rubbish;
                }
            }
        }
        System.out.print("\nОтсортированный массив по количеству цифр в числе от меньшего к большему: ");
        for (int i=0; i< values.length; i++)
        {
            System.out.print(values[i]+" ");
        }
        Condition=true;
        while (Condition)
        {   Condition=false;
            for (int i=0; i< values.length-1; i++)
            {
                if (getSize(values[i])<getSize(values[i+1])){
                    Condition=true;
                    rubbish=values[i];
                    values[i]=values[i+1];
                    values[i+1]=rubbish;
                }
            }
        }
        System.out.print("\nОтсортированный массив по количеству цифр в числе от большего к меньшему: ");
        for (int i=0; i< values.length; i++)
        {
            System.out.print(values[i]+" ");
        }
    }
    private void task3(int[] values) {
        listValues(values);
        int mediumSize = 0;
        for (int i = 0; i < values.length; i++) {
            mediumSize += getSize(values[i]);
        }
        mediumSize = mediumSize / values.length;
        System.out.println("Средняя длинна всех чисел: " + mediumSize);
        boolean eq = true;
        for (int i = 0; i < values.length; i++) {
            if (mediumSize == getSize(values[i])) {
                eq = false;
            } else {
                eq = true;
                i = values.length;
            }
        }
        if (eq == false) {
            System.out.println("Длинна всех чисел ОДИНАКОВА");
            for (int i = 0; i < values.length; i++) {
                System.out.println("Число: " + values[i] + " Его длинна: " + getSize(values[i]));
            }
        } else {
            int lowMedium = 0;
            int bigMedium = 0;
            for (int i = 0; i < values.length; i++) {
                if (getSize(values[i]) < mediumSize) {
                    lowMedium++;
                }
                if (getSize(values[i]) > mediumSize) {
                    bigMedium++;
                }
            }
            if (lowMedium == 0) {
                System.out.println("Вывод чисел длинна которых меньше средней длинны: Таких нет.");
            } else {
                System.out.println("Вывод чисел длинна которых меньше средней длинны:");
                for (int i = 0; i < values.length; i++) {
                    if (getSize(values[i]) < mediumSize) {
                        System.out.println("Число: " + values[i] + " Его длинна: " + getSize(values[i]));
                    }
                }
            }
            if (bigMedium == 0) {
                System.out.println("Вывод чисел длинна которых больше средней длинны: Таких нет.");
            } else {
                System.out.println("Вывод чисел длинна которых больше средней длинны:");
                for (int i = 0; i < values.length; i++) {
                    if (getSize(values[i]) > mediumSize) {
                        System.out.println("Число: " + values[i] + " Его длинна: " + getSize(values[i]));
                    }
                }
            }
        }
    }
    private void task4(int[] values)
    {
        listValues(values);
        int small=0;
        int big=0;
        int[] amountEq=new int[values.length];
        for (int i=0; i< values.length; i++)
        {
            amountEq[i]=equalit(Divider(values[i]));
        }
        for (int i=0; i<amountEq.length; i++)
        {
            if(small<amountEq[i]) {
                small = amountEq[i];
                big=i;
            }
        }
        System.out.print("\nЧисло в котором количество различных цифр минимально: "+values[big]);

    }
    private void task5(int[] values)
    {
        listValues(values);
        int evenAmount=0;
        int oddEvenAmount=0;
        for(int i=0; i< values.length; i++)
        {
            if(evenNumbers(Divider(values[i]))==true)
            {
                evenAmount++;
            }
            if((getSize(values[i])-evenAmountNumbers(Divider(values[i])))==evenAmountNumbers(Divider(values[i])))
            {
                oddEvenAmount++;
            }
        }
        System.out.println("Количество чисел содержащее только четные цифры: "+evenAmount);
        System.out.println("Количество чисел содержащее равное количество четных и нечетных цифр: "+oddEvenAmount);
    }
    private void task6(int[] values)
    {
        listValues(values);
        boolean trueCheck=true;
        for(int i=0; i< values.length; i++)
        {
            int[] a = Arrays.copyOf(Divider(values[i]), getSize(values[i]));
            for (int b=0; b<a.length-1; b++)
            {
                if (a[b]<a[b+1])
                {
                    trueCheck=true;
                }else
                {
                    trueCheck=false;
                    b=a.length;
                }
            }
            if (trueCheck==true)
            {
                System.out.println("\nЧисло в котором все цифры идут по возростанию: "+values[i]);
                i=values.length;
            }
        }
        if (trueCheck==false) {
            System.out.println("\nЧисел в котором все цифры идут по возростанию НЕТ ");
        }
    }
    private void task7(int[] values)
    {
        listValues(values);
        int small=0;
        int big=0;
        int[] amountEq=new int[values.length];
        for (int i=0; i< values.length; i++)
        {
            amountEq[i]=equalit(Divider(values[i]));
        }
        for (int i=0; i<amountEq.length; i++)
        {
            if(small==amountEq[i]) {
                small = amountEq[i];
                big=i;
                i=amountEq.length;
            }
        }
        System.out.print("\nЧисло в котором все цифры различны: "+values[big]);
    }
    private int[] makeValue() //МЕТОД ДЛЯ ВВОДА ЧИСЕЛ
    {
        System.out.println("OPTIONAL TASK");
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите количество чисел над которыми будут выполняться операции: ");
        int size=in.nextInt();
        System.out.print("\nВведите эти числа: ");
        int[] values=new int[size];
        for (int i=0; i<values.length; i++)
        {
            values[i]=in.nextInt();
        }
        return values;
    }
    private void listValues(int[] values) //МЕТОД ЛЯ ВЫВОДА ВВЕДЕННЫХ ЧИСЕЛ
    {
        System.out.print("\nКоличество чисел предоставленных для задания:"+values.length+"\nЧисла предоставленные для задания: ");
        for (int i=0; i<values.length; i++)
        {
            System.out.print(values[i]+" ");
        }
        System.out.println(" ");
    }
    public int getSize(int value)  //МЕТОД ВЫЧИСЛЕНИЯ ДЛИННЫ ЧИСЛА
    {
        int size = 0;
        int c = 1;
        boolean Condition = true;
        while (Condition) {
            if ((value / c) > 0) {
                size++;
                c = c * 10;
            } else {
                if (value == 0) {
                    size++;
                    Condition = false;
                } else {
                    Condition = false;
                }
            }
        }
        return size;
    }
    public int[] Divider(int value) {
        int[] f = new int[getSize(value)];
        int c = 1;

        if (getSize(value) > 1) {
            for (int i = 0; i < getSize(value) - 1; i++) {
                c *= 10;
            }
        }
        for (int i = 0; i < f.length; i++) {
            f[i] = (value / c) % 10;
            c = c / 10;
        }
        return f;
    }//МЕТОД ДЛЯ ДЕЛЕНИЯ ЧИСЛА НА ЦИФРЫ
    public int equalit(int[] f){
        int equality = 0;
        int rubbish = 0;
        for (int a=0; a< f.length; a++) {
            rubbish=0;
            for (int i = 0; i < f.length; i++) {
                if (f[a] == f[i])
                {
                    rubbish++;
                }

            }
            if (rubbish>1)
            {
                equality++;
            }
        }
        return  equality;
    } //МЕТОД ДЛЯ сравнения по количеству совпадений цифр в числе
    public boolean evenNumbers(int[] value)
    {
        boolean even=true;
        for (int i=0; i< value.length; i++)
        {
            if((value[i]%2)!=0){
                even=false;
            }
        }
        return even;
    } //МЕТОД ПРОВЕРКИ ВСЕХ ЦИФР НА ЧЕТНОСТЬ И ВОЗВРАЩЕНИЯ ИСТИНЫ ЕСЛИ КАЖДАЯ ЦИФРА ЧЕТНАЯ ВОЗВРАЩАЕТ true
    public int evenAmountNumbers(int[] value)//МЕТО
    {
        int even=0;
        for (int i=0; i< value.length; i++)
        {
            if((value[i]%2)==0){
                even++;
            }
        }
        return even;
    }


}

