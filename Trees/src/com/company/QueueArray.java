package com.company;

import java.util.Arrays;

public class QueueArray {
        public static int CAPACITY = 5; // default array capacity
        private Integer[] array; // generic array used for storage
        private int first = 0; // index of the front element
        private int numberOfElements = 0; // current number of elements
        private int last = 0;

        public QueueArray() {
            this(CAPACITY);
        }

        public QueueArray(int capacity) {
            array = new Integer[capacity];
        }

        public boolean isEmpty() {
            return numberOfElements == 0;
        }

        private void expand() {
            CAPACITY = 2*CAPACITY;
            Integer[] temp = new Integer[CAPACITY];
            int position = 0;

            if(first<last) { // we didnt loop around
                for(int i=first; i<last;i++) {
                    temp[position] = array[i];
                    position++;
                }
            } else { //we looped around
                //from first to end of the array
                for(int i=first; i<array.length;i++) {
                    temp[position] = array[i];
                    position++;
                }

                //from the beginning of the array to last
                for(int i=0; i<last;i++) {
                    temp[position] = array[i];
                    position++;
                }
            }

            first = 0;
            last = numberOfElements-1;
            array = temp;

        }

        public void add(Integer value) {
          //  if (numberOfElements == array.length)
          //      throw new IllegalStateException("Queue is full");
            if(numberOfElements == array.length)
                //throw new IllegalStateException("Queue is full");
                expand();

            //where we insert
            int position = (first + numberOfElements) % array.length;
            array[position] = value;

            last++;
            if(last>array.length) //loop around the last el
                last = last % array.length;
            numberOfElements++;
        }

        public Integer remove() {
            if (numberOfElements == 0) { //no elements
                return null;
            }

            Integer temp = array[first];
            array[first] = null;
            first = (first + 1) % array.length;
            numberOfElements--;

            if(numberOfElements == 0)
                last = 0;


            return temp;
        }

    @Override
    public String toString() {
        String b = " ";
        for(int i=0; i<CAPACITY; i++) {
            b+=array[i]+" ";
        }
        return b;

    }
}
