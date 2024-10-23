package Lab6;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();

		for (int i = 0; i <= 100; i++)
			list.add(String.valueOf(i));

		System.out.println(list.get(100));
		System.out.println("Deleted: " + list.remove("2"));
		System.out.println(list);
		System.out.println("Deleted: " + list.removeByIndex(99));
		System.out.println(list);

		try {
			System.out.println(list.get(152));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

}

interface IMyList<T> {
	T get(int index);

	void add(T data);

	void add(T data, int index);

	boolean remove(T data);

	boolean removeByIndex(int index);

	boolean equals(MyArrayList another);

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
	public void add(T data, int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("Index: " + index + ", but Size: " + size);
		}

		if (size == capacity) {
			grow();
		}

		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}

		elementData[index] = data;

		size++;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index: " + index + ",but Size: " + size);
		}

		return (T) elementData[index];
	}

	@Override
	public boolean remove(T data) {
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(data)) {
				removeByIndex(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index: " + index + ", but Size: " + size);
		}

		// Сдвигаем элементы влево, начиная с удаляемого индекса
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}

		// Очищаем последний элемент
		elementData[--size] = null;
		return true;
	}

	@Override
	public boolean equals(MyArrayList another) {
		if (this == another)
			return true;
		if (!(another instanceof MyArrayList))
			return false;

		if (size != another.size) {
			return false;
		}

		for (int i = 0; i < size; i++) {
			if (!elementData[i].equals(another.elementData[i])) {
				return false;
			}
		}

		return true;
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
