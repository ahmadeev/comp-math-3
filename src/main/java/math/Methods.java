package math;

public class Methods {

    public static void rectangles(Function function, double precision) {
        int n = 5;
        double a = 1;
        double b = 2;
        double h = (b - a) / n;

        double left = 0;
        for (int i = 1; i <= n; i++) {
            left += function.getFunctionValue(a + h  * (i - 1));
        }
        System.out.printf("Метод левых прямоугольников: %.4f\n", left * h);

        double right = 0;
        for (int i = 1; i <= n; i++) {
            right += function.getFunctionValue(a + h  * i);
        }
        System.out.printf("Метод правых прямоугольников: %.4f\n", right * h);

        double center = 0;
        for (int i = 1; i <= n; i++) {
            center += function.getFunctionValue(a + h  * i - h * 1 / 2);
        }
        System.out.printf("Метод средних прямоугольников: %.4f\n", center * h);
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
