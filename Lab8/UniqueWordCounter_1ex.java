package Lab8;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWordCounter_1ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph of text:");
        String text = scanner.nextLine();

        scanner.close();

        String[] words = text.toLowerCase().split("\\W+");
        Set<String> uniqueWords = new TreeSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Total unique words: " + uniqueWords.size());
        System.out.println("Unique words in alphabetical order: " + uniqueWords);
    }
}
