package Lab7;

public interface MyList<T> {
	void add(T data);

	T get(int index);

	void add(T data, int index);

	void remove(int index);

	void remove(T data);
}

// remove 
// add
// get
// analysis by classes

/*
 * ArrayList:
 * + :
 *  Fast indexing
 * 	space complexity
 * -:
 * Slow deleting and adding 
 * 
 * LinkedList:
 * +: Fast deleting and adding from front
 * -: 
 * Slow deleting and adding from back O(n)
 * 
 * DoubleLinkedList:
 * +: Fast moving left right
 * 		Fast add and del
 * -: 
 * space complexity
 * 
 * 
 */