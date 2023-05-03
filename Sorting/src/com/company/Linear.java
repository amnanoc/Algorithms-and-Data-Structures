package com.company;

public class Linear {
    public static boolean search(int[] array, int key) {
       for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }

            if(array[index] > key) //since its a sorted array we know we didnt find our key if we found a bigger element
                return false;
        }
        return false;
    }
}
