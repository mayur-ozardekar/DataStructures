package com.study.ds.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution8 {

    public static void main(String[] args) {
        int[] array = new int[]{2,-2,3,0,4,-7};
        System.out.println(findMax(array));
        array = new int[]{6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println(findMax(array));
    }

    public static int findMax(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            int n = map.getOrDefault(sum, 0);
            count += n;

            if(count > 1000000000) return -1;

            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        return count;
    }

    public static int test(int[] nums) {
        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum += nums[i];
                if (sum == 0)
                    count ++;
            }
        }
        return count;
    }
}
