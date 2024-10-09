package RegistrationAuthorizationLab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int query;

		do {
			System.out.println("Choose the number:");
			System.out.println("1. Sign up");
			System.out.println("2. Sign in");
			System.out.println("0. Exit");
			query = sc.nextInt();
			sc.nextLine();

			if (query == 1) {
				System.out.println("Enter your name:");
				String name = sc.nextLine();
				System.out.println("Enter your password:");
				String password = sc.nextLine();

				if (name.isEmpty() || password.isEmpty()) {
					System.out.println("Name or password cannot be empty");
					continue;
				}

				try {
					SignUp(name, password);
					System.out.println("Registration successful");
				} catch (UserAlreadyExistsException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
				}

			} else if (query == 2) {
				System.out.println("Enter your name:");
				String name = sc.nextLine();
				System.out.println("Enter your password:");
				String password = sc.nextLine();

				if (name.isEmpty() || password.isEmpty()) {
					System.out.println("Name or password cannot be empty");
					continue;
				}

				try {
					LogIn(name, password);
					System.out.println("Login successful");
				} catch (NoSuchUserException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println("An error occurred: " + e.getMessage());
				}
			}

		} while (query != 0);

		sc.close();
	}

	private static final String PATH = "./sample.txt";

	private static void SignUp(String name, String password) throws Exception {
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] IdUserPass = line.split(" ");
				if (IdUserPass[1].equals(name)) {
					throw new UserAlreadyExistsException("User already exists");
				}
			}
		} catch (FileNotFoundException e) {
			// File not found, continue registration
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
			int id = getNextUserId();
			writer.write(id + " " + name + " " + password);
			writer.newLine();
		} catch (IOException e) {
			throw new Exception("Error while saving data");
		}
	}

	private static int getNextUserId() {
		int id = 1;

		try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] IdUserPass = line.split(" ");
				id = Math.max(id, Integer.parseInt(IdUserPass[0]) + 1);
			}
		} catch (IOException e) {
			// id by default equals 1
		}

		return id;
	}

	private static void LogIn(String name, String password) throws NoSuchUserException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] IdUserPass = line.split(" ");
				if (IdUserPass[1].equals(name) && IdUserPass[2].equals(password)) {
					return;
				}
			}
		} catch (FileNotFoundException e) {
			throw new NoSuchUserException("Users not found");
		}

		throw new NoSuchUserException("Invalid username or password");
	}

}

class NoSuchUserException extends RuntimeException {
	public NoSuchUserException() {
		super();
	}

	public NoSuchUserException(String message) {
		super(message);
	}

	public NoSuchUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchUserException(Throwable cause) {
		super(cause);
	}
}

class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException() {
		super();
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
