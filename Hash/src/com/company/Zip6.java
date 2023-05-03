package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Zip6 {
    Node[] data;
    Integer[] keys;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }
    public Zip6(String file, int sizeOfArray) {
        data = new Node[sizeOfArray];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                int index = hash(sizeOfArray,code);

                if(data[index] == null) //nothing there
                    data[index] = new Node(code, row[1], Integer.valueOf(row[2]));
                else { //find the next available
                    while(data[index]!=null && index!=data.length-1)
                        index++;
                    data[index] = new Node(code, row[1], Integer.valueOf(row[2]));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println(" file " + file + " not found");
        }
    }

    private int hash(int numberOfBuckets, int key) {
        return key%numberOfBuckets; //which bucket u add things to
    }


    public String lookup(Integer search, int numberOfBuckets) {
        int index = hash(numberOfBuckets,search);
        if(data[index]!=null && data[index].code.equals(search))
            return data[index].name;
        else {
            while( data[index]!=null && !data[index].code.equals(search) && index!= data.length-1 )
                index++;

            if(data[index]!=null && data[index].code.equals(search))
                return data[index].name;
        }

        return "";
    }


    public int elementsLooked(Integer search, int numberOfBuckets) {
        int elementsLooked = 0;
        int index = hash(numberOfBuckets,search);
        if(data[index]!=null && data[index].code.equals(search))
            return 1;
        else {
            while(!data[index].code.equals(search) && index!= data.length-1 ) {
                elementsLooked++;
                index++;
            }

            if(data[index].code.equals(search))
                return elementsLooked;
        }

        return elementsLooked;
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + "& " + cols[i]);
        }
        System.out.println();
    }
}
