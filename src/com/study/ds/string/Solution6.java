package com.study.ds.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution6 {
    public static void main(String[] args) {
        //System.out.println(longestConsecutive(List.of(100, 4, 200, 1, 3, 2)));
        System.out.println(solve(List.of(96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93, 5, 50, -45, 66, -28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80, -71, 48, -93, 62)));
        System.out.println(longestConsecutive(List.of(100, 4, 200, 1, 3, 2).toArray(new Integer[0])));
        System.out.println(colorful(236));
    }

    public static int solve(List<Integer> A) {
        Set<Integer> sumSet = new HashSet<>();

        int sum = 0;

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if (sum == 0 || sumSet.contains(sum)) return 1;

            sumSet.add(sum);
        }

        return 0;

    }

    public static int longestConsecutive(Integer[] A) {
        HashSet<Integer> hs = new HashSet<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            hs.add(A[i]);
        }
        int long_length = 0;
        for (int i = 0; i < n; i++) {
            if (!hs.contains(A[i] - 1)) {
                int num = A[i];
                while (hs.contains(num)) {
                    num++;
                }

                long_length = Math.max(long_length, num - A[i]);
            }
        }
        return long_length;
    }

    public static int colorful(int A) {
        Set<Integer> productSet = new HashSet<>();

        String[] charArray = String.valueOf(A).split("");

        int product = Integer.parseInt(charArray[0]);
        for(int i = 1; i < charArray.length; i ++){
            product *= Integer.parseInt(charArray[i]);
        }

        productSet.add(product);

        for(String ch : charArray){
            int digit = Integer.parseInt(ch);

            if(productSet.contains(digit)){
                return 0;
            }

            productSet.add(digit);
        }

        for(int i = 0; i < charArray.length - 1; i ++){
            for(int j = i + 1; j < charArray.length - 1; j ++){
                int current = Integer.parseInt(charArray[i]) * Integer.parseInt(charArray[j]);

                if(productSet.contains(current)){
                    return 0;
                }

                productSet.add(current);
            }
        }

        return 1;
    }

    public static int longestConsecutive(final List<Integer> A) {
        Integer[] integers = A.toArray(new Integer[0]);

        Arrays.sort(integers);

        int max = Integer.MIN_VALUE;

        int start = 0;
        int next = 1;

        while (next < integers.length) {

            if (integers[next] - integers[next - 1] != 1) {
                max = Math.max(max, next - start);
                start++;
            }

            next++;
        }

        return max;
    }
}
