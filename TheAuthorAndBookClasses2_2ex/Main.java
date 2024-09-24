package TheAuthorAndBookClasses2_2ex;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// Declare and allocate an array of Authors
		Author[] authors = new Author[2];
		authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
		authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

		// Declare and allocate a Book instance
		Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
		System.out.println(javaDummy); // toString()
	}
}

class Author {
	private String name;
	private String email;
	private char gender;

	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
	}
}

class Book {
	private String name;
	private Author[] authors;
	private double price;
	private int qty = 0;

	public Book(String name, Author[] authors, double price) {
		this.name = name;
		this.authors = authors;
		this.price = price;
	}

	public Book(String name, Author[] authors, double price, int qty) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private int getQty() {
		return qty;
	}

	private void setQty() {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Book[name=" + name + ", authors=" + Arrays.toString(authors) + ", price=" + price + ", qty=" + qty + "]";
	}

	public String getAuthorNames() {
		String authorNames = "";
		for (Author author : authors) {
			authorNames += author.getName() + ", ";
		}
		return authorNames;
	}
}
