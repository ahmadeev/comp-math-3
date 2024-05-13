package math;

public class Methods {

    public static double rectangleMethodValue(int number, Function function, int n, double a, double b) {
        switch (number) {
            case 0: {
                return leftRectangle(function, n, a, b);
            }
            case 1: {
                return rightRectangle(function, n, a, b);
            }
            default: {
                return centerRectangle(function, n, a, b);
            }
        }
    }

    private static double leftRectangle(Function function, int n, double a, double b) {
        double h = (b - a) / n;
        double result = 0;

        for (int i = 1; i <= n; i++) {
            result += function.getFunctionValue(a + h  * (i - 1));
        }
        result *= h;
        System.out.printf("Метод левых прямоугольников: %.4f\n", result);

        return result;
    }

    public static double rightRectangle(Function function, int n, double a, double b) {
        double h = (b - a) / n;
        double result = 0;

        for (int i = 1; i <= n; i++) {
            result += function.getFunctionValue(a + h * i);
        }
        result *= h;
        System.out.printf("Метод правых прямоугольников: %.4f\n", result);

        return result;
    }

    public static double centerRectangle(Function function, int n, double a, double b) {
        double h = (b - a) / n;
        double result = 0;

        for (int i = 1; i <= n; i++) {
            result += function.getFunctionValue(a + h  * i - h * 1 / 2);
        }
        result *= h;
        System.out.printf("Метод средних прямоугольников: %.4f\n", result);

        return result;
    }

    public static void rectangleLoop(int methodNumber, double precision, Function function, int n, double a, double b) {
        double prevResult = rectangleMethodValue(methodNumber, function, n, a, b);
        n *= 2;
        double result = rectangleMethodValue(methodNumber, function, n, a, b);

        while ((result - prevResult) / (Math.pow(2, 2) - 1) >= precision) {
            prevResult = result;
            n *= 2;
            result = rectangleMethodValue(methodNumber, function, n, a, b);
        }
    }

    public static void trapeze(Function function, double precision) {
        int n = 10;
        double a = 1;
        double b = 2;
        double h = (b - a) / n;

        double result = (function.getFunctionValue(a) + function.getFunctionValue(b)) / 2;
        for (int i = 1; i < n; i++) {
            result += function.getFunctionValue(a + h * i);
        }
        System.out.printf("Метод трапеций: %.4f\n", result * h);
    }

    public static void simpson(Function function, double precision) {
        int n = 10;
        double a = 1;
        double b = 2;
        double h = (b - a) / n;

        double result = function.getFunctionValue(a) + function.getFunctionValue(b);
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                result += 4 * function.getFunctionValue(a + h * i);
            } else {
                result += 2 * function.getFunctionValue(a + h * i);
            }
        }
        System.out.printf("Метод Симпсона: %.4f\n", result * h / 3);
    }

}
