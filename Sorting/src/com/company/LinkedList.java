package com.company;

public class LinkedList {
    int value;
    LinkedList right;

    public LinkedList(int value, LinkedList right) {
        this.value = value;
        this.right = right;
    }

    public int getHead() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedList getRight() {
        return right;
    }

    public void setRight(LinkedList tail) {
        this.right = tail;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
        while (nxt.right != null) {
            nxt = nxt.right;
        }
        nxt.right = b;
    }

}
