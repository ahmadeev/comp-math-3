package org.example;

import math.Function;

import java.util.HashSet;

import static math.Methods.*;

public class Main {


    public static HashSet<Double> getPoints(Function function, int n, double a, double b) {
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

        return breakpoints;
    }

    public static void main(String[] args) {

        Function function = new Function.FunctionThree();
        double precision = 0.01;
        int methodNumber = 2;   //  0-4

        int n = 10;
        double a = 1;
        double b = 2;

        HashSet<Double> breakpoints = getPoints(function, n, a, b);

        if (breakpoints.size() == 0) {
            System.out.println(getAnyMethodLoop(methodNumber, precision, function, n, a, b));
        } else {
            for (double i : breakpoints) {
                if ( i >= a && i <= b ) {
                    System.out.println("Есть точка (точки) разрыва!");
                }
            }
        }


        //System.out.println(getPoints(function, n, a, b));
    }
}