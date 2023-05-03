package com.company;

public class Stack {

    int [] stack = new int[4];  // array of size 4
    int index = -1; //pointer to the top of the stack
    int size = 0; //number of elements in the array currently

    public int pop() {
        if(index!=-1) {
            int temp = stack[index];
            stack[index] = 0;
            size--;
            index--;
            return temp;
        }
        else throw new IndexOutOfBoundsException("The stack is empty");
    }

    public void push(int element) {
        if(index!=stack.length-1) {
            size++;
            index++;
            stack[index] = element;
        }
        else throw new StackOverflowError("The stack is full");
    }
}
