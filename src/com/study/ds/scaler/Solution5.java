package com.study.ds.scaler;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Pair {
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Solution5 {
    public static void main(String[] args) {
        int[] A = {8, 12, 16, 4, 0, 20};
        System.out.println(solve(A, 4));
    }

    public static int solve(int[] A, int B) {
        Set<Pair> countSet = new HashSet<>();

        for (int i = 0; i < A.length; i ++) {
            for (int j = i + 1; j < A.length; j ++) {
                int diff = Math.abs(A[i] - A[j]);
                if(diff == B) {
                    int y = Math.max(A[i], A[j]);
                    int x = Math.min(A[i], A[j]);
                    countSet.add(new Pair(x, y));
                }
            }
        }
        return countSet.size();
    }
}
