package com.study.ds.string;

public class Solution3 {
    public static void main(String[] args) {
        int[] input = {1, 2, 5, 8, 9};
        System.out.println(solution(input, 9));
    }

    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (A[m] == X) {
                return m;
            }

            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
