import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя первого игрока");
        String namePlayer1 = scanner.nextLine();
        Player player1 = new Player(namePlayer1);
        System.out.println("Введите имя второго игрока");
        String namePlayer2 = scanner.nextLine();
        Player player2 = new Player(namePlayer2);
        GuessNumber guessNumber = new GuessNumber(player1, player2);

        String answer = "yes";
        while (answer.equals("yes")) {
            boolean isWin;
            int secretNumber = guessNumber.thinkingSecretNumber();
            do {
                int numberPlayer1 = guessNumber.inputNumberPlayer(player1);
                isWin = guessNumber.compareNumberPlayerWithSecretNumber(player1);
                if (!isWin) {
                    int numberPlayer2 = guessNumber.inputNumberPlayer(player2);
                    isWin = guessNumber.compareNumberPlayerWithSecretNumber(player2);
                }
            } while (!isWin);
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                answer = scanner.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        }
    }
}