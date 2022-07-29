package com.study.ds.string;

import javax.xml.stream.events.Characters;

public class Solution1 {
    public static void main(String[] args) {

        isXorO("ox");
        //System.out.println();
    }

    private static boolean isXorO(String input){
        char[] charArray = input.toCharArray();

        boolean alphabetic = Character.isAlphabetic('A');
        //System.out.println(alphabetic);

        String str = "hello 45";

        char[] demo = str.toCharArray();

        for(char ch : demo){
            if(Character.isAlphabetic(ch)){
                System.out.print(ch - 'a' + 1);
            } else {
                System.out.print(ch);
            }
        }

        //System.out.println('c' - 'a' + 1);

        int countX = 0;
        int countO = 0;

        for(char ch : charArray){
            if(ch == 'x'){
                countX ++;
            } else if(ch == 'o'){
                countO ++;
            }
        }

        return countO == countX;
    }
}
