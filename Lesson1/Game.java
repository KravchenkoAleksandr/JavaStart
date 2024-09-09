public class Game {
    public static void main(String[] args) {
        int secretNumber = 14;
        int inputNumberPlayer = 4;

        do {
            if (secretNumber > inputNumberPlayer) {
                System.out.println(inputNumberPlayer + " меньше того, что загадал компьютер");
                inputNumberPlayer++;
            } else if (secretNumber < inputNumberPlayer) {
                System.out.println(inputNumberPlayer + " больше того, что загадал компьютер");
                inputNumberPlayer--;
            }
            if (secretNumber == inputNumberPlayer) {
                System.out.println("Вы угадали число " + secretNumber + " и победили!");
            }
        } while (secretNumber != inputNumberPlayer);
    }
}