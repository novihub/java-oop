package Lecture9;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.push_back(1);
		list.push_back(2);
		list.push_back(3);
		list.print(); // Should print 1, 2, 3
		list.reverse();
		list.print(); // Should print 3, 2, 1
		list.remove(2);
		list.print(); // Should print 3, 1
	}
}

class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void add(T data) {
		push_back(data);
	}

	public void remove(T data) {
		Node<T> current = head;
		Node<T> previous = null;
		while (current != null) {
			if (current.data.equals(data)) {
				if (previous == null) {
					head = current.next;
					if (head == null) { // List became empty
						tail = null;
					}
				} else {
					previous.next = current.next;
					if (previous.next == null) { // Removed last element
						tail = previous;
					}
				}
				size--;
				return;
			}
			previous = current;
			current = current.next;
		}
		throw new NoSuchElementException("Element not found: " + data);
	}

	public void print() {
		Node<T> current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public void reverse() {
		Node<T> current = head;
		Node<T> previous = null;
		Node<T> next = null;
		tail = head; // Set tail to the current head before reversing
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	public void push_back(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void push_front(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	// Other List methods would be implemented similarly...
}
