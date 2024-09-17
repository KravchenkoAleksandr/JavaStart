import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private Player player1;
    private Player player2;
    private int inputNumber;
    private int secretNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        boolean isWin = false;
        while (!isWin) {
            thinkSecretNumber();
            do {
                inputNumberPlayer(player1);
                isWin = isGuessed(player1);
                if (!isWin) {
                    inputNumberPlayer(player2);
                    isWin = isGuessed(player2);
                }
            } while (!isWin);
        }
    }

    private int thinkSecretNumber() {
        return secretNumber = random.nextInt(1, 11);
    }

    private void inputNumberPlayer(Player player) {
        System.out.println(player.getName() + " введите число");
        inputNumber = scanner.nextInt();
    }

    private boolean isGuessed(Player player) {
        if (inputNumber == secretNumber) {
            System.out.println(player.getName() + " отгадал число " + secretNumber + " победил!");
            return true;
        } else if (inputNumber > secretNumber) {
            System.out.println(inputNumber + " больше того, что загадал компьютер");
            return false;
        } else if (inputNumber < secretNumber) {
            System.out.println(inputNumber + " меньше того, что загадал компьютер");
            return false;
        }
        return false;
    }
}
