public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean manSex = true;
        if (!manSex) {
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

        String name = "ike";
        char firstLetterName = name.charAt(0);
        if (firstLetterName == 'M') {
            System.out.println("Имя начинается на букву M");
        } else if (firstLetterName == 'I') {
            System.out.println("Имя начинается на букву I");
        } else {
            System.out.println("Имя начинается не на буквы M и I");
        }
        System.out.println("\n2. Поиск большего числа");
        int a = 8;
        int b = 4;
        if (a > b) {
            System.out.println("Число " + a + " больше числа " + b);
        } else if (a == b) {
            System.out.println("Числа равны");
        }

        System.out.println("\n3. Проверка числа");
        int number = - 31;
        if (number == 0) {
            System.out.println("Число является нулём");
            return;
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
        int f = 165;
        int g = 165;
        if (f / 100 != g / 100 && ((f / 10) % 10 != (g / 10) % 10) && f % 10 != g % 10) {
            System.out.println("Нет равных цифр в разрядах");
            return;
        } else {
            System.out.println("Исходные числа: " + f + " " + g);
            if (f / 100 == g / 100) {
                System.out.println("Одинаковые цифры:" + f / 100 + "\nНомер разряда: 3");
            }
            if ((f / 10) % 10 == (g / 10) % 10) {
                System.out.println("Одинаковые цифры:" + ((f / 10) % 10) + "\nНомер разряда: 2");
            }
            if (f % 10 == g % 10) {
                System.out.println("Одинаковые цифры:" + (f % 10) + "\nНомер разряда: 1");
            }
        }

        System.out.println("\n5. Определение символа по его коду");
        char k = '\u0031';
        if (Character.isLetter(k)) {
            if (Character.isUpperCase(k)) {
                System.out.println(k + " - большая буква");
            } else {
                System.out.println(k + " - маленькая буква");
            }
        } else if (Character.isDigit(k)) {
            System.out.println(k + " - цифра");
        } else {
            System.out.println(k + " - ни буква и ни цифра");
        }

        System.out.println("\n6. Подсчет начисленных банком %");
        double sumDeposit = 321123.59;
        double rate;
        if (sumDeposit < 100_000) {
            rate = (sumDeposit / 100) * 5;
            System.out.println(sumDeposit + "\n" + rate + "\n" + (sumDeposit + rate));
        } else if (sumDeposit > 100_000 && sumDeposit < 300_000) {
            rate = (sumDeposit / 100) * 7;
            System.out.println(sumDeposit + "\n" + rate + "\n" + (sumDeposit + rate));
        } else if (sumDeposit > 300_000) {
            rate = (sumDeposit / 100) * 10;
            System.out.println(sumDeposit + "\n" + rate + "\n" + (sumDeposit + rate));
        }

        System.out.println("\n7. Определение оценки по предметам");
        int markHistory = 59;
        int markProgramming = 92;
        int scoreHistory = 0;
        int scoreProgramming = 0;
        if (markHistory <= 60) {
            scoreHistory = 2;
        } else if (markHistory > 60 && markHistory < 73) {
            scoreHistory = 3;
        } else if (markHistory > 73 && markHistory < 91) {
            scoreHistory = 4;
        } else if (markHistory > 91) {
            scoreHistory = 5;
        }
        if (markProgramming <= 60) {
            scoreProgramming = 2;
        } else if (markProgramming > 60 && markProgramming < 73) {
            scoreProgramming = 3;
        } else if (markProgramming > 73 && markProgramming < 91) {
            scoreProgramming = 4;
        } else if (markProgramming > 91) {
            scoreProgramming = 5;
        }
        float averageScore = (scoreHistory + scoreProgramming) / 2;
        System.out.println("Средний балл по предметам: " + averageScore);
        float averagePercent = (markHistory + markProgramming) / 2;
        System.out.println("Средний % по предметам: " + averagePercent);

        System.out.println("\n8. Расчет годовой прибыли");
        double profitMonth = 13025.233;
        double rentRoom = 5123.018;
        double costProduction = 9001.729;
        if (profitMonth > (rentRoom + costProduction) && (profitMonth - (rentRoom + costProduction)) != 0) {
            System.out.println("Прибыль за год: + " + (profitMonth - (rentRoom + costProduction)) + " руб.");
        } else if (profitMonth < (rentRoom + costProduction)) {
            System.out.println("Прибыль за год: - " + (profitMonth - (rentRoom + costProduction)) + " руб.");
        }
    }
}