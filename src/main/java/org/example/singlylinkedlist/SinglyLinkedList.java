package org.example.singlylinkedlist;

public class SinglyLinkedList {
    Node head; //starting node

    //Add element at end
    void add(int data){
        Node newNode=new Node(data);
        if(head==null){  //agar list empty ho
            head=newNode; //head ko new node banado
            return;       //aur exit (kuch karne ki jarurat nahi)
        }
        Node temp=head;  //traversal ke liye temp pointer head se start karega
        while (temp.next != null){  //last node tak jao
            temp=temp.next;  //temp ko next pe move karo
        }
        temp.next=newNode;  //last node ka next nayi node ko point karega
    }

    //Insert at specified index
    void insertAtIndex(int index,int data){
        Node newNode=new Node(data);
        if(index==0){  //Insert at beginning
            newNode.next=head; //newNode ka next current head ho jayega
            head=newNode;  //head update to newNode
            return;
        }
        if(head==null){
            head=newNode;
            return;
        }

        Node temp=head;  //temp pointer traversal start karega head se
        int i=0;

        while(i < index-1 && temp.next != null){
            temp=temp.next;   //temp ko next pe move karo
            i++;
        }

        //Insert New Node
        newNode.next=temp.next;  //newNode ka next= temp ka next
        temp.next=newNode; //temp ka next=newNode
    }

    //Print List
    void printList(){
        Node temp=head; //Start from head
        while(temp != null){   //jab tak temp null na ho
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
