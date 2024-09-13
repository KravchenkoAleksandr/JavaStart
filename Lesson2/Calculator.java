public class Calculator {
    private char sign;
    private double a;
    private double b;

    public Calculator(double a, double b, char sign) {
        this.a = a;
        this.b = b;
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double calculates(Calculator calculator) {
        double result = 1;
        switch (sign) {
            case '+':
                result = calculator.getA() + calculator.getB();
                break;
            case '-':
                result = calculator.getA() - calculator.getB();
                break;
            case '*':
                result = calculator.getA() * calculator.getB();
                break;
            case '/':
                result = calculator.getA() / calculator.getB();
                break;
            case '%':
                result = calculator.getA() % calculator.getB();
                break;
            case '^':
                result = pow(a, b);
                break;
            default:
                break;        
        }
        return result;
    }

    static double pow(double a, double b) {
        double m = b < 0 ? -b : b;
        double res = 1.0;
        while (m-- > 0) {
            res *= a;
        }
        return b < 0 ? 1.0 / res : res;
    }
}