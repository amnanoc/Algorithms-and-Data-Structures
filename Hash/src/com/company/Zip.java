package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {

    Node[] data;
    int max;

    public class Node {
        String code;
        String name;
        Integer pop;

        public Node(String code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }
    public Zip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public String linearSearch(String search) {
        for(int i=0; i<10000; i++) {
            if(data[i].code.equals(search)) {
                return data[i].name;
            }
        }
        return null;
    }

    public String binarySearch(String search) {
        Integer integerSearch = Integer.valueOf(search.replaceAll("\\s",""));
        int lo = 0, hi = max;
        // This below check covers all cases , so need to check
        // for mid=lo-(hi-lo)/2
        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;
            if (  Integer.parseInt(data[mid].code.replaceAll("\\s",""))< integerSearch) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        if (Integer.valueOf(data[lo].code.replaceAll("\\s", "")).equals(integerSearch)) {
            return (data[lo].name);
        }
        else if (Integer.valueOf(data[hi].code.replaceAll("\\s", "")).equals(integerSearch)) {
           return (data[hi].name);
        }
        else {
            System.out.println("Not Found" );
        }
        return null;
    }
}