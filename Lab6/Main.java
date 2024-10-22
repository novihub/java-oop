package Lab6;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		list.add("Hello");
		list.add("World");
		// list.add("Java", 1); // Adding "Java" at index 1
		System.out.println(list); // Output: [Hello, Java, World]

		list.remove("Java");
		System.out.println(list); // Output: [Hello, World]

		System.out.println(list.get(0)); // Output: Hello
		System.out.println(list.contains("World")); // Output: true
		System.out.println(list.contains("Java")); // Output: false
	}
}

interface IMyList<T> {
	T get(int index);

	void add(T data);

	void remove(T data);

	boolean contains(T data);
}

class MyArrayList<T> implements IMyList<T> {
	private int size;
	private int capacity;
	private Object[] elementData;

	public MyArrayList() {
		size = 0;
		capacity = 10;
		elementData = new Object[capacity];
	}

	@Override
	public String toString() {
		// Return only filled elements
		return Arrays.toString(Arrays.copyOf(elementData, size));
	}

	@Override
	public void add(T data) {
		if (size == capacity) {
			grow();
		}
		// Add data and increment size
		elementData[size++] = data;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return (T) elementData[index]; // Warning cuz of сasting to T
	}

	@Override
	public void remove(T data) {
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(data)) {
				// Shift elements left
				System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
				// Clear the last element
				elementData[--size] = null;
				return;
			}
		}
	}

	@Override
	public boolean contains(T data) {
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(data)) {
				return true;
			}
		}
		return false;
	}

	private void grow() {
		capacity = capacity * 2;
		elementData = Arrays.copyOf(elementData, capacity);
	}
}
