package org.example.doublylinkedlist;

public class Node {
    int data; //value which will get store in the node
    Node next; //reference ka next node
    Node prev; //reference ka previous node

    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
