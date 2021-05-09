package com.study.ds.solution;

public class Solution12 {

    public static void main(String[] args) {
        System.out.println(maxTwoDigit_2("10101"));
        System.out.println(maxTwoDigit_2("50552"));
        System.out.println(maxTwoDigit_2("88"));
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        return maxTwoDigit(S);
    }

    public static int maxTwoDigit(String s){
        int maxNumber = Integer.MIN_VALUE;

        int length = s.length();

        int start = 0;
        int next = 1;

        while(next < length){
            String digit = String.valueOf(s.charAt(start)).concat(String.valueOf(s.charAt(next)));
            maxNumber = Math.max(maxNumber, Integer.valueOf(digit));
            next ++;
            start ++;
        }

        return maxNumber;
    }
    
    public static int maxTwoDigit_2(String S){
        int maxValue = Integer.MIN_VALUE;

        int length = S.length();

        for(int i = 0; i < length - 1; i ++){
            int num = Integer.valueOf(String.valueOf(S.charAt(i)) + String.valueOf(S.charAt(i + 1)));
            maxValue = Math.max(maxValue, num);
        }

        return maxValue;
    }
}
