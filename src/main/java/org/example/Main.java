package org.example;

import math.Function;

import static math.Methods.*;

public class Main {
    public static void main(String[] args) {

        Function function = new Function.FunctionOne();
        double precision = 0.01;

        int n = 5;
        double a = 1;
        double b = 2;

        System.out.println("Для функции: " + function.toString());

        leftRectangleLoop(precision, function, n, a, b);

        //rectangles(function, precision);

        //trapeze(function, precision);

        //simpson(function, precision);

    }
}