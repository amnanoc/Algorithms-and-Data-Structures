package com.company;

public class Queue {
    Node head;
    Node tail;

    public class Node {
        public Integer value;
        public Node next;
        public BinaryTree.Node nodeRef;

        public Node(Integer value, Node next, BinaryTree.Node nodeRef) {
            this.value = value;
            this.next = next;
            this.nodeRef = nodeRef;
        }
    }
    public Queue() {
        head = tail = null;
    }
    public void add(Integer item, BinaryTree.Node nodeRef) {
        //empty queue
        if(head == null) {
            head = new Node(item, null, nodeRef);
            tail = head;  //save the last element
        } else { // already some elements
            tail.next = new Node(item, null,nodeRef); //add an element to the last
            tail = tail.next; //change what the last el is
        }
    }
    public Integer remove() {
        if(head == null) //empty
            return -1;
        else if(head == tail) { //last el
            Node temp = head;
            head = tail = null;
            return temp.value;
        }
        Node temp = head; //save old head
        head = head.next; //move it to the next el
        return temp.value;
    }

    public boolean isEmpty() {
        if(head == null)
            return true;
        return  false;
     }

    }