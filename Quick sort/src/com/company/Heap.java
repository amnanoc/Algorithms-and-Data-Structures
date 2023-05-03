package com.company;

public class Heap {

    public class Node {
        public Integer key;
        public Node left, right;
        public int elementsInSubtree;
        public Node(Integer key) {
            this.key = key;
            this.left = this.right = null;
            this.elementsInSubtree = 0;
        }
        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key );
            if(right != null)
                right.print();
        }
    }

    Node root;


    public Heap() {
        root = null;
    }

    public int depth() {
        int depth = 1;
        Node temp = root;
        if(root!=null)
            depth++;
        while(temp!=null) {
            if(temp.left!=null || temp.right!=null)
                depth++;
            if(temp.left!=null)
                temp = temp.left;
            if(temp.right!=null)
                temp = temp.right;
            if(temp.right == null && temp.left == null)
                break;
        }
        return depth;
    }

    public void add(Node current, int key) {
        //empty tree
        if (root == null) {
            root = new Node(key);
            root.elementsInSubtree++;//make root count itself
            return;
        }
        //increase the size of the root for each added element
        current.elementsInSubtree++;
        //as u go down make sure u adjust the values
        if(current.key>key) {
            int store = current.key;
            current.key = key;
            key = store;
        }

        if(current.left == null)
            current.left = new Node(key);
        else if(current.right == null)
            current.right = new Node(key);
        else if(current.left.elementsInSubtree<=current.right.elementsInSubtree) {
            add(current.left,key);
        }

        else {
            add(current.right,key);
        }
    }
    public int remove() {
        if(root == null) return -1;
        if(root.elementsInSubtree == 1) {//only one element
            int store = root.key;
            root = null;
            return store;
        }
        int store = root.key;
        if(root.right==null) //empty right branch
            root = root.left;
        else if(root.left == null) //empty left branch
            root = root.right;
        else { //both branches have some elements
            fixHeap(root);
        }
        return store;
    }
    private void fixHeap(Node node) {
        if(node == null ) {
            return;
        } else {
            if(node.right!=null && node.right.key<=node.left.key) {
                node.elementsInSubtree--;
                node.key = node.right.key;
                if(node.right.right==null && node.right.left==null) {
                    node.right=null;
                }
                node = node.right;

            } else {
                node.key = node.left.key;
                if(node.left.left == null && node.left.right==null) {
                    node.left=null;
                }
                node = node.left;
            }
        }
        fixHeap(node);
    }

    public void print() {
        print("", this.root, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.key);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public void push(int increase) {
        root.key+=increase;
        int save = root.key;
        fixHeap(root);
        add(root,save);
    }

    public Integer lookup(Integer key) {
        Node temp = root;
        while (temp != null) {
            if (key > temp.key) //key bigger,going right
                temp = temp.right;
            else if (key < temp.key) //key smaller,going left
                temp = temp.left;
            else
                return temp.key; //the key found
        }
        return -1; //didn't find the value
    }
}
