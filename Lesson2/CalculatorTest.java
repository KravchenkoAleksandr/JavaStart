import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        char sign = ' ';
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);
        String continuation = "yes";
        while (continuation.equals("yes")) {
            System.out.println("Введите первое число: ");
            a = scanner.nextInt();
            System.out.println("Введите знак операции (+, -, *, /, ^, %): ");
            do {
                sign = scanner.next().charAt(0);
                if (sign != '+' && sign != '-' && sign != '*' && sign != '/' && sign != '^' &&
                        sign != '%') {
                    System.out.println("Ошибка: операция '" + sign + "' не поддерживается");
                    System.out.println("Доступны следующие операции: +, -, *, /, ^, %");
                }
            } while (sign != '+' && sign != '-' && sign != '*' && sign != '/' && sign != '^' && sign != '%');
            System.out.println("Введите второе число: ");
            do {
                b = scanner.nextInt();
                if (sign == '/' && b == 0 || sign == '%' && b == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    System.out.println("Введите цифру или число не равное 0");
                }
            } while (b == 0);
            Calculator calculator = new Calculator(a, b, sign);
            System.out.print(a + " " + sign + " " + b + " = " + calculator.calculates());
            do {
            System.out.println("\nХотите продолжить вычисления? [yes/no]:");
            scanner.nextLine();
            continuation = scanner.nextLine();
            } while (!continuation.equals("yes") && !continuation.equals("no")); 
        }
    }
}
