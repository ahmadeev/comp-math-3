package utils;

import exceptions.InvalidInputException;
import math.Function;

import java.util.Scanner;

import static utils.Utils.exit;
import static utils.Utils.getNextInt;

public class ConsoleUtils {

    public static int getObjectCode(Scanner input) {
        int objectCode;
        System.out.printf("""
                        Выберите функцию:
                        1. ( %s ),
                        2. ( %s ),
                        3. ( %s ),
                        4. ( %s ),
                        5. ( %s ).
                        \n""", new Function.FunctionOne(), new Function.FunctionTwo(), new Function.FunctionThree(), new Function.FunctionFour(), new Function.FunctionFive());
        System.out.print("Выберите номер функции: ");
        try {
            objectCode = getNextInt(input);
            System.out.println();
            if (!(objectCode == 1 | objectCode == 2 | objectCode == 3 | objectCode == 4 | objectCode == 5)) {
                throw new InvalidInputException("Номер функции выбран неверно!");
            }
            return objectCode;
        } catch (InvalidInputException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, -1);
            return -1;
        }
    }

    public static int getMethodNumber(Scanner input) {
        int methodNumber;
        System.out.println("""
                        Выберите метод вычисления интеграла:
                        1. Метод левых прямоугольников,
                        2. Метод правых прямоугольников,
                        3. Метод средних прямоугольников,
                        4. Метод трапеций,
                        5. Метод Симпсона.
                        """);
        System.out.print("Выберите номер метода: ");
        try {
            methodNumber = getNextInt(input);
            System.out.println();
            if (!(methodNumber == 1 | methodNumber == 2 | methodNumber == 3 | methodNumber == 4 | methodNumber == 5)) {
                throw new InvalidInputException("Номер метода выбран неверно!");
            }
            return methodNumber;
        } catch (InvalidInputException e) {
            String errmsg = e.getMessage();
            exit(errmsg, input, -1);
            return -1;
        }
    }
}
