package com.study.java.solution;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}));
        System.out.println(noOfFairIndices(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}));
        System.out.println(noOfFairIndices_II(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}));
        System.out.println(fairIndex(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}));
        System.out.println(noOfFairIndices_II(new int[]{3, 2, 6}, new int[]{4, 1, 6}));
    }

    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int length = A.length;

        int[] sumArrayA = new int[A.length + 1];
        int[] sumArrayB = new int[B.length + 1];
        for (int index = 1; index <= length; index++) {
            sumArrayA[index] = sumArrayA[index - 1] + A[index - 1];
            sumArrayB[index] = sumArrayB[index - 1] + B[index - 1];
        }

        System.out.println(Arrays.toString(sumArrayA));
        System.out.println(Arrays.toString(sumArrayB));

        int noOfFairIndices = 0;
        for (int index = 1; index < length; index++) {
            if (sumArrayA[index] == sumArrayB[index] &&
                    sumArrayA[index] == sumArrayA[length] - sumArrayA[index] &&
                    sumArrayB[index] == sumArrayB[length] - sumArrayB[index])
                noOfFairIndices++;
        }

        return noOfFairIndices;
    }

    public static int noOfFairIndices(int[] A, int[] B) {

        int length = A.length;

        int sumA = 0, sumB = 0;
        sumA = Arrays.stream(A).sum();
        sumB = Arrays.stream(B).sum();

        int tmpA = 0, tmpB = 0;
        int count = 0;

        for (int i = 0; i < length - 1; i++) {
            tmpA += A[i];
            tmpB += B[i];

            if (tmpA == tmpB && sumA == 2 * tmpA && sumB == 2 * tmpB)
                count++;
        }

        return count;

    }

    public static int noOfFairIndices_II(int[] A, int[] B) {
        int length = A.length;

        int sumA = 0, sumB = 0;
        sumA = Arrays.stream(A).sum();
        sumB = Arrays.stream(B).sum();

        int tmpA = 0;
        int tmpB = 0;

        int result = 0;

        for (int i = 0; i < length - 1; i++) {
            tmpA += A[i];
            tmpB += B[i];

            sumA -= A[i];
            sumB -= B[i];

            if (sumA == sumB && tmpA == tmpB && sumA == tmpB) result++;
        }

        return result;
    }

    private static int fairIndex(int[] a, int[] b) {

        int[] sumAtIdxA = new int[a.length];
        int[] sumAtIdxB = new int[b.length];

        sumAtIdxA[0] = a[0];
        sumAtIdxB[0] = b[0];

        for (int i = 1; i < a.length; i++) {
            sumAtIdxA[i] = sumAtIdxA[i - 1] + a[i];
            sumAtIdxB[i] = sumAtIdxB[i - 1] + b[i];
        }

        int sumA = 0;
        int sumB = 0;

        // can just declare and initial a var count to track the number of fair indices here
        int count = 0;
        for (int i = a.length - 1; i > 0; i--) {
            sumA += a[i];
            sumB += b[i];

            if (sumAtIdxA[i - 1] == sumAtIdxB[i - 1] && sumA == sumB && sumA == sumAtIdxA[i - 1]) {
                count++;
            }
        }

        return count;
    }

    public int maxSubArray(int[] nums) {
        int omax = Integer.MIN_VALUE; //overall max
        int cmax = 0;                //current max
        for (int i : nums) {
            if (cmax > 0) {
                cmax = cmax += i;
            } else {
                cmax = i;
            }
            omax = (omax < cmax) ? cmax : omax;
        }
        return omax;
    }
}
