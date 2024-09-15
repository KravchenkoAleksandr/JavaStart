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

    private int thinkingSecretNumber() {
        return secretNumber = random.nextInt(1, 10);
    }

    private int inputNumberPlayer(Player player) {
        System.out.println(player.getName() + " введите число");
        return inputNumber = scanner.nextInt();
    }

    private boolean compareNumberPlayerWithSecretNumber(Player player) {
        if (inputNumber == secretNumber) {
            System.out.println(player.getName() + " победил!");
            return true;
        }
        return false;
    }

    public void startGame() {
        boolean isWin = false;
        while (!isWin) {
            thinkingSecretNumber();
            do {
                inputNumberPlayer(player1);
                isWin = compareNumberPlayerWithSecretNumber(player1);
                if (!isWin) {
                    inputNumberPlayer(player2);
                    isWin = compareNumberPlayerWithSecretNumber(player2);
                }
            } while (!isWin);
        }
    }
}
