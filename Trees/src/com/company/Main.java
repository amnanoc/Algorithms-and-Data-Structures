package com.company;

import java.util.Random;


public class Main {

    public static BinaryTree createTree(int n) {
        BinaryTree temp = new BinaryTree();
        Random rand = new Random();

        for (int i = 0; i < n; i++)
            temp.add(i, rand.nextInt(n));
        return temp;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);

        for (int i = 0; i < n; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        /*

        int[] sizes = {100,200,400,800,1600,3200,6400,9600, 12800};

        System.out.printf("#%7s%8s%8s\n", "n", "single", "double");
        for ( int n : sizes) {
            int loop = 1000;

            int[] index = sorted(n);
            BinaryTree tree = new BinaryTree();
            for(int i=0; i<n; i++) {
                tree.add(new Random().nextInt(n),index[i]);
            }


            System.out.printf("%8d", n);

            int k = 100;

            double min = Double.POSITIVE_INFINITY;
            double sum = 0;


            for (int i = 0; i < k; i++) {



                    long t0 = System.nanoTime();
                    for(int ki=0; ki<n; ki++)
                        tree.lookup(index[ki]);
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    sum+=t;






            }

            min = sum/k/n; // finding the average in nanoseconds
            System.out.printf("%8.0f", (min));



            sum = 0;

            for (int i = 0; i < k; i++) {


                long t0 = System.nanoTime();
                for(int ki=0; ki<n; ki++)
                    Binary.search(index,index[ki]);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                sum+=t;
            }

            min = sum/k/n;
            System.out.printf("%8.0f\n" , (min));
        }*/


        QueueArray tree = new QueueArray();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(8);
        tree.remove();
        tree.remove();
        tree.add(6);
        tree.add(3);
        /*tree.add(17);
        tree.add(42);

        tree.remove(); tree.remove(); tree.remove();
        tree.remove();
        tree.remove();
        tree.remove();
        tree.remove();
        System.out.println(tree);*/



        System.out.println(tree);


    }
}






