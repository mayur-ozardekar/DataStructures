package com.study.java.solution;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        int requiredSum = getNumberSum(936);
        getSumNumber("", 936, String.valueOf(936).length(), requiredSum);

        // you can write to stdout for debugging purposes, e.g.
        System.out.println("This is a debug message");

        String[] strings = {"ab", "ba", "xyz"};
        String[] queries = {"ab", "bq"};

        // output [2, 0]

        List<Integer> result = countAnagram(strings, queries);
        System.out.println(result);
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        int requiredSum = getNumberSum(N);

        int resultSum = 0;

        while (resultSum != requiredSum) {
            N = N + 1;
            resultSum = getNumberSum(N);
        }

        return N;
    }

    public static int getNumberSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void getSumNumber(String res, int num, int n, int sum) {

        if (n > 0 && sum >= 0) {
            char d = '0';
            if (res.equals("")) {
                d = '1';
            }

            while (d <= '9') {
                getSumNumber(res + d, num, n - 1, sum - (d - '0'));
                d++;
                //sum = sum - (d - '0');
            }
        }

        else if (n == 0 && sum == 0 && !res.isEmpty() && Integer.valueOf(res) > num) {
            System.out.print(res + " ");
        }
    }

    private static Map<String, Integer> dataSource(String[] strings) {
        Map<String, Integer> anagramCount = new HashMap<>();

        for(String string : strings) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String sortedString = Arrays.toString(charArray);

            anagramCount.put(sortedString, anagramCount.getOrDefault(sortedString, 1) + 1);
        }

        return anagramCount;
    }

    private static List<Integer> countAnagram(String[] strings, String[] queries){

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> stringIntegerMap = dataSource(strings);

        for(String query : queries){
            char[] charQuery = query.toCharArray();
            Arrays.sort(charQuery);
            String queryString = Arrays.toString(charQuery);


            if(stringIntegerMap.containsKey(queryString))
                result.add(stringIntegerMap.get(queryString) - 1);
            else
                result.add(0);
            // map O(1)
            // map >> result >> list >> O(n)
            /*for(String string : strings){
                if(isAnagram(query, string)){
                    count ++;
                }
            }

            result.add(count);*/
        }

        return result;

    }

    private static boolean isAnagram(String a, String b){
        if(a.length() != b.length()) return false;

        char[] a_chars = a.toCharArray();
        char[] b_chars = b.toCharArray();

        Arrays.sort(a_chars);
        Arrays.sort(b_chars);

        return Arrays.equals(a_chars, b_chars);
    }
}


/*

1. Function isAnagram
2. Iterate Queries
4. Iterate String each
5. count

O(M) + O(N) + O(n log n) + 1

O(N * M * n log n)


map

ab : 2
xyz : 2
opt : 1
bbq : 1
baa : 1
ba : 2

queries :

ab : 2 || ba : 2
O()


ab ba baa bba opt xyz
*/