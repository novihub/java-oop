package VowelCounter;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int count = 0;

		sc.close();


		String text = input.toLowerCase();

		for (char c: text.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count++;
			}

		}
		
		System.out.println("Number of vowels: " + count);
	}
}
