public class Calculator {
    public static void main(String [] args) {
        int a = 2;
        int b = 8;
        char sign = '^';
        int result = 0;
        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '/') {
            result = a / b;
        } else if (sign == '%') {
            result = a % b;
        } else if (sign == '^') {
            result = 1;
            for (int i = 1; i <= b; i++) {
                result *= a;
            }
        }
        System.out.print(a + " " + sign + " " + b + " = " + result);
    }
}