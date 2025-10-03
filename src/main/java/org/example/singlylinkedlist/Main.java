package org.example.singlylinkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // Add elements (append)
        sll.add(10); // list: 10
        sll.add(20); // list: 10 -> 20
        sll.add(30); // list: 10 -> 20 -> 30
        sll.add(40); // list: 10 -> 20 -> 30 -> 40

        System.out.println("Original List:");
        sll.printList();

        // Insert at index 2 (0-based) -> between 20 and 30
        sll.insertAtIndex(2, 25);

        System.out.println("After inserting 25 at index 2:");
        sll.printList();

        // Insert at beginning (index 0)
        sll.insertAtIndex(0, 5);

        System.out.println("After inserting 5 at index 0:");
        sll.printList();

        // Insert at index beyond size -> gets appended at end
        sll.insertAtIndex(10, 50);

        System.out.println("After inserting 50 at index 10 (append):");
        sll.printList();

        int middle = sll.findMiddle();
        System.out.println("Middle Element : "+middle);

        //Printing reverse linkedlist
        sll.reverse();
        sll.printList();
    }
}