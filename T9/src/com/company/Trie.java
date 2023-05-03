package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Vector;

public class Trie {
    Node root;
    Vector<String> words = new Vector<>();

    public Trie() {
        this.root = new Node();
    }

    public int letterToCode(char letter) {
        if(letter>='a' && letter<='p') //ascii
            return letter-97;
        else if(letter>='r' && letter<='v')
            return letter-98;
        else if(letter>='x' && letter<='z')
            return letter-99;
        else if(letter == 'q' || letter == 'w') //we skipped q and w
            return -1;
        else if(letter == 'ö') //swedish special letters
            return 26;
        else if(letter == 'ä')
            return 25;
        else if(letter == 'å')
            return 24;
        return -1; //something wrong
    }

    public String lettersToKeys(String word) {
        char[] letters = word.toCharArray();
        String keys = "";
        for(int i=0; i<letters.length; i++) {
            if(letters[i] >= 'a' && letters[i]<='c')
                keys+=1;
            else if(letters[i]>='d' && letters[i]<='f')
                keys+=2;
            else if(letters[i]>='g' && letters[i]<='i')
                keys+=3;
            else if(letters[i]>='j' && letters[i]<='l')
                keys+=4;
            else if(letters[i]>='m' && letters[i]<='o')
                keys+=5;
            else if(letters[i]>='p' && letters[i]<='s' && letters[i]!='q')
                keys+=6;
            else if(letters[i]>='t' && letters[i]<='v')
                keys+=7;
            else if(letters[i]>='x' && letters[i]<='z')
                keys+=8;
            else if(letters[i]=='å' || letters[i] == 'ä' || letters[i] == 'ö')
                keys+=9;
            else
                throw new NoSuchElementException();
        }
        return keys;
    }

    public char codeToLetter(int code) {
        if(code>=0 && code<=15)
            return (char) (97+code);
        else if(code>=16 && code<=20)
            return (char) (98+code);
        else if(code>=21 && code<=23)
            return (char) (99+code);
        else if(code == 24)
            return 'å';
        else if(code ==25)
            return 'ä';
        else if(code == 26)
            return 'ä';
        return '-';
    }

    public int keyToIndex(int key) {
        return key-1;
    }

    public void addWord(String word) {
        char[] letters = word.toCharArray();
        Node temp = root;
        for(int i=0; i<letters.length; i++) {
            if(temp.next[letterToCode(letters[i])]==null) //so we dont lose old words
                    temp.next[letterToCode(letters[i])] = new Node();
            temp = temp.next[letterToCode(letters[i])]; //move to that new created node
        }
        temp.word = true; //at the end we have formed a word
    }

    public Vector<String> search(String keySequence, Node current, String path) {
        if(path.isEmpty())
            words = new Vector<>();

        if(keySequence.isEmpty() && current.word) {
            words.add(path);
            return words;
        }

        char[] keys = keySequence.toCharArray();
        int index = keyToIndex(Integer.parseInt(String.valueOf(keys[0])));

        if(current.next[3*index]!=null) {
            System.out.println(path);
            search(keySequence.substring(1), current.next[3*index], path+codeToLetter(3*index)); //remove the 1st key
        }

        if(current.next[3*index+1]!=null){
            System.out.println(path);
            search(keySequence.substring(1), current.next[3*index+1], path+codeToLetter(3*index+1));
        }

        if(current.next[3*index+2]!=null){
            System.out.println(path);
            search(keySequence.substring(1), current.next[3*index+2], path+codeToLetter(3*index+2));
        }

        return words;
    }

}
