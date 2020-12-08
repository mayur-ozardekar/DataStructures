package com.study.ds.arrays.utils;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberUtils {

    /**
     * House Robber
     *
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     *
     *  Example 1:
     *
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     *              Total amount you can rob = 1 + 3 = 4.
     *
     * Example 2:
     *
     * Input: nums = [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     *              Total amount you can rob = 2 + 9 + 1 = 12.
     *
     * Constraints:
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     *
     */
    public int rob(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    /**
     * House Robber II
     *
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: nums = [2,3,2]
     * Output: 3
     * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
     * Example 2:
     *
     * Input: nums = [1,2,3,1]
     * Output: 4
     *
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     *
     * Example 3:
     *
     * Input: nums = [0]
     * Output: 0
     *
     * Constraints:
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     *
     */
    public int rob_II(int[] nums){
        if(nums.length == 1) return nums[0];

        return Math.max(robHouse(nums, 0, nums.length - 1), robHouse(nums, 1, nums.length));
    }

    private int robHouse(int[] nums, int start, int end) {
        int previousTwo = 0, previousOne = 0, max = 0;

        for(int i = start; i < end; i ++){
            max = Math.max(previousTwo + nums[i], previousOne);
            previousTwo = previousOne;
            previousOne = max;
        }
        return max;
    }


    /**
     * House Robber III
     *
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
     *
     * Determine the maximum amount of money the thief can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * Output: 7
     * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     *
     * Example 2:
     *
     * Input: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * Output: 9
     * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     *
     */
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob_III(TreeNode root){
        if(root == null) return 0;

        if(memo.containsKey(root)) return memo.get(root);


        int sum = root.val;

        if(root.left != null){
            sum += rob_III(root.left.left);
            sum += rob_III(root.left.right);
        }

        if(root.right != null){
            sum += rob_III(root.right.left);
            sum += rob_III(root.right.right);
        }

        int nextSum = rob_III(root.left) + rob_III(root.right);
        int result = Math.max(sum, nextSum);
        memo.put(root, result);

        return result;

    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



}
