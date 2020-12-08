package com.study.ds.bytebybyte.general;

/**
 * FizzBuzz Problem
 *
 * if divisible by 3 print -> "Fizz"
 * if divisible by 5 print -> "Buzz"
 * if divisible by 5 print -> "FizzBuzz"
 *
 * print all numbers from 1 to given num
 *
 */
public class FizzBuzz {
    public static void main(String[] args) {
        int num = 15;
        printFizzBuzz(num);
    }

    public static void printFizzBuzz(int num){
        for (int i = 1; i <= num; i ++) {
            if(i % 3 == 0 && i % 5 == 0) System.out.println("FizzBuzz");
            else if(i % 3 == 0) System.out.println("Fizz");
            else if(i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}
