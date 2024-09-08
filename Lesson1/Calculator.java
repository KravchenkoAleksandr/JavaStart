public class Calculator {
    public static void main(String [] args) {
        int digit = 2;
        int number = 8;
        char sign = '^';
        if (sign == '+') {
            System.out.println(digit + " " + sign + " " + number + " = " + (digit + number));
        } else if (sign == '-') {
            System.out.println(digit + " " + sign + " " + number + " = " + (digit - number));
        } else if (sign == '*') {
            System.out.println(digit + " " + sign + " " + number + " = " + (digit * number));
        } else if (sign == '/') {
            System.out.println(digit + " " + sign + " " + number + " = " + (digit / number));
        } else if (sign == '%') {
            System.out.println(digit + " " + sign + " " + number + " = " + (digit % number));
        } else if (sign == '^') {
            int result = 1;
            for (int i = 1; i <= number; i++) {
                result = result * digit;
            }
            System.out.print(digit + " " + sign + " " + number + " = " + result);
        }
    }
}