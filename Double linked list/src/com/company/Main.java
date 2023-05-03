package com.company;

import sun.awt.image.ImageWatched;

import java.util.Random;


public class Main {


    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }
        return indx;
    }

    private static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] indx = new int[n];
// fill the indx array with random number from 0 to n (not including n)
        for (int i = 0; i < n; i++) {
            indx[i]=rnd.nextInt(n);
        }

        return indx;
    }

    public static void main(String[] args) {

        int[] sizes = {100,200,400,800,1600,3200,6400,9600, 12800};

        System.out.printf("#%7s%8s%8s\n", "n", "single", "double");
        for ( int n : sizes) {
            int loop = 1000;

            int[] index = new int[n];
            Node[] nodesArray = new Node[n+1];
            Random rand = new Random();
            //random indices
            for(int i=0; i<n; i++) {
                index[i] = rand.nextInt(n);
            }



            System.out.printf("%8d", n);

            int k = 100;

            double min = Double.POSITIVE_INFINITY;
            double sum = 0;


            for (int i = 0; i < k; i++) {
                //creation of the node
                LinkedList list = new DoubleLinkedList(new Node(rand.nextInt(n), null,null));
                for(int ki=0; ki<n; ki++) {
                    list.addToFront(new Node(rand.nextInt(n),null,null));
                }

                //store all the nodes in the array
                Node temp = list.head;
                for(int ki=0; ki<n; ki++){
                    nodesArray[ki] = temp;

                    temp=temp.getNext();
                }




                for(int j=0; j<n;j++) {
                    long t0 = System.nanoTime();
                    Node temp1 = nodesArray[index[j]];
                    list.removeNode(temp1);
                    long t1 = System.nanoTime();
                    list.addToFront(temp1);
                    double t = (t1 - t0);
                    sum+=t;
                }





            }

            min = sum/k/n; // finding the average in nanoseconds
            System.out.printf("%8.0f", (min));



            sum = 0;

            for (int i = 0; i < k; i++) {
                int[] array = unsorted(n);

                long t0 = System.nanoTime();

                long t1 = System.nanoTime();
                double t = (t1 - t0);
                sum+=t;
            }

            min = sum/k;
            System.out.printf("%8.0f\n" , (min));
        }
    }
}
