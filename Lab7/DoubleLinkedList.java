package Lab7;

public class DoubleLinkedList<T> implements MyList<T> {
	private int size;
	private Node head;
	private Node tail;

	public DoubleLinkedList() {
		size = 0;
		head = tail = null;
	}

	public int getSize() {
		return this.size;
	}

	private class Node {
		T value;
		Node prev;
		Node next;

		public Node(T value, Node prev, Node next) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}

	public void push_back(T data) {
		size++;
		if (tail == null) {
			tail = new Node(data, null, null);
			head = tail;
			return;
		}
		Node temp = new Node(data, tail, null);
		tail.next = temp;
		tail = temp;
	}

	public void push_front(T data) {
		size++;
		if (tail == null) {
			tail = new Node(data, null, null);
			head = tail;
			return;
		}
		Node temp = new Node(data, null, head);
		head.prev = temp;
		head = temp;
	}

	public void pop_back() {
		if (size == 0)
			return;
		if (size == 1) {
			head = null;
			tail = head;
		}
		Node temp = tail;
		tail = tail.prev;
		temp = null;
	}

	// Front
	public void pop_front() {
		if (size == 0)
			return;
		size--;
		if (size == 0) {
			head = null;
			tail = null;
			return;
		}
		head = head.next;
		head.prev = null;
	}

	@Override
	public void add(T data) {
		push_back(data);
	}

	// Get
	@Override
	public T get(int index) {
		// // if index;
		// Node cur = (index < size / 2) ? head : tail;
		// // head -> cur.next;
		// // tail -> cur.prev;
		// return null;

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		Node cur = (index < size / 2) ? head : tail;
		if (cur == head) {
			for (int i = 0; i < index; i++) {
				cur = cur.next;
			}
		} else {
			// i = 2
			// i = 2 - 30
			for (int i = size - 1; i > index; i--) {
				cur = cur.prev;
			}
		}

		return cur.value;
	}

	// Add
	// cur.prev.next = newNode; // Устанавливаем ссылки
	// cur.prev = newNode;
	@Override
	public void add(T data, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		if (index == 0) {
			push_front(data);
		} else if (index == size) {
			push_back(data);
		} else {
			Node cur = head;
			for (int i = 0; i < index; i++) {
				cur = cur.next;
			}
			Node newNode = new Node(data, cur.prev, cur); // Создать новый узел
			cur.prev.next = newNode;
			cur.prev = newNode;
			size++;
		}
	}

	// Remove by index
	// cur.prev.next = cur.next;
	// cur.next.prev = cur.prev;
	@Override
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		if (index == 0) {
			pop_front();
		} else if (index == size - 1) {
			pop_back();
		} else {
			Node cur = head;
			for (int i = 0; i < index; i++) {
				cur = cur.next;
			}
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			size--;
		}
	}

	// Remove by data
	@Override
	public void remove(T data) {
		Node cur = head;
		while (cur != null) {
			if (cur.value.equals(data)) {
				if (cur == head) {
					pop_front();
				} else if (cur == tail) {
					pop_back();
				} else {
					cur.prev.next = cur.next;
					cur.next.prev = cur.prev;
					size--;
				}
				return;
			}
			cur = cur.next;
		}
	}

	// toString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null) {
			sb.append(current.value).append(" ");
			current = current.next;
		}
		return sb.toString().trim();
	}
}
