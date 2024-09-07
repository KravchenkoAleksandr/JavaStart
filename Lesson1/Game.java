public class Game {
    public static void main(String[] args) {
        int secretNumber = 19;
        int inputNumberPlayer = 34;

        do {
            if ((secretNumber - inputNumberPlayer > 10) || (secretNumber - inputNumberPlayer > 5) && secretNumber > inputNumberPlayer) {
                System.out.println(inputNumberPlayer + " меньше того , что загадал компьютер");
                inputNumberPlayer += 5;
            } else if ((inputNumberPlayer - secretNumber > 10) || (inputNumberPlayer - secretNumber > 5) && secretNumber < inputNumberPlayer) {
                System.out.println(inputNumberPlayer + " больше того , что загадал компьютер");
                inputNumberPlayer -= 5;
            } else if (secretNumber - inputNumberPlayer <= 5 && secretNumber > inputNumberPlayer) {
                System.out.println(inputNumberPlayer + " меньше того , что загадал компьютер");
                inputNumberPlayer++;
            } else if (inputNumberPlayer - secretNumber <= 5 && secretNumber < inputNumberPlayer) {
                System.out.println(inputNumberPlayer + " больше того , что загадал компьютер");
                inputNumberPlayer--;
            }
            if (secretNumber == inputNumberPlayer) {
                System.out.println("Вы угадали число " + secretNumber + " и победили!");
            }
        } while (secretNumber != inputNumberPlayer);
    }
}