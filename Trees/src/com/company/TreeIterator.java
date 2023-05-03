package com.company;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node current;
    private Stack<BinaryTree.Node> stack = new Stack<>();

    public TreeIterator(BinaryTree.Node argRoot) {
        current = argRoot;
    }

    @Override
    public boolean hasNext() {
        return (!stack.isEmpty() || current != null);
    }

    @Override
    public Integer next() {

        while (current != null ) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        BinaryTree.Node node = current;
        current = current.right;

        return node.value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
