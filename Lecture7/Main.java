package Lecture7;

import java.math.BigInteger;

public class Main {

    public static BigInteger factorial(long n) {
        if (n == 0) {
            return BigInteger.ONE; // Возвращаем 1 для факториала 0
        }
        return BigInteger.valueOf(n).multiply(factorial(n - 1)); // Используем BigInteger
    }

    public static void main(String[] args) {
        System.out.println(factorial(100)); // Выводит факториал 100
    }
}
