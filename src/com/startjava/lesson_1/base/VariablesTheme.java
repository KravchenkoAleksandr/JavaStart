package com.startjava.lesson_1.base;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        float ram = 8.00f;
        System.out.println("Оперативная память: " + ram);
        int numberOfCore = 6;
        System.out.println("Количество ядер: " + numberOfCore);
        byte typeSystem = 64;
        System.out.println(typeSystem + " разрядная операционная система");
        double ssd = 256.0;
        System.out.println("Память " + ssd);
        char mainDisc = 'C';
        System.out.println("Основной диск: " + mainDisc);
        long frequencyCpu = 3000;
        System.out.println("Тактовая частота процессора " + frequencyCpu + "МГц");
        short numberProcessor = 1;
        System.out.println("Число процессоров: " + numberProcessor);
        boolean isOn = true;
        System.out.println("Компьютер включен?: " + numberProcessor);

        System.out.println("\n2. Расчёт стоимости товара со скидкой");
        float pricePen = 105.5f;
        float priceBook = 235.83f;
        float basePrice = pricePen + priceBook;
        float discountPrice = (basePrice / 100) * 11;
        System.out.println("Стоимость товаров без скидки = " + basePrice);
        System.out.println("Сумма скидки = " + discountPrice);
        System.out.println("Стоимость товаров со скидкой = " + (basePrice - discountPrice));

        System.out.println("\n3. Вывод слова JAVA\n");
        System.out.println("   J     a   v     v  a");
        System.out.println("   j    a a   v   v  a a");
        System.out.println("J  j   aaaaa   V V  aaaaa");
        System.out.println(" JJ   a     a   V  a     a");

        System.out.println("\n4. Вывод  min и max значений целых числовых типов");
        byte extremesByteValue = 127;
        System.out.println(extremesByteValue);
        System.out.println(++extremesByteValue);
        System.out.println(--extremesByteValue);
        short extremesShotrValue = 32_767;
        System.out.println("\n" + extremesShotrValue);
        System.out.println(++extremesShotrValue);
        System.out.println(--extremesShotrValue);
        int extremesIntValue = 2_147_483_647;
        System.out.println("\n" + extremesIntValue);
        System.out.println(++extremesIntValue);
        System.out.println(--extremesIntValue);
        long extremesLongValue = 9_223_372_036_854_775_807L;
        System.out.println("\n" + extremesLongValue);
        System.out.println(++extremesLongValue);
        System.out.println(--extremesLongValue);
        char extremesCharValue = 65_535;
        System.out.println("\n" + (int) extremesCharValue);
        System.out.println((int) ++extremesCharValue);
        System.out.println((int) --extremesCharValue);

        System.out.println("\n5. перестановка значений переменных");
        int a = 2;
        int b = 5;
        System.out.println("\nС помощью третьей переменной");
        System.out.printf("Исходные значения переменных : a = %d, b = %d", a, b);
        int swap = a;
        a = b;
        b = swap;
        System.out.printf("\nНовые значения переменных : a = %d, b = %d,",
                a, b);

        System.out.println("\n\nС помощью арифметических операций");
        a += b;
        b = a - b;
        a -= b;
        System.out.printf("Новые значения переменных : a = %d, b = %d ", a, b);
        
        System.out.println("\n\nС помощью побитовой операции ^");
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.printf("Новые значения переменных : a = %d, b = %d", a, b);

        System.out.println("\n\n6. Вывод символов и их кодов");
        char signDollar = '$';
        char signAsterisk = '*';
        char signAt = '@';
        char signVerticalBar = '\\';
        char signTilde = '~';
        System.out.println((int) signDollar + " = " + signDollar);
        System.out.println((int) signAsterisk + " = " + signVerticalBar);
        System.out.println((int) signAt + " = " + signAt);
        System.out.println((int) signVerticalBar + " = " + signAsterisk);
        System.out.println((int) signTilde + " = " + signTilde);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char rightParenthesis = ')';
        char leftParenthesis = '(';
        char slash = '/';
        char backslash = '\\';
        char underscore = '_';
        System.out.println("     " + slash + backslash);
        System.out.println("    " + slash + "  " + backslash);
        System.out.println("   " + slash + underscore + leftParenthesis + " " +
                rightParenthesis + backslash);
        System.out.println("  " + slash + "      " + backslash);
        System.out.println(" " + slash + underscore + underscore + underscore + underscore +
                slash + backslash + underscore + underscore + backslash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа");
        int number = 543;
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;
        int sumDigits = hundreds + tens + ones;
        int productDigits = hundreds * tens * ones;
        System.out.println("Число " + number + " содержит: ");
        System.out.println("  сотен: " + hundreds);
        System.out.println("  десятков: " + tens);
        System.out.println("  единиц: " + ones);
        System.out.println("Сумма разрядов: " + sumDigits);
        System.out.println("Произведение разрядов: " + productDigits);

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды");
        int time = 86397;
        int hh = time / 3600;
        int mm = (time % 3600) / 60;
        int ss = time % 60;
        System.out.println(hh + ":" + mm + ":" + ss);
    }
}