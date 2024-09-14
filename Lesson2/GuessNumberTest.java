import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Введите имя первого игрока");
        String namePlayer1 = scanner.nextLine();
        Player player1 = new Player(namePlayer1);
        System.out.println("Введите имя второго игрока");
        String namePlayer2 = scanner.nextLine();
        Player player2 = new Player(namePlayer2);
        GuessNumber guessNumber = new GuessNumber(player1, player2);

        guessNumber.gameplay();
    }
}