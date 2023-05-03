package com.company;

public class HeapArray {
    private int[] heap;
    private int k;
    private int size;

    public HeapArray(int size) {
        this.size = size;
        this.k = 0;
        heap = new int[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (i * 2) + 1;
    }

    private int right(int i) {
        return (i * 2) + 2;
    }

    private boolean leaf(int i) {
        if (right(i) >= size || left(i) >= size) {
            return true;
        }
        return false;
    }

    public void add(int element) {
        if (k >= size) { //no more space
            return;
        }
        heap[k] = element; //insert an element at position k
        int temp = k;

        //swap it into right position with its 'parents'
        while (heap[temp] < heap[parent(temp)]) {
            swap(temp, parent(temp));
            temp = parent(temp);
        }
        k++; //move the position for next element
    }

    // removes and returns the minimum element from the heap
    public int remove() {
        int temp = heap[0];
        heap[0] = heap[--k]; //place the last element on root and decrease the pointer

        fixHeap(0); //
        return temp;
    }

    // heapify the node at i
    private void fixHeap(int i) {
        if (!leaf(i)) {
            if (heap[i] > heap[left(i)] ||
                    heap[i] > heap[right(i)]) {
                if (heap[left(i)] < heap[right(i)]) {
                    swap(i, left(i));
                    fixHeap(left(i));
                } else {
                    swap(i, right(i));
                    fixHeap(right(i));
                }
            }
        }
    }

    // builds the min-heap using the minHeapify
    public void minHeap() {
        for (int i = (k - 1 / 2); i >= 1; i--) {
            fixHeap(i);
        }
    }

    // Function to print the contents of the heap
    public void printHeap() {
        for (int i = 0; i < (k / 2); i++) {
            System.out.print("Parent : " + heap[i]);
            if (left(i) < k)
                System.out.print(" Left : " + heap[left(i)]);
            if (right(i) < k)
                System.out.print(" Right :" + heap[right(i)]);
            System.out.println();
        }
    }

    // swaps two nodes of the heap
    private void swap(int x, int y) {
        int tmp;
        tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

}