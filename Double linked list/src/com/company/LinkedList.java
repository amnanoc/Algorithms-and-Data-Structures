package com.company;

public class LinkedList {
    Node head = null;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void addToFront(Node node) {
        //save the previous head
        Node temp = head;
        //set it to this new node
        this.head = node;
        //link this new node to
        //the previous elements
        head.setNext(temp);
    }

    public void removeNode(Node node) {
        //save the first element
        Node temp = this.head;
        //check if it was the first element
        if(node == head && head.getNext()!=null) {
            head = node.getNext();
            node.setNext(null);
            return;
        } else if (node==head) {
            head = null;
            return;
        }
        //move until we are one element before the element
        //we are looking for
        while(temp.getNext()!=null && temp.getNext()!=node) {
            temp = temp.getNext();
        }

        //now element A will point to element C
        //and element B will be removed
        temp.setNext(node.getNext());
        //unlink the element
        node.setNext(null);

    }

    // A complete working Java program
// to demonstrate deletion
// in singly linked list

        /* Given a key, deletes the first
           occurrence of key in
         * linked list */
        void deleteNode(Node key)
        {
            // Store head node
            Node temp = head, prev = null;

            // If head node itself holds the key to be deleted
            if (temp != null && temp == key) {
                head = temp.next; // Changed head
                return;
            }

            // Search for the key to be deleted, keep track of
            // the previous node as we need to change temp.next
            while (temp != null && temp != key) {
                prev = temp;
                temp = temp.next;
            }

            // If key was not present in linked list
            if (temp == null)
                return;

            // Unlink the node from linked list
            prev.next = temp.next;
        }


}
