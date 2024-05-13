package utils;

public class Utils {
    public static String getMethodNameByItsNumber(int number) {
        switch (number) {
            case 0: {
                return "Метод левых прямоугольников";
            }
            case 1: {
                return "Метод правых прямоугольников";
            }
            case 2: {
                return "Метод средних прямоугольников";
            }
            case 3: {
                return "Метод трапеций";
            }
            case 4: {
                return "Метод Симпсона";
            }
            default: {
                return "Выбранного метода не существует!";
            }
        }
    }
}
