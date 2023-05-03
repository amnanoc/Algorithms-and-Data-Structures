package com.company;

import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new TreeIteratorQueue(root);
    }

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        Node temp = root;
        Node parent = null;

        //empty tree
        if (root == null) {
            root = new Node(key,value);
            return;
        }

        //looking for a place to insert
        while (temp != null) {
            parent = temp;
            if (key < temp.key) {
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }

        //deciding whether to add it to
        //the left or to the right of the parent
        if (key < parent.key) {
            parent.left = new Node(key,value);
        }
        else {
            parent.right = new Node(key,value);
        }
    }

    public Integer lookup(Integer key) {
       Node temp = root;
        while (temp != null) {
            if (key > temp.key) //key bigger,going right
                temp = temp.right;
            else if (key < temp.key) //key smaller,going left
                temp = temp.left;
            else
                return temp.value; //the key found
        }
        return -1; //didn't find the value
    }
}
