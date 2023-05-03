package com.company;

public class Stack {
    LinkedList stack;

    public Stack(LinkedList stack) {
        this.stack = stack;
    }

    public void push(int newElement) {
         stack = new LinkedList(newElement,stack);
    }

    public int pop() {
        int firstElement = stack.getHead();
        stack = stack.getRight();
        return firstElement;
    }


}
