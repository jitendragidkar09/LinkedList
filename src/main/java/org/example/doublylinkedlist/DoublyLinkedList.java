package org.example.doublylinkedlist;

public class DoublyLinkedList {
    Node head; //starting node of the list

    //End me element add karne ke liye method
    void add(int data){
        Node newNode=new Node(data);
        if (head==null){  //agar list empty hai
            head=newNode; //head pe newNode assign kardo
            return;
        }
        Node temp=head; //head se traversal start karo
        while(temp.next!=null){  //last node tak jao
            temp=temp.next;      //next node pe move karo
        }
        temp.next=newNode;  //last node ke next me new Node
        newNode.prev=temp;  //new node ka previous last node
    }

    //Middle me element insert karne ka method
    void insertAtMiddle(int data){
        Node newNode=new Node(data);
        if(head==null){  //agar list empty hai
            head=newNode; //head me new node assign kardo
            return;
        }

        //Step 1 : List ka size calculate karo
        Node temp=head;  //head se start karo
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next; //next node pe move karo
        }

        int mid=size/2;   //middle index
        temp=head;

        //Step 2 : Middle ke ek node pehle tak traverse karo
        for(int i=0 ; i<mid-1 ; i++){
            temp=temp.next;
        }

        //Step 3 : Pointers update karo
        newNode.next=temp.next;  //new node ka next middle ke next pe point kare
        newNode.prev=temp; //new node ka previous middle pe point kare

        if (temp.next!=null){  //agar middle ke baad node hai
          temp.next.prev=newNode; //middle ke next element ka previous refrence newNode par point kare
        }
        temp.next=newNode;  //middle node ka next newNode pe point kare
    }


    //To insert element at specified index
    void insertAtIndex(int index,int data){
        Node newNode=new Node(data);

        //case 1 : agar list empty hai or index zero hai
        if(head==null && index==0){
            head=newNode;
            return;
        }

        //case 2 : agar index=0 (insert at beggining of head)
        if(index==0){
            newNode.next=head;  //newNode ka next current head
            head.prev=newNode; //current head ka previous new node
            head=newNode; //head update new node pe
            return;
        }
        Node temp=head;
        int i=0;
        // Traverse to the node **just before the specified index**
        while(i<index-1 && temp.next!=null){
            temp=temp.next;
            i++;
        }

        // Case 3: Agar index beyond current size, insert at end
        if(temp.next==null){
            temp.next=newNode;
            newNode.prev=temp;
            return;
        }

        //Steps : Pointers update
        newNode.next=temp.next; //New node ka next=temp ka next
        newNode.prev=temp; //new node ka previous temp
        temp.next.prev=newNode; //temp ke next node ka previous new node
        temp.next=newNode;  //temp ka next new node
    }

    //Print list forward
    void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //Print list backward
    void printListBackward(){
        Node temp=head;
        if(temp==null)return;

        //Last nod tak jao
        while(temp.next!=null){
            temp=temp.next;
        }
        //Backward print
        while(temp!=null){
            System.out.println(temp.data+"->");
            temp=temp.prev;
        }
        System.out.println("null");
    }

    // Reverse doubly linked list
    public void reverse() {
        Node curr = head;
        Node temp = null;

        // Swap next and prev for each node
        while (curr != null) {
            temp = curr.prev;       // store previous
            curr.prev = curr.next;  // swap prev and next
            curr.next = temp;       // assign old prev to next
            curr = curr.prev;       // move to next node (jo actually prev tha)
        }

        // After loop, temp is at new head ka previous
        if (temp != null) {
            head = temp.prev; // new head
        }
    }
}
