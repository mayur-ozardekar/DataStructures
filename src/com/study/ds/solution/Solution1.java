package com.study.ds.solution;

public class Solution1 {

    public static void main(String[] args) {

        int n = 99;

        int temp = 0;

        while(n > 0){
            temp += n % 10;
            n = n / 10;
        }

        System.out.println(temp);

    }

}
