package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final String file = "C:\\Users\\amnan\\Downloads\\kelly.txt";
        Trie trie = new Trie();
        ArrayList<String> words = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
                trie.addWord(line); //add to the tree
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" file " + file + " not found");
        }

        System.out.println(trie.lettersToKeys("banana"));
    }
}
