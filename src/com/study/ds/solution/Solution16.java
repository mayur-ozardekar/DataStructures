package com.study.ds.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution16 {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        // System.out.println("This is a debug message");

        List<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(5);
        input.add(5);
        input.add(10);
        input.add(20);

        System.out.println(isChangeable(input));
    }

    public static boolean isChangeable(List<Integer> bills){
        int countFive = 0;
        int countTen = 0;

        for (int bill : bills) {

            if(bill == 5)
                countFive ++;
            else if(bill == 10){
                if(countFive > 0){
                    countFive --;
                    countTen ++;
                } else
                    return false;
            } else {
                if(countFive > 0 && countTen > 0){
                    countFive --;
                    countTen --;
                } else if(countFive >= 3){
                    countFive -= 3;
                } else
                    return false;
            }
        }

        return true;
    }

    public static boolean cashHolding(List<Integer> bills){

        // 1. Track all currency
        Map<Integer, Integer> currencyHolder = new HashMap<>();

        for(Integer bill : bills){
            if(bill == 5){
                currencyHolder.put(5, currencyHolder.getOrDefault(bill, 0) + 1);
            } else {
                if(bill > 5){
                    int difference = bill - 5;  // 5

                    if(currencyHolder.containsKey(5)){
                        int denomination_5 = difference / 5; // 1
                        if(currencyHolder.get(5) < denomination_5) // 2 < 1
                            return false;

                        currencyHolder.put(5, currencyHolder.get(5) - denomination_5);

                    } else
                        return false;

                    if(currencyHolder.containsKey(10)){
                        int denomination_10 = difference / 10;
                        if(currencyHolder.get(10) > denomination_10)
                            return false;

                        currencyHolder.put(10, currencyHolder.getOrDefault(bill, 0) + 1);

                    } else
                        return false;

                    if(currencyHolder.containsKey(20)) {
                        int denomination_20 = difference / 20;
                        if(currencyHolder.get(20) > denomination_20)
                            return false;

                        currencyHolder.put(20, currencyHolder.getOrDefault(bill, 0) + 1);
                    } else
                        return false;
                }
            }

        }

        return true;
    }

    /**
     1. List Euros (5, 10, 10)
     2. cashAccount = 0;
     3. Iterate
     4.  i == 5 >> cashAccount + 5  >> cashAccount = 10 + 10 = 20 - 5 = 15
     5.  i > 5 >> cashAccount + (list[i] - 5)

     6. IF cashAccount < 0 >> false else true
     **/
}
