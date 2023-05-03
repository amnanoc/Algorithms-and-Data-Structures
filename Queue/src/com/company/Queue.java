package com.company;

public class Queue {
    Node head;
    Node tail;
    public class Node {
        public Integer value;
        public Node next;
        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public Queue() {
        head = null;
    }
    public void add(Integer item) {
        //empty queue
        if(head == null) {
            head = new Node(item, null);
            tail = head;  //save the last element
        } else { // already some elements
            tail.next = new Node(item, null); //add an element to the last
            tail = tail.next; //change what the last el is
        }
    }
    public Integer remove() {
        Node temp = head; //save old head
        head = head.next; //move it to the next el
        return head.value;
    }

    }