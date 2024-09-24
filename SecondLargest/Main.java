package SecondLargest;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Введите кол-во чисел: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		sc.close();
		System.out.print("Введите " + n + " чисел: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int largest = 0;
		int secondLargest = 0;

		for (int num : arr) {
			if (num > largest) {
				secondLargest = largest;
				largest = num;
			} else if (num > secondLargest && num != largest) {
				secondLargest = num;
			}
		}

		System.out.println("2nd largest: " + secondLargest);
	}
}
