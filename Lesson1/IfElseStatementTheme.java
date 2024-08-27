public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean isMaleSex = true;
        if (!isMaleSex) {
            System.out.println("Женщина");
        } else {
            System.out.println("Мужчина");
        }

        int age = 19;
        if (age > 18) {
            System.out.println("Совершеннолетний");
        } else {
            System.out.println("Несовершеннолетний");
        }

        float height = 175;
        if (height < 1.8) {
            System.out.println("Рост меньше 180 сантиметров");
        } else {
            System.out.println("Рост больше 180 сантиметров");
        }

        String name = "Mike";
        char firstLetterName = name.charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("Имя начинается на букву M");
        } else if (firstLetterName == 'I') {
            System.out.println("Имя начинается на букву I");
        } else {
            System.out.println("Имя начинается не на буквы M и I");
        }

        System.out.println("\n3. Проверка числа");
        int number = 0;
        if (number == 0) {
            System.out.println("Число является нулём");
        } else {
            System.out.print(number + " является ");   
            if (number < 0) {
                System.out.print("отрицательным и ");
            } else {
                System.out.print(" положительным и ");
            }
            if (number % 2 == 0) {
                System.out.println("чётным");
            } else {
                System.out.println("нечётным");
            }
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах");
        int a = 165;
        int b = 465;
        int hundredsA = a / 100;
        int tensA = (a / 10) % 10;
        int onesA = a % 10;
        int hundredsB = b / 100;
        int tensB = (b / 10) % 10;
        int onesB = b % 10;
        if (hundredsA != hundredsB && tensA != tensB &&
                onesA != onesB) {
            System.out.println("Нет равных цифр в разрядах");
        } else {
            System.out.println("Исходные числа: " + a + " " + b);
            if (hundredsA == hundredsB) {
                System.out.println("Одинаковые цифры:" + hundredsA + "\nНомер разряда: 3");
            }
            if (tensA == tensB) {
                System.out.println("Одинаковые цифры:" + tensA + "\nНомер разряда: 2");
            }
            if (onesA == onesB) {
                System.out.println("Одинаковые цифры:" + onesA + "\nНомер разряда: 1");
            }
        }

        System.out.println("\n2. Поиск большего числа");
        a = 8;
        b = 4;
        if (a > b) {
            System.out.println("Число " + a + " больше числа " + b);
        } else if (a < b) {
            System.out.println("Число " + a + " меньше числа " + b);
        } else {
            System.out.println("Числа равны");
        }

        System.out.println("\n5. Определение символа по его коду");
        char codeSign = '\u0123';
        if (Character.isUpperCase(codeSign)) {
            System.out.println(codeSign + " - большая буква");
        } else if (Character.isLowerCase(codeSign)) {
            System.out.println(codeSign + " - маленькая буква");
        } else if (Character.isDigit(codeSign)) {
            System.out.println(codeSign + " - цифра");
        } else {
            System.out.println(codeSign + " - ни буква и ни цифра");
        }

        System.out.println("\n6. Подсчет начисленных банком %");
        double sumDeposit = 321123.59;
        double sumRate = (sumDeposit / 100) * 5;
        if (sumDeposit >= 100_000 && sumDeposit <= 300_000) {
            sumRate = (sumDeposit / 100) * 7;
        } else if (sumDeposit > 300_000) {
            sumRate = (sumDeposit / 100) * 10;
        }

        System.out.println("Сумма вклада: " + sumDeposit + 
            "\nСумма начисленного процента: " + sumRate +
            "\nИтоговая сумма с процентом: " + (sumDeposit + sumRate));

        System.out.println("\n7. Определение оценки по предметам");
        int markHistory = 59;
        int scoreHistory = 2;
        if (markHistory > 60 && markHistory <= 73) {
            scoreHistory = 3;
        } else if (markHistory > 73 && markHistory <= 91) {
            scoreHistory = 4;
        } else if (markHistory > 91) {
            scoreHistory = 5;
        }
        int markProgramming = 96;
        int scoreProgramming = 2;
        if (markProgramming > 60 && markProgramming <= 73) {
            scoreProgramming = 3;
        } else if (markProgramming > 73 && markProgramming <= 91) {
            scoreProgramming = 4;
        } else if (markProgramming > 91) {
            scoreProgramming = 5;
        }
        System.out.println("Оценка по истории: " + scoreHistory);
        System.out.println("Оценка по программированию: " + scoreProgramming);
        float averageScore = (scoreHistory + scoreProgramming) / 2.0f;
        System.out.println("Средний балл по предметам: " + averageScore);
        float averagePercent = (markHistory + markProgramming) / 2.0f;
        System.out.println("Средний % по предметам: " + averagePercent);
        System.out.println(averageScore);
        System.out.println(averagePercent);

        System.out.println("\n8. Расчет годовой прибыли");
        double salesMonth = 13025.233;
        double rentRoom = 5123.018;
        double costProduction = 9001.729;
        double profitYear = (salesMonth - (rentRoom + costProduction)) * 12;
        if (profitYear > 0) {
            System.out.println("Прибыль за год: +" + profitYear + " руб.");
        } else {
            System.out.println("Прибыль за год: " + profitYear + " руб.");
        }
    }
}        
