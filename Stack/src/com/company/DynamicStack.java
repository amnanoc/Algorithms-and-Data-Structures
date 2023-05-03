package com.company;

public class DynamicStack extends Stack {
    // tracking how many consecutive pops are there and how filled out the stack is before shrink
    //shrink and expand methods
    int pops = 0;

    void expand() {
        int[] newStack = new int[2*stack.length];
        for(int i=0; i<size; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        System.out.println("Expanding to "+ stack.length);
    }

    void shrink() {
        int[] newStack = new int[size/2];
        for(int i=0; i<size; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        System.out.println("Shrinking to" +stack.length);

    }

    @Override
    public int pop() {
        pops++;
        if(pops==3 && size<stack.length/2) {
            pops=0;
            shrink();
        }
        return super.pop();
    }

    @Override
    public void push(int element) {
        pops = 0;
        if(size>= stack.length*0.75)
            expand();
        super.push(element);
    }
}
