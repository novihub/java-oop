package lab4;

public class Main {
	public static void main(String[] args) {
		System.out.println("PI = " + MyMath.PI);
		System.out.println("E = " + MyMath.E);
		System.out.println("Factorial of 5 = " + MyMath.factorial(5));
		System.out.println("Square root of 2 = " + MyMath.sqrt(2));
		System.out.println("2^5 = " + MyMath.power(2, 5));
		System.out.println("sin(PI/2) = " + MyMath.sin(MyMath.PI / 2));
		System.out.println("cos(PI) = " + MyMath.cos(MyMath.PI));
		System.out.println("tan(PI/4) = " + MyMath.tan(MyMath.PI / 4));
		System.out.println("ctg(PI/4) = " + MyMath.ctg(MyMath.PI / 4));
	}
}

class MyMath {
	private MyMath() {
	}

	public static final double PI = find_pi();
	public static final double E = exp(1);

	// Calculate π using the Leibniz formula
	private static double find_pi() {
		double pi = 0;
		for (int i = 0; i < 1_000_000; i++) {
			pi += (i % 2 == 0 ? 1.0 : -1.0) / (2 * i + 1);
		}
		return pi * 4; // Multiply by 4 to get pi
	}

	// Calculate e^n using the Taylor series expansion
	public static double exp(int n) {
		double result = 1.0;
		double term = 1.0;
		for (int i = 1; i <= 20; i++) { // Calculate first 20 terms
			term *= (double) n / i;
			result += term;
		}
		return result;
	}

	// Factorial of n
	public static long factorial(int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
		}
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	// Square root using Newton's method
	public static double sqrt(double x) throws IllegalArgumentException {
		if (x < 0) {
			throw new IllegalArgumentException("Square root is not defined for negative numbers.");
		}
		double guess = x / 2.0;
		double epsilon = 1e-10;
		while (Math.abs(guess * guess - x) > epsilon) {
			guess = (guess + x / guess) / 2.0;
		}
		return guess;
	}

	// Power function a^n
	public static double power(double a, int n) {
		if (n < 0) {
			return 1.0 / power(a, -n);
		}
		double result = 1.0;
		for (int i = 0; i < n; i++) {
			result *= a;
		}
		return result;
	}

	// Sine function using Taylor series
	public static double sin(double x) {
		double result = 0.0;
		double term = x;
		for (int i = 1; i <= 1000; i++) { // First 1000 terms
			result += term;
			term *= -x * x / ((2 * i) * (2 * i + 1));
		}
		return result;
	}

	// Cosine function using Taylor series
	public static double cos(double x) {
		double result = 0.0;
		double term = 1.0;
		for (int i = 0; i <= 1000; i++) { // First 1000 terms
			result += term;
			term *= -x * x / ((2 * i + 1) * (2 * i + 2));
		}
		return result;
	}

	// Tangent function
	public static double tan(double x) throws ArithmeticException {
		double cosValue = cos(x);
		if (cosValue == 0) {
			throw new ArithmeticException("Tangent is undefined for this angle.");
		}
		return sin(x) / cosValue;
	}

	// Cotangent function
	public static double ctg(double x) throws ArithmeticException {
		double sinValue = sin(x);
		if (sinValue == 0) {
			throw new ArithmeticException("Cotangent is undefined for this angle.");
		}
		return cos(x) / sinValue;
	}
}
