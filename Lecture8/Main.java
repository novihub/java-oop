package Lecture8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Пример ArrayList
        System.out.println("ArrayList:");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println(arrayList);
        arrayList.remove("Banana");
        System.out.println("After removal: " + arrayList);
        System.out.println();

        // Пример LinkedList
        System.out.println("LinkedList:");
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add("Mouse");
        System.out.println(linkedList);
        linkedList.set(1, "Rabbit");
        System.out.println("After update: " + linkedList);
        System.out.println();

        // Пример HashSet
        System.out.println("HashSet:");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Blue");
        hashSet.add("Red"); // Дубликат не будет добавлен
        System.out.println(hashSet);
        System.out.println();

        // Пример TreeSet
        System.out.println("TreeSet:");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Cherry");
        System.out.println(treeSet); // Элементы отсортированы
        System.out.println();

        // Пример HashMap
        System.out.println("HashMap:");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 28);
        System.out.println(hashMap);
        System.out.println("Bob's age: " + hashMap.get("Bob"));
        hashMap.remove("Charlie");
        System.out.println("After removal: " + hashMap);
        System.out.println();

        // Пример TreeMap
        System.out.println("TreeMap:");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Cathy", 22);
        treeMap.put("Alice", 25);
        treeMap.put("Bob", 30);
        System.out.println(treeMap); // Элементы отсортированы по ключу
        System.out.println();

        // Пример PriorityQueue
        System.out.println("PriorityQueue:");
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        System.out.println("Elements in priority order:");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " "); // Извлекает элементы в порядке приоритета
        }
        System.out.println();

        // Пример ArrayDeque
        System.out.println("ArrayDeque:");
        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("First");
        arrayDeque.add("Second");
        arrayDeque.addFirst("Zero"); // Добавление в начало
        System.out.println(arrayDeque);
        System.out.println("Removed from front: " + arrayDeque.removeFirst());
        System.out.println("ArrayDeque after removal: " + arrayDeque);
    }
}
