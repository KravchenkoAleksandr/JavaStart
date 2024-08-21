public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");
        int finishNumber = 21;
        do {
            int counterEvenNumber = 0;
            int counterUnevenNumber = 0;
            for (int i = -10; i <= finishNumber; i++) {
                if (i % 2 == 0) {
                    counterEvenNumber += i;
                } else {
                    counterUnevenNumber += i;
                }
            }
            System.out.println("В отрезке [-10, 21] сумма четных чисел = " + counterEvenNumber + 
                    ", а нечетных = " + counterUnevenNumber);
        } while (finishNumber != 21);
    }
}