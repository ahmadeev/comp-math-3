package org.example;

import math.Function;

import java.util.HashSet;

import static math.Methods.*;

public class Main {

    public static void main(String[] args) {

        Function function = new Function.FunctionFour();
        double precision = 0.01;
        int methodNumber = 2;   //  0-4

        int n = 1;
        double a = -1;
        double b = 8;

        HashSet<Double> breakpoints = getBreakpoints(function, n, a, b);

        if (breakpoints.size() == 0) {
            System.out.println(getAnyMethodLoop(methodNumber, precision, function, n, a, b));
        } else {
            System.out.println("Есть точка (точки) разрыва!");
            if (a * b < 0) {
                if (Math.abs(a) > Math.abs(b)) b = -b;
                else a = -a;

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