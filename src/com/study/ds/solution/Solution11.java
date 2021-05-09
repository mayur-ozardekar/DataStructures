package com.study.ds.solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution11 {
    public static void main(String[] args) {
        System.out.println(maxJump(new int[]{2, 6, 8 , 5}));
        System.out.println(maxJump(new int[]{1, 1}));
        System.out.println(maxJump(new int[]{1, 5, 5, 2, 6}));
        System.out.println(maxJump(new int[]{2, 6, 8, 3, 8, 10, 15}));
    }

    public static int maxJump(int[] blocks){
        int length = blocks.length;
        int[] leftArray = new int[length];
        int[] rightArray = new int[length];

        int bound = length;

        for (int i = 0; i < bound; i ++) {
            int index = i;
            while (index - 1 > 0 && blocks[index] >= blocks[index - 1]) {
                leftArray[i] ++;
                index --;
            }
        }


        for (int i = 0; i < bound; i++) {
            int index = i;
            while (index + 1 < length && blocks[index] <= blocks[index + 1]) {
                rightArray[i] ++;
                index ++;
            }
        }

        System.out.println("Arrays.toString(rightArray) = " + Arrays.toString(rightArray));
        System.out.println("Arrays.toString(leftArray) = " + Arrays.toString(leftArray));

        return 0;


    }

    public static int maxJump_n3(int[] blocks){

        int leftMax = 0;
        int rightMax = 0;
        int max = 0;

        for(int i = 0; i < blocks.length; i ++){
            leftMax = Math.max(leftMax, leftMove(blocks, i, 0));
            rightMax = Math.max(rightMax, rightMove(blocks, i, 0));
            max = Math.max(max,  rightMax - leftMax + 1);
        }

        return max;

    }

    public static int leftMove(int[] arr, int current, int leftMax){
        int currentIndex = current;
        int index = current - 1;

        while(index > 0 && arr[index] >= arr[currentIndex]){
            leftMax = index;
            index --;
            currentIndex --;
        }
        return leftMax;
    }

    public static int rightMove(int[] arr, int current, int rightMax){
        int currentIndex = current;
        int index = current + 1;

        while(index < arr.length && arr[index] >= arr[currentIndex]){
            rightMax = index;
            index ++;
            currentIndex ++;
        }
        return rightMax;
    }

    public static int maxJump_2(int[] blocks){

        // Max value in array and its index
        int max = blocks[0];
        int maxIndex = 0;

        for(int i = 0; i < blocks.length; i ++){
            if(max <= blocks[i]){
                max = blocks[i];
                maxIndex = i;
            }
        }

        int minMax = blocks[0];
        int minMaxIndex = 0;
        for(int i = 1; i < maxIndex; i ++){
            if(blocks[i - 1] > blocks[i]){
                minMaxIndex = i;
            }
        }

        int maxNear = blocks[0];
        int maxIndexNear = 0;

        for(int i = 0; i < minMaxIndex; i ++){
            if(maxNear < blocks[i]){
                maxNear = blocks[i];
                maxIndexNear = i;
            }
        }

        System.out.println("maxIndex : "+ maxIndex);
        System.out.println("minMaxIndex : " + minMaxIndex);
        System.out.println("maxIndexNear : " + maxIndexNear);
        // Max index with min value
        return maxIndex - maxIndexNear + 1;
    }
}
