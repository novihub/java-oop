package Lab8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WordLengthStatistics_5ex {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

		Map<Integer, Long> wordLengthCount = words.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));

		Optional<String> shortestWord = words.stream().min(Comparator.comparingInt(String::length));
		Optional<String> longestWord = words.stream().max(Comparator.comparingInt(String::length));

		double averageWordLength = words.stream()
				.mapToInt(String::length)
				.average()
				.orElse(0.0);

		System.out.println("Word length count: " + wordLengthCount);
		System.out.println("Shortest word: " + shortestWord.orElse("N/A"));
		System.out.println("Longest word: " + longestWord.orElse("N/A"));
		System.out.println("Average word length: " + averageWordLength);
	}
}
