public class Calculator {
    public static void main(String [] args) {
        int a = 2;
        int b = 8;
        char sign = '^';
        if (sign == '+') {
            System.out.println(a + " " + sign + " " + b + " = " + (a + b));
        } else if (sign == '-') {
            System.out.println(a + " " + sign + " " + b + " = " + (a - b));
        } else if (sign == '*') {
            System.out.println(a + " " + sign + " " + b + " = " + (a * b));
        } else if (sign == '/') {
            System.out.println(a + " " + sign + " " + b + " = " + (a / b));
        } else if (sign == '%') {
            System.out.println(a + " " + sign + " " + b + " = " + (a % b));
        } else if (sign == '^') {
            int result = 1;
            for (int i = 1; i <= b; i++) {
                result *= a;
            }
            System.out.print(a + " " + sign + " " + b + " = " + result);
        }
    }
}