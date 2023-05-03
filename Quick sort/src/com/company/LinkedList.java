package com.company;

public class LinkedList {
    Node head = null;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public LinkedList(LinkedList list) {
        head = list.head;
    }

    public void addToFront(Node node) {
        //save the previous head
        Node temp = head;
        //set it to this new node
        this.head = node;
        //link this new node to
        //the previous elements
        head.setNext(temp);
    }

    public void removeNode(Node node) {
        //save the first element
        Node temp = this.head;
        //check if it was the first element
        if(node == head && head.getNext()!=null) {
            head = node.getNext();
            node.setNext(null);
            return;
        } else if (node==head) {
            head = null;
            return;
        }
        //move until we are one element before the element
        //we are looking for
        while(temp.getNext()!=null && temp.getNext()!=node) {
            temp = temp.getNext();
        }

        //now element A will point to element C
        //and element B will be removed
        temp.setNext(node.getNext());
        //unlink the element
        node.setNext(null);

    }

    public LinkedList addList(LinkedList list) {
        Node temp = head;
        while(temp.next!=null)
            temp = temp.next;

        temp.setNext(list.head);
        return list;
    }

    public void addToEnd (Node node) {
        Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }

        temp.next = node;
    }

}
