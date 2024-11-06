package Lab8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfCharacters_2ex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String input = scanner.nextLine().replaceAll("\\s+", "").toLowerCase();

		scanner.close();

		Map<Character, Integer> frequencyMap = new HashMap<>();

		for (char ch : input.toCharArray()) {
			frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
		}

		frequencyMap.entrySet()
				.stream()
				.sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
				.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
	}
}
