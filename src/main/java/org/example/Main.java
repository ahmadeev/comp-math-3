package org.example;

import math.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static math.Methods.*;
import static utils.ConsoleUtils.getMethodNumber;
import static utils.ConsoleUtils.getObjectCode;
import static utils.Utils.getFunctionByItsNumber;
import static utils.Utils.getNextDouble;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int objectNumber = getObjectCode(input);
        int methodNumber = getMethodNumber(input);

        Function function = getFunctionByItsNumber(objectNumber);
        int n = 4;
        double a = 0;
        double b = 0;
        double precision = 0;

        System.out.print("Введите нижнюю границу отрезка: ");
        a = getNextDouble(input);
        System.out.print("Введите верхнюю границу отрезка: ");
        b = getNextDouble(input);
        System.out.print("Введите точность вычисления: ");
        precision = getNextDouble(input);
        System.out.println();

        if (!(a == 0 && b == 0) && !isNull(function) && precision != 0) {
            HashSet<Double> breakpoints = getBreakpoints(function, n, a, b);

            if (breakpoints.size() == 0) {
                System.out.println(getAnyMethodLoop(methodNumber, precision, function, n, a, b));
            } else {
                System.out.println("Есть точка (точки) разрыва!\n");

                double breakpoint;
                ArrayList<Double> breakpointsArray = new ArrayList<>(breakpoints);
                if (breakpointsArray.size() == 1) {
                    breakpoint = breakpointsArray.get(0);

                    if (b - breakpoint > breakpoint - a) {
                        a = breakpoint + (breakpoint - a);
                    } else if ((b - breakpoint < breakpoint - a)) {
                        b = breakpoint - (b - breakpoint);
                    } else if (Math.abs(a) == Math.abs(b)) {
                        a = b;
                    }

                    if (a <= b) {
                        breakpoints.clear();
                        breakpoints = getBreakpoints(function, n, a, b);

                        if (breakpoints.size() == 0) {
                            System.out.println(getAnyMethodLoop(methodNumber, precision, function, n, a, b));
                        } else {
                            System.out.println("Точки разрыва сохраняются. Интеграл невозможно вычислить.\n");
                        }
                    }
                }

            }
        }
    }
}