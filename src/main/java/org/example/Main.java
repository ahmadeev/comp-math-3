package org.example;

import math.Function;

import static math.Methods.*;

public class Main {
    public static void main(String[] args) {

        Function function = new Function.FunctionThree();
        double precision = 0.01;

        int n = 5;
        double a = 0;
        double b = 2;
        int methodNumber = 2;   //  0-4

        System.out.println(getAnyMethodLoop(methodNumber, precision, function, n, a, b));
    }
}