package com.study.ds.scaler;

import java.util.ArrayList;
import java.util.List;

public class Solution7 {
    public int solve(int[] A) {
        return invCount(A, 0, A.length - 1);
    }

    private int invCount(int[] A, int start, int end) {
        int MOD = 1000000007;
        if (start == end)
            return 0;

        int mid = (start + end) / 2;
        int x = invCount(A, start, mid) % MOD;
        int y = invCount(A, mid + 1, end) % MOD;
        int z = merge(A, start, mid, end) % MOD;

        return (x + y + z) % MOD;
    }


    public int merge(List<Integer> A, int start, int mid, int end) {
        ArrayList<Integer> helper = new ArrayList<>();
        int p1 = start, p2 = mid + 1;
        int ans = 0;
        while (p1 <= mid && p2 <= end) {

            if ((long) A.get(p1) > 2 * (long) A.get(p2)){
                ans += mid - p1 + 1;
                p2++;
            } else{
                p1++;
            }
        }
        p1 = start;
        p2 = mid + 1;
        while (p1 <= mid && p2 <= end) {
            if (A.get(p1) <= A.get(p2)) helper.add(A.get(p1++));
            else helper.add(A.get(p2++));
        }
        while (p1 <= mid) helper.add(A.get(p1++));
        while (p2 <= mid) helper.add(A.get(p2++));
        for (int i = 0; i < helper.size(); ++i) A.set(start + i, helper.get(i));
        return ans;
    }

    public int reversePairs(ArrayList<Integer> A, int start, int end) {
        //Base Case
        if (start == end) return 0;
        int mid = (start + end) >> 1;
        int leftReversePairs = reversePairs(A, start, mid);
        int rightReversePairs = reversePairs(A, mid + 1, end);
        int mergeReversePairs = merge(A, start, mid, end);
        return leftReversePairs + rightReversePairs + mergeReversePairs;
    }

    public int solve(ArrayList<Integer> A) {
        return reversePairs(A, 0, A.size() - 1);
    }

    private int[] subUnsort(int[] A) {
        int length = A.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // find min present in Array
        for (int i = 1; i < length; i++) {
            if (A[i] < A[i - 1]) {
                min = Math.min(min, A[i]);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return new int[]{-1};
        }

        // find max present in Array
        for (int i = length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                max = Math.max(max, A[i]);
            }
        }

        int hi = -1;
        int lo = -1;

        for (int i = 0; i < length; i++) {
            if (A[i] < min) {
                lo = i;
                break;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (A[i] > max) {
                hi = i;
                break;
            }
        }

        return new int[]{lo, hi};
    }

    private int merge(int[] A, int start, int mid, int end) {
        int count = 0;
        int p1 = start;
        int p2 = mid + 1;
        int p3 = 0;
        int MOD = 1000000007;
        int[] c = new int[end - start + 1];
        while (p1 <= mid && p2 <= end) {
            if (A[p1] <= A[p2]) {
                c[p3] = A[p1];
                p1++;
                p3++;
            } else {
                c[p3] = A[p2];
                p2++;
                p3++;
                //No of elements = mid - p1 +1
                count += (mid - p1 + 1) % MOD;
            }
        }
        while (p1 <= mid) {
            c[p3] = A[p1];
            p1++;
            p3++;
        }

        while (p2 <= end) {
            c[p3] = A[p2];
            p2++;
            p3++;
        }

        p3 = 0;
        for (int i = start; i <= end; i++) {
            A[i] = c[p3];
            p3++;
        }

        return count % MOD;
    }

    public static int[] alternateNegativeAndPositive(int[] A) {
        int i = 0;
        int j;

        while (i < A.length) {
            j = i + 1;
            if (i % 2 == 0) {
                if (A[i] >= 0) {
                    while (j < A.length && A[j] >= 0) {
                        j++;
                    }
                    if (swap(A, i, j)) {
                        break;
                    }
                }
            } else {
                if (A[i] < 0) {
                    while (j < A.length && A[j] < 0) {
                        j++;
                    }
                    if (swap(A, i, j)) {
                        break;
                    }
                }
            }
            i++;
        }

        return A;
    }

    private static boolean swap(int[] A, int i, int j) {

        if (j > A.length - 1) {
            return true;
        }

        while (j > i) {
            int tmp = A[j];
            A[j] = A[j - 1];
            A[j - 1] = tmp;
            j--;
        }

        return false;
    }
}
