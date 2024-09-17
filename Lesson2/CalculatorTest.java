import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuation = "yes";
        while (continuation.equals("yes")) {
            int a;
            int b;
            char sign = ' ';
            System.out.println("Введите первое число: ");
            a = scanner.nextInt();
            System.out.println("Введите знак операции (+, -, *, /, ^, %): ");
            boolean choice = true;;
            do {
                sign = scanner.next().charAt(0);
                if (sign == '+' || sign == '-' || sign == '*' || 
                        sign == '/' || sign == '^' || sign == '%') {
                    break;
                } else {
                    System.out.println("Ошибка: операция '" + sign + "' не поддерживается");
                    System.out.println("Доступны следующие операции: +, -, *, /, ^, %");
                }
            } while (true);
            do {
                System.out.println("Введите второе число: ");
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
                continuation = scanner.next();
            } while (!continuation.equals("yes") && !continuation.equals("no")); 
        }
    }
}
