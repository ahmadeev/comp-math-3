package math;

import utils.Result;

import java.util.HashSet;

public class Methods {

    public static double getValueUsingMethod(int number, Function function, int n, double a, double b) {
        switch (number) {
            case 1: {
                return leftRectangle(function, n, a, b);
            }
            case 2: {
                return rightRectangle(function, n, a, b);
            }
            case 3: {
                return centerRectangle(function, n, a, b);
            }
            case 4: {
                return trapeze(function, n, a, b);
            }
            case 5: {
                return simpson(function, n, a, b);
            }
            default: {
                return 0;
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
        //System.out.printf("Метод левых прямоугольников: %.4f\n", result);

        return result;
    }

    public static double rightRectangle(Function function, int n, double a, double b) {
        double h = (b - a) / n;
        double result = 0;

        for (int i = 1; i <= n; i++) {
            result += function.getFunctionValue(a + h * i);
        }
        result *= h;
        //System.out.printf("Метод правых прямоугольников: %.4f\n", result);

        return result;
    }

    public static double centerRectangle(Function function, int n, double a, double b) {
        double h = (b - a) / n;
        double result = 0;

        for (int i = 1; i <= n; i++) {
            result += function.getFunctionValue(a + h  * i - h * 1 / 2);
        }
        result *= h;
        //System.out.printf("Метод средних прямоугольников: %.4f\n", result);

        return result;
    }

    public static double trapeze(Function function, int n, double a, double b) {
        double h = (b - a) / n;

        double result = (function.getFunctionValue(a) + function.getFunctionValue(b)) / 2;
        for (int i = 1; i < n; i++) {
            result += function.getFunctionValue(a + h * i);
        }
        result *= h;
        //System.out.printf("Метод трапеций: %.4f\n", result);

        return result;
    }

    public static double simpson(Function function, int n, double a, double b) {
        double h = (b - a) / n;

        double result = function.getFunctionValue(a) + function.getFunctionValue(b);
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                result += 4 * function.getFunctionValue(a + h * i);
            } else {
                result += 2 * function.getFunctionValue(a + h * i);
            }
        }
        result *= h / 3;
        //System.out.printf("Метод Симпсона: %.4f\n", result);

        return result;
    }

    public static Result getAnyMethodLoop(int methodNumber, double precision, Function function, int n, double a, double b) {
        double prevResult = getValueUsingMethod(methodNumber, function, n, a, b);
        n *= 2;
        double result = getValueUsingMethod(methodNumber, function, n, a, b);

        while ((result - prevResult) / (Math.pow(2, 2) - 1) >= precision) {
            prevResult = result;
            n *= 2;
            result = getValueUsingMethod(methodNumber, function, n, a, b);
        }

        return new Result(function, methodNumber, result, n, precision, Math.abs(result - prevResult));
    }

    public static HashSet<Double> getBreakpoints(Function function, int n, double a, double b) {
        HashSet<Double> breakpoints = new HashSet<>();
        double temp;

        try {
            temp = function.getFunctionValue(a);
            if (Double.isInfinite(temp)) breakpoints.add(a);
        } catch (ArithmeticException e) {
            breakpoints.add(a);
        }
        try {
            temp = function.getFunctionValue(b);
            if (Double.isInfinite(temp)) breakpoints.add(b);
        } catch (ArithmeticException e) {
            breakpoints.add(b);
        }
        try {
            temp = function.getFunctionValue((a + b) / 2);
            if (Double.isInfinite(temp)) breakpoints.add((a + b) / 2);
        } catch (ArithmeticException e) {
            breakpoints.add((a + b) / 2);
        }

        double h = (b - a) / n;

        for (int i = 1; i < n; i++) {
            double x = a + h * i;
            try {
                temp = function.getFunctionValue(x);
                if (Double.isInfinite(temp)) breakpoints.add(x);
            } catch (ArithmeticException e) {
                breakpoints.add(x);
            }
        }

        double step = 0.01;
        for (double i = 1; a + i * step <= b; i++) {
            double x = a + step * i;
            try {
                temp = function.getFunctionValue(x);
                if (Double.isInfinite(temp)) breakpoints.add(x);
            } catch (ArithmeticException e) {
                breakpoints.add(x);
            }
        }

        return breakpoints;
    }

}
