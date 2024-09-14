public class Calculator {
    private char sign;
    private int a;
    private int b;

    public Calculator(int a, int b, char sign) {
        this.a = a;
        this.b = b;
        this.sign = sign;
    }

    public double calculates() {
        double result = 1;
        switch (sign) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            case '%':
                result = a % b;
                break;
            case '^':
                result = pow();
                break;
            default:
                break;        
        }
        return result;
    }

    private double pow() {
        double result = 1;
        int m = Math.abs(b);
        for (int i = 1; i <= m; i++) {
            result *= a;
        }
        return b >= 0 ? result : 1 / result ;
    }
}