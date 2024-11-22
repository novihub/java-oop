package com.novikoff.calculator;

public class Calculate {
    public static final int ADD = 0;
    public static final int SUBTRACT = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVIDE = 3;
    public static final int MOD = 4;

    public double cal(String expression) {
        expression = expression.substring(0, expression.length() - 1);
        try {
            if (expression.contains("+")) {
                String[] split = expression.split("\\+");
                double a = Double.parseDouble(split[0]);
                double b = Double.parseDouble(split[1]);
                return operate(a, b, ADD);
            } else if (expression.contains("×")) {
                String[] split = expression.split("×");
                double a = Double.parseDouble(split[0]);
                double b = Double.parseDouble(split[1]);
                return operate(a, b, MULTIPLY);
            } else if (expression.contains("÷")) {
                String[] split = expression.split("÷");
                double a = Double.parseDouble(split[0]);
                double b = Double.parseDouble(split[1]);
                return operate(a, b, DIVIDE);
            } else if (expression.contains("%")) {
                String[] split = expression.split("%");
                double a = Double.parseDouble(split[0]);
                double b = Double.parseDouble(split[1]);
                return operate(a, b, MOD);
            } else if (expression.contains("-")) {
                String[] split = expression.split("-");
                double a = Double.parseDouble(split[0]);
                double b = Double.parseDouble(split[1]);
                return operate(a, b, SUBTRACT);
            } else {
                return Double.parseDouble(expression);
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return Double.NaN;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
            return Double.NaN;
        }
    }

    public double operate(double a, double b, int op) {
        return switch (op) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> {
                if (b == 0) {
                    throw new ArithmeticException("division by zero");
                }
                yield a / b;
            }
            case MOD -> {
                if (b == 0) {
                    throw new ArithmeticException("modulo by zero");
                }
                yield a % b;
            }
            default -> 0.0;
        };
    }
}
