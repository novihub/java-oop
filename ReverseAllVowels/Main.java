package ReverseAllVowels;

import java.util.Scanner;

public class Main {

    static String reverseVowels(String string) {
        StringBuilder vowels = new StringBuilder();
        // Собираем все гласные
        for (char c : string.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowels.append(c);
            }
        }
        // Переворачиваем гласные
        vowels.reverse();
        
        // Результат с перевернутыми гласными
        StringBuilder result = new StringBuilder();
        for (char c : string.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                result.append(vowels.charAt(0));
                vowels.deleteCharAt(0);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(reverseVowels(str));
    }
}
