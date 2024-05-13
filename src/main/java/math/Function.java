package math;

public abstract class Function {

    public abstract double getFunctionValue(double x);

    public static class FunctionOne extends Function {
        public double getFunctionValue(double x) {
            return x * x;
        }

        @Override
        public String toString() {
            return "x^2";
        }
    }

    public static class FunctionTwo {
        public double getFunctionValue(double x) {
            return x * x * x;
        }

        @Override
        public String toString() {
            return "x^3";
        }
    }
}
