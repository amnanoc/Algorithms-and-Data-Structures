package com.company;
import sun.awt.image.ImageWatched;

import java.util.Random;

public class Main {
    private static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] indx = new int[n];
// fill the indx array with random number from 0 to n (not including n)
        for (int i = 0; i < n; i++) {
            indx[i]=rnd.nextInt(n);
        }

        return indx;
    }
    private static Node unsortedNode(int n) {
        Random rnd = new Random();

        Node first = new Node(rnd.nextInt(n),null);
        Node temp = first;
        for(int i=0; i<n;i++) {
            temp.next = new Node(rnd.nextInt(n),null);
            temp = temp.next;
        }

        return first;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; //pivot value
        int i = low; //moving pointer

        //going through all the elements, starting with the 2nd one until the end
        for (int j = low+1; j <= high; j++) {
            if (arr[j] <= pivot) {
                i++; //counts how many smaller elements there were
                swap(arr, i, j); //somewhat sorts the elements as it goes
            }
        }
        swap(arr, i , low); //inserts pivot at the correct spot
        return i;
    }
    public static Node partition(Node low, Node high) {
        //one or no elements
        if (low == high || low == null || high == null)
            return low;

        int temp, pivot = low.value;
        Node previous = low;
        Node current = low;
        Node next = low.next;
        while (next != high.next) { //we didnt reach last el
            if (next.value <= pivot) {
                previous = current; //move the pointers
                current = current.next; //to next elements
                //exchange values
                temp = current.value;
                current.value = next.value;
                next.value = temp;
            }
            next = next.next;
        }
        //set the pivot in the correct place
        //by swapping it with the 1st
        temp = current.value;
        current.value = pivot;
        low.value = temp;
        //return the one before the el pivot
        return previous;
    }
    static void sort (Node low, Node high) {
        //leaving recursion, base case
        if (low == null || low == high || low == high.next)
            return;

        //getting the node before pivot
        Node beforePivot = partition(low, high);
        //sorting the left half of the array
        sort(low, beforePivot);

        if(beforePivot!=null) {
            //corner case when there was only 1 smaller element
            if(beforePivot==low)
                sort(beforePivot.next, high);
            //pivot was somewhere in the middle
            //sort the right side
            else if (beforePivot.next != null)
                sort(beforePivot.next.next, high);
        }
    }
    static int[] sort(int[] arr, int low, int high)
    {
        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pivot = partition(arr, low, high);
            // Separately sort elements before
            // partition and after partition
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
        return arr;
    }
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
    static void printList (Node first) {
        while(first.next!=null) {
            System.out.print(first.value+" ");
            first = first.next;
        }
    }
    static Node last (Node first) {
        Node last = first;
        while(last.next!=null)
            last = last.next;

        return last;
    }
    static Heap unsortedHeap(int n) {
        Heap heap = new Heap();
        Random rnd = new Random();
        for(int i=0; i<n; i++)
            heap.add(heap.root,rnd.nextInt(n));
        return heap;
    }

    static HeapArray unsortedHeap1(int n) {
        HeapArray heap = new HeapArray(n);
        Random rnd = new Random();
        for(int i=0; i<n; i++)
            heap.add(rnd.nextInt(n));
        return heap;
    }
    static HeapLinked sortedHeap (int n) {
        HeapLinked heap = new HeapLinked();
        for(int i=0; i<n; i++)
            heap.add(i);
        return heap;
    }


    public static void main(String[] args) {
	// write your code here

        int[] sizes = {100,200,400,800,1600,3200,6400,9600, 12800};

        System.out.printf("#%7s%8s%8s\n", "n", "single", "double");
        for ( int n : sizes) {
            int loop = 1000;

            System.out.printf("%8d", n);
            int k = 100;

            double min = Double.POSITIVE_INFINITY;
            double sum = 0;

            for (int i = 0; i < k; i++) {

                    Heap heap = unsortedHeap(n);
                    long t0 = System.nanoTime();
                    heap.remove();
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    sum+=t;


            }

            min = sum/k; // finding the average in nanoseconds
            System.out.printf("%8.0f", (min));
            sum = 0;


            for (int i = 0; i < k; i++) {
                HeapArray heap = unsortedHeap1(n);
                heap.minHeap();
                long t0 = System.nanoTime();
                heap.remove();
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                sum+=t;
            }

            min = sum/k;
            System.out.printf("%8.0f\n" , (min));
        }

  /*      Heap heap = new Heap();
        for(int i=0; i<64; i++)
            heap.add(heap.root,new Random().nextInt(100));
        for(int i=0; i<64; i++)
            heap.push(new Random().nextInt(20));*/

    }

}
