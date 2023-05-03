package com.company;

public class Binary {
    public static boolean search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;

        while (true) {
            // jump to the middle
            int index = first+(last-first)/2;
            if (array[index] == key) {
                return true; //found the element
            }
            if (array[index] < key && index < last) {
                first = index+1; //since the middle element was smaller, move to the element after
                continue;
            }
            if (array[index] > key && index > first) {
                // The index position holds something that is larger than
                // what we're looking for, what is the last possible page? - the one before the middle?
                last = index-1 ;
                continue;
            }
                // Why do we land here? What should we do?
            //idk infinite loop? break?
                break;


        }
        return false;
    }

}
