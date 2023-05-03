package com.company;

public class DoubleLinkedList extends LinkedList {
    LinkedList left;

    public DoubleLinkedList(int value, LinkedList right, LinkedList left) {
        super(value, right);
        this.left = left;
    }


}
