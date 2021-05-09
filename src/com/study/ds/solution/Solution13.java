package com.study.ds.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution13 {
    public int solution(String S) {
        // write your code in Java SE 8
        return 0;
    }

    // Driver Code
    public static void main(String[] args) {
        String str = "ccaaffddecee";

        // Stores length of str
        int N = str.length();
        System.out.print(minNumberOfUniqueLettersCount(str));
    }

    public static int minNumberOfUniqueLettersCount(String S){

        char[] charArray = S.toCharArray();
        int length = charArray.length;

        // 1. Store Char Count
        Map<Character, Integer> charCountMap = new HashMap<>();

        // 2. Sort based on char count, priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b, a)
        );

        // 3. track MinCount
        int charCount = 0;

        // 4. Traverse Char Array
        for(char ch : charArray){
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        // 5. Sort Occurence
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            pq.add(entry.getValue());

        }

        // 6. Traverse pq
        while(!pq.isEmpty()){
            int currentTop = pq.poll();

            // Validate and return
            if(pq.isEmpty()){
                return charCount;
            }

            // add unique count occurences

            // check if any case equal numbers
            if(currentTop == pq.peek()){
                if(currentTop > 1){
                    pq.add(currentTop - 1);
                }

                charCount ++;
            }

        }

        return charCount;
    }

}
