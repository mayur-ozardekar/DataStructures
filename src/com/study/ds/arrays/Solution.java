package com.study.ds.arrays;

import com.study.ds.arrays.utils.MeetingUtils;
import com.study.ds.arrays.utils.MergeUtils;
import com.study.ds.arrays.utils.StockUtils;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(StockUtils.maxProfit(prices));
        System.out.println(StockUtils.maxProfit_II(prices));
        System.out.println(StockUtils.maxProfit_III(prices));
        System.out.println(StockUtils.maxProfit_III(new int[]{5, 11, 3, 50, 60, 90}));
        System.out.println(StockUtils.maxProfit_IV(1, new int[]{5, 11, 3, 50, 60, 90}));

        System.out.println(Arrays.toString(MergeUtils.mergeSortedArrays(new int[]{1, 2, 3, 0, 0, 0}, new int[]{2, 5, 6}, 3, 3)));
    }
}
