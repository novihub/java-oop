package Hourglass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        sc.close();

        for (int i = 0; i < size; i++) {
            System.out.print("* ");
        }
        System.err.println();

        // Print the top half of the hourglass (decreasing triangle)
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }
            // Print stars and spaces
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j == 0 || j == 2 * i - 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Print the bottom half of the hourglass (increasing triangle)
        for (int i = 2; i <= size; i++) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }
            // Print stars and spaces
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j == 0 || j == 2 * i - 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < size; i++) {
            System.out.print("* ");
        }
        System.err.println();

    }
}
