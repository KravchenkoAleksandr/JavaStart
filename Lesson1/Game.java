public class Game {
    public static void main(String[] args) {
        int secretNumber = 14;
        int playerNumber = 4;

        do {
            if (secretNumber > playerNumber) {
                System.out.println(playerNumber + " меньше того, что загадал компьютер");
                playerNumber++;
            } else if (secretNumber < playerNumber) {
                System.out.println(playerNumber + " больше того, что загадал компьютер");
                playerNumber--;
            }
        } while (secretNumber != playerNumber);
        System.out.println("Вы угадали число " + secretNumber + " и победили!");
    }
}