package utils;

import math.Function;

import static utils.Utils.getMethodNameByItsNumber;

public class Result {
    private Function function;
    private int methodNumber;
    private double value;
    private int n;
    private double precision;
    private double error;

    public Result(Function function, int methodNumber, double value, int n, double precision, double error) {
        this.function = function;
        this.methodNumber = methodNumber;
        this.value = value;
        this.n = n;
        this.precision = precision;
        this.error = error;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public int getMethodNumber() {
        return methodNumber;
    }

    public void setMethodNumber(int methodNumber) {
        this.methodNumber = methodNumber;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return  "Выбранная функция: ( " + function + " )\n" +
                "Выбранный метод: " + getMethodNameByItsNumber(methodNumber) + "\n" +
                "Вычисленное значение: " + value + "\n" +
                "Количество разбиений: " + n + "\n" +
                "Точность вычисления: " + precision + "\n" +
                "Погрешность: " + error + "\n";
    }
}
