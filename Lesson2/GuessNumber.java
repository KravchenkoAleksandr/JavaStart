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
        thinkSecretNumber();
        while (true) {
            inputNumberPlayer(player1);
            if (isGuessed(player1)) {
                break;
            }
            inputNumberPlayer(player2);
            if (isGuessed(player2)) {
                break;
            }
        }
    }

    private void thinkSecretNumber() {
        secretNumber = random.nextInt(0, 11);
    }

    private void inputNumberPlayer(Player player) {
        System.out.println(player.getName() + " введите число");
        inputNumber = scanner.nextInt();
    }

    private boolean isGuessed(Player player) {
        if (inputNumber == secretNumber) {
            System.out.println(player.getName() + " отгадал число " + secretNumber + " победил!");
            return true;
        }
        System.out.print(inputNumber);
        System.out.println(inputNumber > secretNumber ? 
                " больше того, что загадал компьютер" :
                " меньше того, что загадал компьютер");
        return false;
    }
}

