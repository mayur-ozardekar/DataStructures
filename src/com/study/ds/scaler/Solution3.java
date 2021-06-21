package com.study.ds.scaler;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.solve(new int[]{1, 2, 3, 4, 5});
    }
    public int solve(int[] A) {
        int count = 0;

        int i = 0;
        int j = 1;

        while(j < A.length){

            if((A[i] + A[j]) % 2 != 0 && j < A.length - 1){
                if((A[i] + A[j + 1]) % 2 == 0) {
                    count ++;
                    i = j + 1;
                    j = i + 1;
                    continue;
                }
            }

            i ++;
            j ++;

        }

        System.out.println(count);
        return count;
    }
}
