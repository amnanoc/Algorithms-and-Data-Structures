package com.company;

public class DoubleLinkedList extends LinkedList {

    public DoubleLinkedList(Node head) {
        super(head);
    }

    @Override
    public void addToFront(Node node) {
        this.head.setPrevious(node);
        this.head.getPrevious().setNext(this.head);
        this.head = node;

    }

    @Override
    public void removeNode(Node node) {
        if(node==head && head.getNext()==null) {
            head = null;
            node.setNext(null);
            node.setPrevious(null);
            return;
        }

        if(node==head) {
            head = head.getNext();
            node.setNext(null);
            node.setPrevious(null);
            return;

        }
        //find the node before the
        //one we are removing
        Node nodeBefore = node.getPrevious();
        //find the node after the
        //one we are removing
        Node nodeAfter = node.getNext();
        //point the previous node
        //to the node after
        nodeBefore.setNext(node.getNext());
        //set the node after to
        //point to the node before
        //the one we are removing
        nodeAfter.setPrevious(nodeBefore);
        //unlink the node
        node.setPrevious(null);
        node.setNext(null);
    }

    void deleteNode(Node del)
    {

        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.previous = del.previous;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.previous != null) {
            del.previous.next = del.next;
        }

        // Finally, free the memory occupied by del

    }
}
