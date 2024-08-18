public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        float ram = 8.00f;
        System.out.println("Оперативная память: " + ram);
        int numberOfCore = 6;
        System.out.println("Количество ядер: " + numberOfCore);
        // 3 переменных, чтобы задействовать тип char
        char ssd1 = 's';
        char ssd2 = 's';
        char ssd3 = 'd';
        double ssd = 256.0;
        System.out.println("Память " + ssd1 + ssd2 + ssd3 + " = " + ssd);
    
        System.out.println("\n2. Расчёт стоимости товара со скидкой");
        float pricePen = 105.5f;
        float priceBook = 235.83f;
        float priceWithoutDiscount = pricePen + priceBook;
        float discountPrice = (priceWithoutDiscount / 100) * 11;
        System.out.println("Стоимость товаров без скидки = " + priceWithoutDiscount);
        System.out.println("Сумма скидки = " + discountPrice);
        System.out.println("Стоимость товаров со скидкой = " + (priceWithoutDiscount - discountPrice));

        System.out.println("\n3. Вывод слова JAVA\n");
        System.out.println("   J     a   v     v  a");
        System.out.println("   j    a a   v   v  a a");
        System.out.println("J  j   aaaaa   V V  aaaaa");
        System.out.println(" JJ   a     a   V  a     a");

        System.out.println("\n4. Вывод  min и max значений целых числовых типов");
        byte maxNumberByte = 127;
        System.out.println(maxNumberByte);
        System.out.println(++maxNumberByte);
        System.out.println(--maxNumberByte);
        short maxNumberShort = 32_767;
        System.out.println("\n" + maxNumberShort);
        System.out.println(++maxNumberShort);
        System.out.println(--maxNumberShort);
        int maxNumberInt = 2_147_483_647;
        System.out.println("\n" + maxNumberInt);
        System.out.println(++maxNumberInt);
        System.out.println(--maxNumberInt);
        long maxNumberLong = 9_223_372_036_854_775_807L;
        System.out.println("\n" + maxNumberLong);
        System.out.println(++maxNumberLong);
        System.out.println(--maxNumberLong);

        System.out.println("\n5. перестановка значений переменных");
        int a = 2;
        int b = 5;
        System.out.println("\nС помощью третьей переменной");
        System.out.println(String.format("\nИсходные значения переменных : a = %d, b = %d",a, b));
        int swap = a;
        a = b;
        b = swap;
        System.out.println(String.format("\nНовые значения переменных : a = %d, b = %d, swap = %d",
                a, b, swap));

        System.out.println("\nС помощью арифметических операций");
        swap = a + b;
        a = swap - a;
        b = swap - b;
        System.out.println(String.format("\nНовые значения переменных : a = %d, b = %d, swap = %d",
                a, b, swap));
        
        System.out.println("\nС помощью побитовой операции ^");
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(String.format("\nНовые значения переменных : a = %d, b = %d", a, b));

        System.out.println("\n6. Вывод символов и их кодов");
        char signDollar = '$';
        System.out.println("36  = " + signDollar);
        char signAsterisk = '*';
        System.out.println("42 = " + signAsterisk);
        char signAt = '@';
        System.out.println("64 = " + signAt);
        char signVerticalBar = '\\';
        System.out.println("124 = " + signVerticalBar);
        char signTilde = '~';
        System.out.println("126 = " + signTilde);

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
        int ss = 86399;
        int hh = (ss / 60) / 60;
        int mm = (ss / 60) % 60;
        int seconds1 = mm % 60;
        System.out.println(hh + ":" + mm + ":" + seconds1);
    }
}