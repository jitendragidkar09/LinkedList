package org.example.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        // Step 1: Add elements
        dll.add(10);
        dll.add(20);
        dll.add(30);
        dll.add(40);

        System.out.println("Original List:");
        dll.printList(); // 10 <-> 20 <-> 30 <-> 40 <-> null

        // Step 2: Insert element at index 2 (0-based index)
        dll.insertAtIndex(2, 25);

        System.out.println("After inserting 25 at index 2:");
        dll.printList(); // 10 <-> 20 <-> 25 <-> 30 <-> 40 <-> null

        // Step 3: Insert element at index 0 (beginning)
        dll.insertAtIndex(0, 5);

        System.out.println("After inserting 5 at index 0:");
        dll.printList(); // 5 <-> 10 <-> 20 <-> 25 <-> 30 <-> 40 <-> null

        // Step 4: Insert element at index beyond size (at end)
        dll.insertAtIndex(10, 50);

        System.out.println("After inserting 50 at index 10 (end):");
        dll.printList(); // 5 <-> 10 <-> 20 <-> 25 <-> 30 <-> 40 <-> 50 <-> null
    }
}
