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
        char maxNumberChar = 65_535;
        System.out.println("\n" + maxNumberChar);
        System.out.println(++maxNumberChar);
        System.out.println(--maxNumberChar);

        System.out.println("\n5. перестановка значений переменных");
        int a = 2;
        int b = 5;
        System.out.println("\nС помощью третьей переменной");
        System.out.println(String.format("Исходные значения переменных : a = %d, b = %d",a, b));
        int swap = a;
        a = b;
        b = swap;
        System.out.println(String.format("Новые значения переменных : a = %d, b = %d, swap = %d",
                a, b, swap));

        System.out.println("С помощью арифметических операций");
        swap = a + b;
        a = swap - a;
        b = swap - b;
        System.out.println(String.format("Новые значения переменных : a = %d, b = %d, swap = %d",
                a, b, swap));
        
        System.out.println("С помощью побитовой операции ^");
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(String.format("Новые значения переменных : a = %d, b = %d", a, b));

        System.out.println("\n6. Вывод символов и их кодов");
        char signDollar = '$';
        int codeSignDollar = signDollar;
        char signAsterisk = '*';
        int codeSignAsterisk = signAsterisk;
        char signAt = '@';
        int codeSignAt = signAt;
        char signVerticalBar = '\\';
        int codeSignVerticalBar = signVerticalBar;
        char signTilde = '~';
        int codeSignTilde = signTilde;
        System.out.println(codeSignDollar + " = " + signDollar);
        System.out.println(codeSignAsterisk +" = " + signVerticalBar);
        System.out.println(codeSignAt +" = " + signAt);
        System.out.println(codeSignVerticalBar +" = " + signAsterisk);
        System.out.println(codeSignTilde +" = " + signTilde);

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
        int time = 86399;
        int hh = (time / 60) / 60;
        int mm = (time / 60) % 60;
        int ss = mm % 60;
        System.out.println(hh + ":" + mm + ":" + ss);
    }
}