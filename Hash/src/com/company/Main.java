package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final String path = "C:\\Users\\amnan\\Downloads\\postnummer.csv";
        System.out.println("zip5");
        Zip5 zip5 = new Zip5(path, 16);
        System.out.println(zip5.lookup(98499, 2));
        System.out.println(zip5.elementsLooked(98499,1));
        System.out.println("zip6");

        Zip6 zip6 = new Zip6(path, 10000);
        System.out.println(zip6.lookup(98499, 16));
        System.out.println(zip6.elementsLooked(98499,10000));
    }
}
