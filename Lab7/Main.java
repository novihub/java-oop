package Lab7;

public class Main {
	public static void main(String[] args) {
		// Create an instance of MyLinkedList
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

		// Add elements to MyLinkedList
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.remove(3); // Remove by index
		myLinkedList.add(5);
		myLinkedList.remove((Integer) 5); // Remove by data

		// Display contents of MyLinkedList
		System.out.println("MyLinkedList:");
		for (int i = 0; i < myLinkedList.getSize(); i++) {
			System.out.print(myLinkedList.get(i) + " ");
		}
		System.out.println();

		// Create an instance of DoubleLinkedList
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

		// Add elements to DoubleLinkedList
		doubleLinkedList.add(10);
		doubleLinkedList.add(20);
		doubleLinkedList.add(30);
		doubleLinkedList.add(40);
		doubleLinkedList.add(50);

		// Display contents of DoubleLinkedList
		System.out.println("DoubleLinkedList:");
		for (int i = 0; i < doubleLinkedList.getSize(); i++) {
			System.out.print(doubleLinkedList.get(i) + " ");
		}
		System.out.println();
	}
}

/*
 * arrayList: back, get | front
 * linkedList: front | back, get
 * DoubleLinkedList: back, front | get, space complexity
 */