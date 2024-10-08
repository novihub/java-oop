package LectureFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./sample.txt");

		Scanner scanner = new Scanner(file);
		scanner.close();

		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
}