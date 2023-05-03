package com.company;

public class HeapLinked {
    LinkedList list = null;

    public void add(int element) {
        if(list == null)
            list = new LinkedList(new Node(element,null));
        else
            list.addToFront(new Node(element,null));
    }

    public void remove() {
        Node temp = list.head;
        Node remove = list.head;
        int min = Integer.MAX_VALUE;

        while(temp.next!=null) {
            if(temp.value<min) {
                min = temp.value;
                remove = temp;
            }
            temp = temp.next;
        }

        list.removeNode(remove);
    }

    public void add2(int element) {
        if(list == null) {
            list = new LinkedList(new Node(element,null));
            return;
        }

        Node temp = list.head;
        boolean added = false;

        while(temp.next!=null) {
            if(temp.next.value >= element) {
                Node store = temp.next;
                temp.next = new Node(element,null);
                temp.next.next = store;
                added = true;
                break;
            }
            temp = temp.next;
        }

        if(!added)
            list.addToEnd(new Node(element,null));

    }

    public void remove2() {
        list.removeNode(list.head);
    }

}
