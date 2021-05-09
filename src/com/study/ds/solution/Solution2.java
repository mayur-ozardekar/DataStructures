package com.study.ds.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 2, 0};
        System.out.println(countPairWithSum2(nums, 8));
        countPairWithSum(nums, 8);
    }

    public static int countPairWithSum(int[] a, int k) {
        int length = a.length;

        Map<Integer, Integer> countPairs = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] + a[j] == k) {
                    if (!(countPairs.containsKey(a[j]) && countPairs.containsValue(a[i])))
                        countPairs.put(a[i], a[j]);
                }
            }
        }

        return countPairs.size();
    }

    public static int countPairWithSum2(int[] input, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int pairsCount = 0;

        for (int i = 0; i < input.length; i++) {
            int value = input[i];
            int target = k - input[i];

            if (countMap.containsKey(target)) {
                int freq = countMap.get(target) - 1;
                pairsCount++;

                if (freq == 0) {
                    countMap.remove(target);
                } else {
                    countMap.put(target, freq);
                }

            } else {
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            }
        }

        return pairsCount;
    }
}
