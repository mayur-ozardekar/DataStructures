package com.study.ds.arrays.utils;

import com.study.ds.arrays.ListNode;

import java.util.Arrays;

public class MergeUtils {
    /**
     * Merge Sorted Array
     * <p>
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * <p>
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
     * <p>
     * Example:
     * <p>
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     * <p>
     * Constraints:
     * <p>
     * -10^9 <= nums1[i], nums2[i] <= 10^9
     * nums1.length == m + n
     * nums2.length == n
     */
    public static int[] mergeSortedArrays(int[] A, int[] B, int m, int n) {
        System.arraycopy(B, 0, A, m, n);
        Arrays.sort(A);
        return A;
    }

    /**
     * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Example 1:
     * <p>
     * Input: l1 = [1,2,4], l2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * <p>
     * Example 2:
     * <p>
     * Input: l1 = [], l2 = []
     * Output: []
     * <p>
     * Example 3:
     * <p>
     * Input: l1 = [], l2 = [0]
     * Output: [0]
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in both lists is in the range [0, 50].
     * -100 <= Node.val <= 100
     * Both l1 and l2 are sorted in non-decreasing order.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
