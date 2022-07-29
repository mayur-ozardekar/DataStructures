package com.study.ds.string;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(findMaxNumber(98, 56));
    }

    private static int findMaxNumber(int a, int b){
        if(b == 0) return a;
        return findMaxNumber(b, a % b);
    }


}
