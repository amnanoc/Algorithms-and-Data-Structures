package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
           /* Item[] items = { //static stack test
                    new Item(ItemType.VALUE,3),
                    new Item(ItemType.VALUE,4),
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE,2),
                    new Item(ItemType.VALUE,4),
                    new Item(ItemType.ADD),
                    new Item(ItemType.MUL),
            };*/


            Item[] items = { // personal number test
                    new Item(ItemType.VALUE, 10),
                    new Item(ItemType.VALUE, 9), //D1
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.WEIRD_MUL),
                    new Item(ItemType.VALUE, 8), //D2
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE, 0), //D3
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.WEIRD_MUL),
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE, 5), //D4
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE, 1), //D5
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.WEIRD_MUL),
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE, 4), //D6
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE, 3), //D7
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.WEIRD_MUL),
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE, 5), //D8
                    new Item(ItemType.ADD),
                    new Item(ItemType.VALUE, 2), //D9
                    new Item(ItemType.VALUE, 2),
                    new Item(ItemType.WEIRD_MUL),
                    new Item(ItemType.ADD),
                    new Item(ItemType.MOD10),
                    new Item(ItemType.SUB),
            };


            Calculator calculator = new Calculator(items);
            long startTime = System.nanoTime();
            System.out.println(calculator.run());
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Estimated time " +estimatedTime);



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
