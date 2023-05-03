package com.company;
import java.util.Iterator;

public class TreeIteratorQueue implements Iterator<Integer> {
    Queue queue = new Queue();


    public TreeIteratorQueue(BinaryTree.Node root) {
        queue.add(root.key, root); //add first element to queue
    }

    @Override
    public boolean hasNext() {
        return (!this.queue.isEmpty());
    }

    @Override
    public Integer next() {
        if(queue.head.nodeRef.left!=null)
            queue.add(queue.head.nodeRef.left.key, queue.head.nodeRef.left);
        if(queue.head.nodeRef.right!=null)
            queue.add(queue.head.nodeRef.right.key, queue.head.nodeRef.right);

        Integer temp = queue.head.nodeRef.key;
        queue.remove();

        return temp;
    }
}
