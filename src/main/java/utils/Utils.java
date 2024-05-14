package utils;

import math.Function;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utils {
    public static String getMethodNameByItsNumber(int number) {
        switch (number - 1) {
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

    public static Function getFunctionByItsNumber(int number) {
        switch (number) {
            case 1: {
                return new Function.FunctionOne();
            }
            case 2: {
                return new Function.FunctionTwo();
            }
            case 3: {
                return new Function.FunctionThree();
            }
            case 4: {
                return new Function.FunctionFour();
            }
            case 5: {
                return new Function.FunctionFive();
            }
            default: {
                return null;
            }
        }
    }

    public static int getNextInt(Scanner input) {
        int num;
        try {
            num = input.nextInt();
            return num;
        } catch (InputMismatchException e) {
            String errmsg = "Введенная строка не является целым числом!";
            exit(errmsg, input, -1);
            return -1;
        } catch (NoSuchElementException | IllegalStateException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, -1);
            return -1;
        }
    }

    public static double getNextDouble(Scanner input) {
        double num;
        try {
            num = input.nextDouble();
            return num;
        } catch (InputMismatchException e) {
            String errmsg = "Введенная строка не является числом!";
            exit(errmsg, input, -1);
            return -1;
        } catch (NoSuchElementException | IllegalStateException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, -1);
            return -1;
        }
    }

    public static void exit(String msg, Scanner input, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        input.close();
        System.exit(exitCode);
    }

    public static void exit(String msg, int exitCode) {
        if (!(msg.trim().equals(""))) {
            System.out.println(msg);
        }
        System.exit(exitCode);
    }
}
