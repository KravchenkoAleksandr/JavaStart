public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");

        String nameManufacturer = "Lenovo";
        System.out.println("\n" + "Производитель: " + nameManufacturer);

        String nameComputer = "DESKTOP-BBSOG0L";
        System.out.println("\n" + "Имя компьютера: " + nameComputer);

        String processor = "AMD Ryzen 5 4600H with Radeon Graphics 3.00 GHz";
        System.out.println("\n" + "Процессор: " + processor);

        float ram = 8.00f;
        System.out.println("\n" + "Оперативная память: " + ram);

        String typeSystem = "64-разрядная операционная система, процессор x64";
        System.out.println("\n" + "тип системы: " + typeSystem);

        int numberOfCore = 6;
        System.out.println("\n" + "Количество ядер: " + numberOfCore);

        // 3 переменных, чтобы задействовать тип char
        char ssd1 = 's';

        char ssd2 = 's';

        char ssd3 = 'd';

        double ssd = 256.0;

        System.out.println("\n" + "Память " + ssd1 + ssd2 + ssd3 + " = " + ssd);

        System.out.println("\n2. Расчёт стоимости товара со скидкой");

        float pricePen = 105.5f;

        float priceBook = 235.83f;

        float discount = ((pricePen + priceBook) / 100) * 11;

        System.out.println("\nСтоимость товаров без скидки = " + (pricePen + priceBook));

        System.out.println("\nСумма скидки = " + discount);

        System.out.println("\nСтоимость товаров со скидкой = " + ((pricePen + priceBook) - discount));

        System.out.println("\n3. Вывод слова JAVA\n");

        System.out.println("   J     a   v     v  a");
        System.out.println("   j    a a   v   v  a a");
        System.out.println("J  j   aaaaa   V V  aaaaa");
        System.out.println(" JJ   a     a   V  a     a");

        System.out.println("\n4. Вывод  min и max значений целых числовых типов");

        byte b = 127;

        System.out.println("\n" + b);

        System.out.println("\n" + b++);

        System.out.println("\n" + b--);

        short s = 32_767;

        System.out.println("\n" + s);

        System.out.println("\n" + s++);

        System.out.println("\n" + s--);

        int i = 2_147_483_647;

        System.out.println("\n" + i);

        System.out.println("\n" + i++);

        System.out.println("\n" + i--);

        long l = 9_223_372_036_854_775_807L;

        System.out.println("\n" + l);

        System.out.println("\n" + l++);

        System.out.println("\n" + l--);

        float f = 3.4028235F;

        System.out.println("\n" + f);

        System.out.println("\n" + f++);

        System.out.println("\n" + f--);

        double d = 1.7976931348623157D;

        System.out.println("\n" + d);

        System.out.println("\n" + d++);

        System.out.println("\n" + d--);

        System.out.println("\n5. перестановка значений переменных");

        int one = 2;

        int two = 5;

        System.out.println("\nС помощью третьей переменной");

        System.out.println(String.format("\nИсходные значения переменных : one = %d, two = %d",
                one, two));

        int three = one;

        one = two;

        two = three;

        System.out.println(String.format("\nНовые значения переменных : one = %d, two = %d, three = %d",
                one, two, three));

        System.out.println("\nС помощью арифметических операций");

        three = one + two;

        one = three - one;

        two = three - two;

        System.out.println(String.format("\nНовые значения переменных : one = %d, two = %d, three = %d",
                one, two, three));

        // думаю как это сделать, не совсем понял
        System.out.println("\nС помощью побитовой операции ^");

        System.out.println("\n6. Вывод символов и их кодов");

        int signDollar = 36;

        System.out.println("\n" + signDollar + " = $");

        int signAsterisk = 42;

        System.out.println("\n" + signAsterisk + " = *");

        int signAt = 64;

        System.out.println("\n" + signAt + " = @");

        int signVerticalBar = 124;

        System.out.println("\n" + signVerticalBar + " = \\");

        int signTilde = 126;

        System.out.println("\n" + signTilde + " = ~");

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");

        char rightParenthesis = ')';

        char leftParenthesis = '(';

        char signSlash = '/';

        char signBackSlash = '\\';

        char signUnderscore = '_';

        System.out.println("     " + signSlash + "" + signBackSlash);

        System.out.println("    " + signSlash + "  " + signBackSlash);

        System.out.println("   " + signSlash + signUnderscore + leftParenthesis + " " +
                rightParenthesis + signBackSlash);

        System.out.println("  " + signSlash + "      " + signBackSlash);

        System.out.println(" " + signSlash + signUnderscore + signUnderscore + signUnderscore +
                signUnderscore + signSlash + signBackSlash + signUnderscore + signUnderscore +
                signBackSlash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа");

        int number = 543;

        int hundreds = number / 100;

        int tens = (number / 10) % 10;

        int units = number % 10;

        int sumCategoryNumbers = hundreds + tens + units;

        int productOfNumbers = hundreds * tens * units;

        System.out.println("\nЧисло " + number + " содержит: ");

        System.out.println("\n  сотен: " + hundreds);

        System.out.println("\n  десятков: " + tens);

        System.out.println("\n  единиц: " + units);

        System.out.println("\nСумма разрядов: " + sumCategoryNumbers);

        System.out.println("\nПроизведение разрядов: " + productOfNumbers);

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды");

        int seconds = 86399;

        int hours = (seconds / 60) / 60;

        int minutes = (seconds / 60) % 60;

        int seconds1 = minutes % 60;

        System.out.println("\n" + hours + ":" + minutes + ":" + seconds1);
    }
}