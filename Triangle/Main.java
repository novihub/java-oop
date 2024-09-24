package Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); // Высота треугольника
        sc.close();

        for (int i = 1; i <= size; i++) {
            // Пробелы перед звездочками (Только из-за равностороннего тр.)
            for (int j = size; j > i; j--) {
                System.out.print(" ");
            }
            // Звездочки
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
