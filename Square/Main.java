package Square;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();

		sc.close();

		for (int i = 0; i < size; i++) {
			System.out.print("* ");
		}
		System.out.println();

		for (int i = 0; i < size - 2; i++) {
			System.out.print("*");
			for (int j = 0; j < size - 2; j++) {
				System.out.print("  ");
			}
			System.out.print("*");
			System.out.println();
		}

		for (int i = 0; i < size; i++) {
			System.out.print("* ");
		}
		System.out.println();
	}	
}