package com.company;
import java.util.Random;


class Bench {

    private static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Linear.search(array, indx[i]);
        }
    }
    private static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Binary.search(array, indx[i]);
        }
    }
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);

        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }
        return array;
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
    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }
        return indx;
    }
    private static int[] sectionSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            // let's set the first candidate to the index itself
            int cand = i;
            for (int j = i; j < array.length ; j++) {
                // If the element at position j is smaller than the value
                // at the candidate position - then you have a new candidate
                // posistion.
                if(array[j]<array[cand])
                    cand = j;
            }
            // Swap the item at position i with the item at the candidate position.
            if(cand!=i) { //we found something smaller
                int temp = array[cand]; //store the value somewhere
                array[cand] = array[i]; //swap
                array[i] = temp;
            }

        }
        return array;

    }
    private static void lastTask(int n) {
        int[] array1 = sorted(n);
        int[] array2 = sorted(n); // two sorted arrays
        int sum = 0;
        int last_index = 0;
        for (int i = 0; i < array1.length; i++)
        {

            for (int j = last_index; j < array2.length; j++)
            {
                if (array1[i] <= array2[j])
                {
                    if(array1[i]==array2[j])
                     sum += array1[i];
// no need to start from the beginning
                    last_index = j;
                    break;
                }
            }
        }

    }
    private static int[] insertionSort (int[] array) {
        for (int i = 0; i < array.length; i++) {
// for each element from i towards 1, swap the item found with the
// item before it if it is smaller
            for (int j = i; j > 0 && array[j]<array[j-1]  ; j--) {
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
           }
        }
        return array;
    }
    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi-lo)/2;
            // sort the items from lo to mid
            sort(org,aux,lo, mid);
            // sort the items from mid+1 to hi
            sort(org,aux,mid+1,hi);
            // merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
        }
    }
    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
// copy all items from lo to hi from org to aux
        for ( int i=lo; i<=hi; i++ ) {
            aux[i] = org[i];
        }
// let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
// for all indeces from lo to hi
        for ( int k = lo; k <= hi; k++) {
// if i is greater than mid, move the j item to the org array, update j
            if(i>mid) {
                org[k] = aux[j];
                j++;
            }

// else if j is greate than hi, move the i item to the org array, update i
            else if (j>hi) {
                org[k] = aux[i];
                i++;
            }

// else if the i item is smaller than the j item,
// move it to the org array, update i

            else if (aux[i]<aux[j]){
                org[k] = aux[i];
                i++;
            }
// else you can move the j item to the org array, update j
            else {
                org[k] = aux[j];
                j++;
            }

        }
    }
    private static void sort1(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    private static void sort2(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    private static void appendArrays (int[] array1, int[] array2, int n) {
        int[] array = new int[2*n];
        for(int i=0; i<2*n; i++) {
            if(i<n)
                array[i] = array1[i]; //copying the values from the first array
            else
                array[i] = array2[i-n]; // then appending the values from the other
        }
    }

    public static void main(String[] arg) {


        int[] sizes = {100,200,400,800,1600,3200,6400};

        System.out.printf("#%7s%8s%8s\n", "n", "linked lint", "array");
        for ( int n : sizes) {
            int loop = 10000;


            int[] aux = new int[n];
            int[] indx = keys(loop, n);
            Random rand = new Random();

            System.out.printf("%8d", n);

            int k = 10;

            double min = Double.POSITIVE_INFINITY;
            double sum = 0;


            for (int i = 0; i < k; i++) {

                LinkedList list2 = new LinkedList(rand.nextInt(n), null);
                for(int l=0; l<n; l++) {
                    list2.append(new LinkedList(rand.nextInt(n),null));
                }


                long t0 = System.nanoTime();
                LinkedList list1 = new LinkedList(rand.nextInt(100), null);
                for(int j=0; j<n; j++) {
                    list1.append(new LinkedList(rand.nextInt(100), null));
                }

                long t1 = System.nanoTime();

                double t = (t1 - t0);
                sum+=t;
            }

            min = sum/k; // finding the average in nanoseconds
            System.out.printf("%8.0f", (min));


            sum = 0;

            for (int i = 0; i < k; i++) {
                int[] array = unsorted(n);

                long t0 = System.nanoTime();
                int[] array1 = unsorted(n);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                sum+=t;
            }

            min = sum/k;
            System.out.printf("%8.0f\n" , (min));
        }
    }
}
