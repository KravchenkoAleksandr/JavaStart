package com.startjava.lesson_1.base;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");
        int startNumber = -10;
        int finishNumber = 21;
        int sumEvenNumber = 0;
        int sumUnevenNumber = 0;
        do {
            if (startNumber % 2 == 0) {
                sumEvenNumber += startNumber;
            } else {
                sumUnevenNumber += startNumber;
            }
            startNumber++;
        } while (startNumber <= finishNumber);
        System.out.println("В отрезке [ " + startNumber + ", " + finishNumber + " ] сумма четных чисел = " + sumEvenNumber +
                ", а нечетных = " + sumUnevenNumber);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");
        int a = 10;
        int b = 5;
        int c = -1;
        int min = a < b && a < c ? a : (b < c ? b : c);
        int max = a > b && a > c ? a : (b > c ? b : c);
        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int number = 1234;
        int reverse = 0;
        int sum = 0;
        while (number > 0) {
            reverse = number % 10;
            number /= 10;
            sum += reverse;
            System.out.print(reverse);
        }
        System.out.println("\n" + sum);
        
        System.out.println("\n4. Вывод чисел в несколько строк");
        int rows = 5;
        for (int i = 1; i < 24; ) {
            for (int j = 0; j < rows; j++) {
                if (i < 24) {
                    System.out.printf("%5d", i);
                } else {
                    System.out.printf("%5d", 0);
                }
                i += 2;
            }
            System.out.println();
        }
    
        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность");
        number = 32422225;
        int numberCopy = number;
        int counter = 0;
        while (number > 0) {
            if (number % 10 == 2) {
                counter++;
            }
            number /= 10;
        }
        String checkEven = "четное";
        if (counter % 2 != 0) {
            checkEven = "нечетное";
        }
        System.out.printf("В %d %s (%d) количество двоек%n", numberCopy, checkEven, counter);


        System.out.println("\n6. Вывод геометрических фигур");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();
        a = 5;
        b = 5;
        while (a > 0) {
            while (b > 0) {
                System.out.print('#');
                b--;
            }
            a--;
            b += a;
            System.out.println();

        }
        System.out.println();
        a = 0;
        b = 5;
        do {
            System.out.println('$');
            do {
                System.out.print('$');
                b--;
            } while (b == 3);
            a++;
        } while (a <= 3);

        System.out.println("\n7. Вывод ASCII-символов");
        System.out.printf("%s%11s%14s", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 122; i++) {
            if (i <= '0' && i % 2 != 0 || i >= 'a' && i % 2 == 0) {
                System.out.printf("%n  %-11d%-12c%s", i, i, Character.getName(i));
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        int checkNumber = 1234321;
        int copyNumber = checkNumber;
        int reverseNumber = 0;

        while (copyNumber > 0) {
            reverseNumber = reverseNumber * 10 + copyNumber % 10;
            copyNumber /= 10;
        }
        if (checkNumber == reverseNumber) {
            System.out.println("Число " + checkNumber + " палиндром");
        } else {
            System.out.println("Число " + checkNumber + "не палиндром");
        }

        System.out.println("\n9. Проверка, является ли число счастливым");
        number = 123321;
        int threeRightDigit = number % 1000;
        int threeLeftDigit = number / 1000;
        int threeLeftDigitCopy = number / 1000;
        int threeRightDigitCopy = number % 1000;
        int sumDigitOne = 0;
        int sumDigitTwo = 0;
        while (threeLeftDigitCopy > 0) {
            sumDigitOne += threeLeftDigitCopy % 10;
            threeLeftDigitCopy /= 10;
            sumDigitTwo += threeRightDigitCopy % 10;
            threeRightDigitCopy /= 10;
        }
        if (sumDigitOne == sumDigitTwo) {
            System.out.println("Число " + number + " счастливое");
        } else {
            System.out.println("Число " + number + " несчастливое");
        }
        System.out.println("Сумма цифр " + threeLeftDigit + " = " + sumDigitOne);
        System.out.println("Сумма цифр " + threeRightDigit + " = " + sumDigitTwo);

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        System.out.println("\tТАБЛИЦА ПИФАГОРА");
        System.out.print("  |");
        for (int i = 2; i <= 9; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.print("\n__|");
        System.out.println("_______________________");
        for (int i = 2; i <= 9; i++) {
            System.out.print(i + " |");
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }
    }
}