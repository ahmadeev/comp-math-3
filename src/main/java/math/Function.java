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

    public static class FunctionTwo extends Function {
        public double getFunctionValue(double x) {
            return x * x * x;
        }

        @Override
        public String toString() {
            return "x^3";
        }
    }

    public static class FunctionThree extends Function {
        public double getFunctionValue(double x) {
            return 1 / (x + 5);
        }

        @Override
        public String toString() {
            return "1 / (x + 5)";
        }
    }

    public static class FunctionFour extends Function {
        public double getFunctionValue(double x) {
            return 1 / (x * x);
        }

        @Override
        public String toString() {
            return "1 / x^2";
        }
    }

    public static class FunctionFive extends Function {
        public double getFunctionValue(double x) {
            return 1 / x;
        }

        @Override
        public String toString() {
            return "1 / x";
        }
    }
}
