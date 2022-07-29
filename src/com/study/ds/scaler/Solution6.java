package com.study.ds.scaler;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution6 {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sortElements(A)));

        String[] strArr = "TEST, AMAZING, DEMO".split(",");

        Set<String> setVar = new HashSet<>();
        Collections.addAll(setVar, strArr);//.add(strArr[i]);

        File file = new File("c://test");

        System.out.println(setVar + " : " + file.getPath());
    }

    public static int[] sortElements(int[] A){
        // Arrays.sort(A);
        int RED = 0;
        int BLUE = 1;
        int GREEN = 2;

        // 1. RED
        // 2. GREEN
        // 3. BLUE

        int start = 0, end = A.length - 1, tracker = 0;
        while(start <= end){
            if(A[start] == RED && A[end] == GREEN) {
                start ++;
                end --;
            } else if(A[start] == RED) start ++;
            else if(A[end] == GREEN) end --;
            else {
                end --;
            }
        }
        return A;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
