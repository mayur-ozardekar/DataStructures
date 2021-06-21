package com.study.ds.scaler;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {

        int[] A = {1, 3, 5};

        long result = 0;

        System.out.println(Integer.toBinaryString(5));

        System.out.println(Long.toUnsignedString(3, 2));

        String unsignedString = Long.toUnsignedString(3, 2);
        StringBuilder sb = new StringBuilder(unsignedString);
        sb.reverse();

        int positions = 32 - sb.length();

        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : A){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result1 = new ArrayList<>();

        for(int num : countMap.keySet()){
            if(countMap.get(num) < 2)
                result1.add(num);
        }

        result1.stream().mapToInt(value -> value).toArray();

        for(int i = 0; i < positions; i ++)
            sb.append(0);

        System.out.println(String.join(" Decimal representation is >> ", sb, String.valueOf(Long.parseLong(sb.toString(), 2))));

        for(int i = 0; i < 32; i ++){
            int count = 0;
            for(int j = 0; j < A.length; j ++){
                if((A[j] & (1 << i)) == 1)
                    count ++;
            }

            result += (2 * count * (A.length - count));
            result %= 1000000007;
        }

        System.out.println((int) result);

        System.out.println(solve_Height(20));

        System.out.println(solve(5));
    }

    public static int solve(int A) {

        String stringBinary = Integer.toBinaryString(A);
        String[] charArray = stringBinary.split("");

        int bitLength = stringBinary.length();

        int y = 1 << bitLength;

        for(int i = 0; i < charArray.length; i ++){
            if(charArray[i].equals("1"))
                charArray[i] = "0";
            else
                charArray[i] = "1";
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(charArray).forEach(ch -> sb.append(ch));

        int x = Integer.parseInt(sb.toString(), 2);

        return x ^ y;

    }

    public static int solve_Height(int A) {
        int h = 0;
        int sum = 0;

        while(sum < A){
            h ++;
            sum += h;

            if(sum == A) break;
        }

        return h;
    }
}
