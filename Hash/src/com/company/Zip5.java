package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Zip5 {
    Node[][] data;
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
    public Zip5(String file, int numberOfBuckets) {
        data = new Node[numberOfBuckets][];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                int index = hash(numberOfBuckets,code);
                if(data[index] == null) { //no elements
                    data[index] = new Node[1];
                    data[index][0] = new Node(code, row[1], Integer.valueOf(row[2]));
                } else { //there was something there already
                    //expand the array
                    Node[] temp = data[index]; //store what we had already
                    data[index] = new Node[data[index].length+1]; //one element bigger
                    int i=0;
                    //add old elements
                    for(i=0; i<temp.length; i++){
                        data[index][i] = temp[i];
                    }
                    data[index][i] = new Node(code, row[1], Integer.valueOf(row[2]));
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
        for(int i=0; i<data[index].length;i++)
            if(data[index][i]!=null && data[index][i].code.equals(search))
                return data[index][i].name;
            return "";
    }


    public int elementsLooked(Integer search, int numberOfBuckets) {
        int elementsLooked = 0;
        int index = hash(numberOfBuckets,search);
        for(int i=0; i<data[index].length;i++) {
            elementsLooked++;
            if(data[index][i]!=null && data[index][i].code.equals(search))
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
