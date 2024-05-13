package org.example;

import math.Function;

import static math.Methods.*;

public class Main {
    public static void main(String[] args) {

        Function function = new Function.FunctionOne();
        double precision = 0.01;

        System.out.println("Для функции: " + function.toString());

        rectangles(function, precision);

        trapeze(function, precision);

        simpson(function, precision);

    }
}