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

    //To find middle element of a singly linkedlist in a single pass
    public int findMiddle(){
        if(head==null){
            throw new IllegalStateException("List is Empty !");
        }
        Node slow=head;
        Node fast=head;

        //Move fast by two and slow by one
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    //Method to delete a Node
    //Delete at Beginning
    public void deleteAtBeginning(){
        if(head==null){
            System.out.println("List is Empty !");
            return;
        }
        head=head.next; //First node ko skip karke head ko next par le jao
    }

    //Delete at End
    public void deleteAtEnd(){
        if(head==null){
            System.out.println("List is Empty !");
            return;
        }
        if(head.next==null){ //sirf ek node hai
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null){ //second last tak jao
            temp=temp.next;
        }
        temp.next=null; //Last node hata do
    }

    //Delete at specified position
    public void deleteAtPosition(int index){
        if(head==null || index<0){
            System.out.println("List is empty or Index is invalid ");
            return;
        }
        if(index==0){
            deleteAtBeginning();
            return;
        }
        Node temp=head;
        for (int i = 0; temp!=null && i<index-1; i++) {
            temp=temp.next;
        }
        if(temp==null || temp.next==null){
            System.out.println("Index out of Range.");
            return;
        }
        temp.next=temp.next.next; //Node skip kardo
    }

    //Delete By Value
    public void deleteByValue(int value){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }
        if(head.data==value){ //Agar head hi delete karna hai
            head=head.next;
            return;
        }
        Node temp=head;
        while(temp.next!=null && temp.next.data!=value){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Value not found.");
            return;
        }
        temp.next=temp.next.next;  //Node skip kardo
    }

    //Reverse a linkedlist
    public void reverse(){
        Node prev=null;  //initially null
        Node curr=head; //start from head
        Node next; //to store next node

        while(curr != null){
            next=curr.next; //store next
            curr.next=prev; //reverse link
            prev=curr; //move prev ahead
            curr=next; //move curr ahead
        }
        head=prev;  //finally prev is the new head
    }
}
