public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");
        int startNumber = -10;
        int finishNumber = 21;
        int counterEvenNumber = 0;
        int counterUnevenNumber = 0;
        do {
                if (startNumber % 2 == 0) {
                    counterEvenNumber += startNumber;
                } else {
                    counterUnevenNumber += startNumber;
                }
                startNumber++;
        } while (startNumber <= finishNumber);
        System.out.println("В отрезке [-10, 21] сумма четных чисел = " + counterEvenNumber +
                ", а нечетных = " + counterUnevenNumber);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания");
        int a = 10;
        int b = 5;
        int c = -1;
        int minNumber = a < b && a < c ? a : (b < c ? b : c );
        int maxNumber = a > b && a > c ? a : (b > c ? b : c);
        for (int i = maxNumber; i >= minNumber; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int number = 1234;
        int s = 0;
        int sum = 0;
        while (number > 0) {
            s = number % 10;
            number /= 10;
            sum += s;
            System.out.print(s);
        }
        System.out.println("\n" + sum);
        
        System.out.println("\n4. Вывод чисел в несколько строк");
        for (int i = 1; i < 30; i++) {
            if (i % 2 != 0) {
                System.out.printf("%5d", i, i == 5 ? '\n' : "");
            }
        }
    
        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность");
        number = 3242592;
        int printNumber = number;
        int digit;
        int counter = 0;
        while (number > 0) {
            digit = number % 10;
            if ((digit - 2) == 0) {
                counter++;
            }
            number /= 10;
        }
        String checkEven;
        if (counter % 2 == 0) {
            checkEven = "четное";
        } else {
            checkEven = "нечетное";
        }
        System.out.printf("В %d %s (%d) количество двоек%n", printNumber, checkEven, counter);

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
        System.out.printf("%s%11s%16s", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i <= 122; i++) {
            if (i <= '0' && i % 2 != 0 || i >= 'a' && i % 2 == 0) {
                System.out.printf("%n  %-11d%-10c%s", i, i, Character.getName(i));
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
        int numberCopyOne = number / 1000;
        int numberCopyTwo = number % 1000;
        int sumDigitOne = 0;
        int sumDigitTwo = 0;
        while (numberCopyOne > 0) {
            sumDigitOne += numberCopyOne % 10;
            numberCopyOne /= 10;
            sumDigitTwo += numberCopyTwo % 10;
            numberCopyTwo /= 10;
        }
        if (sumDigitOne == sumDigitTwo) {
            System.out.println("Число " + number + " счастливое");
            System.out.println("Сумма цифр " + numberCopyOne + " = " + sumDigitOne);
            System.out.println("Сумма цифр " + numberCopyTwo + " = " + sumDigitTwo);
        } else {
            System.out.println("Число " + number + " несчастливое");
            System.out.println("Сумма цифр " + numberCopyOne + " = " + sumDigitOne);
            System.out.println("Сумма цифр " + numberCopyTwo + " = " + sumDigitTwo);
        }

        System.out.println("\n10. Вывод таблицы умножения Пифагора");
        System.out.println("\tТАБЛИЦА ПИФАГОРА");
        System.out.print("  |");
        for (int i = 2; i <= 9 ; i++) {
            System.out.printf("%2d ",i);
        }
        System.out.print("\n__|");
        System.out.println("_______________________");
        for (int i = 2; i <= 9 ; i++) {
            System.out.print(i + " |");
        for (int j = 2; j <= 9 ; j++) {
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }

    }
}