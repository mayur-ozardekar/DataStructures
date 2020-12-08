package com.study.java.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        int[] C = {2, 0, 2, 0};
        System.out.println(solution(2, 2, C));
    }
    public static String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        int sum = Arrays.stream(C).sum();

        if(sum != U + L){
            return "IMPOSSIBLE";
        } else {
            return returnMatrix(U, L, C);
        }
    }

    public static boolean esPosible(int U, int L, int[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 2) {
                L--;
                U--;
            }
        }
        if (U < 0 || L < 0) {
            return false;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1) {
                if (U> 0) {
                    U--;
                } else {
                    L--;
                }
            }
        }
        return U == 0 && L == 0;
    }

    public String solution_II(int U, int L, int[] c) {
        boolean posible = esPosible(U, L, c);
        String res = "IMPOSSIBLE";
        if (posible) {
            String res1 = "", res2 = "";
            for (int i = 0; i < c.length; i++) {
                if (c[i] == 0) {
                    res1 += "0";
                    res2 += "0";
                }
                if (c[i] == 2) {
                    U--; L--;
                    res1 += "1";
                    res2 += "1";
                }
                if (c[i] == 1) {
                    if (U > 0) {
                        U--;
                        res1+="1";
                        res2+="0";
                    } else {
                        L--;
                        res1+="0";
                        res2+="1";
                    }
                }
            }
            res = res1 + "," + res2;
        }

        return res;
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[] a1 = new int[n];
        int[] a2 = new int[n];

        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                a1[i] = 1;
                a2[i] = 1;
                upper--;
                lower--;
            }
            else if (colsum[i] == 1) {
                if (upper >= lower) {
                    a1[i] = 1;
                    upper--;
                } else {
                    a2[i] = 1;
                    lower--;
                }
            }
        }

        if (upper != 0 || lower != 0)
            return new ArrayList();

        return new ArrayList(Arrays.asList(a1, a2));
    }

    public static String returnMatrix(int upper, int lower, int[] input){

        StringBuilder resultMatrix = new StringBuilder();

        StringBuilder upperRow = new StringBuilder();
        StringBuilder lowerRow = new StringBuilder();

        for(int i = 0; i < input.length; ++i) {

            if(input[i] == 2) {
                upperRow.append(1);
                lowerRow.append(1);
                upper --;
                lower --;
            } else if (input[i] == 1) {

                if(upper > lower) {
                    upperRow.append(1);
                    lowerRow.append(0);
                    upper --;
                } else {
                    upperRow.append(0);
                    lowerRow.append(1);
                    lower --;
                }

            } else {
                upperRow.append(0);
                lowerRow.append(0);
            }
        }

        resultMatrix = upperRow.append(",").append(lowerRow);

        return resultMatrix.toString();
    }
}
