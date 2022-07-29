package com.study.ds.recursion;

import java.util.*;

public class RecursionUtils {
    /**
     * Score of Parentheses
     *
     * Given a balanced parentheses string S, compute the score of the string based on the following rule:
     *
     * () has score 1
     * AB has score A + B, where A and B are balanced parentheses strings.
     * (A) has score 2 * A, where A is a balanced parentheses string.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: 1
     * Example 2:
     *
     * Input: "(())"
     * Output: 2
     * Example 3:
     *
     * Input: "()()"
     * Output: 2
     * Example 4:
     *
     * Input: "(()(()))"
     * Output: 6
     *
     *
     * Note:
     *
     * S is a balanced parentheses string, containing only ( and ).
     * 2 <= S.length <= 50
     *
     * // DEMO TEST BRANCHING
     *
     */
    int i = 0;
    public int scoreOfParentheses(String S) {
        int score = 0;

        while(i < S.length()){
            char first = S.charAt(i);
            i ++;

            if(first == '('){
                if(S.charAt(i) == ')'){
                    score += 1;
                    i ++;
                } else {
                    score += 2*scoreOfParentheses(S);
                }
            } else {
                return score;
            }
        }

        return score;
    }


    /**
     * Space : O(N)
     * Time : O(N)
     */
    public int scoreOfParentheses_stack(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(char ch : S.toCharArray()){
            if(ch == '('){
                stack.push(0);
            } else {
                int prevBracket = stack.pop();
                int rootBracket = stack.pop();
                stack.push(rootBracket + Math.max(2 * prevBracket, 1));
            }
        }

        return stack.pop();
    }

    /**
     *
     * Time : O(N)
     * Space : O(1)
     *
     */
    public int scoreOfParentheses_bitwise(String S) {
        int bal = 0, result = 0;
        for(int i = 0; i < S.length(); i ++){
            if(S.charAt(i) == '('){
                bal ++;
            } else {
                bal --;
                if(S.charAt(i - 1) == '(')
                    result += 1 << bal;
            }
        }

        return result;
    }

    private Map<String, String> ds = new HashMap<>();

    public List<String> letterCombinations(String A) { // 23

        ds.put("2", "abc");
        ds.put("3", "def");

        List<String> result = new ArrayList<>();

        letterCombinationsHelper(A, "", 0, result, ds);

        return result;

    }

    public void letterCombinationsHelper(String digits, String slate, int index, List<String> result, Map<String, String> ds) {

        // Base case or exit condition
        if(index == digits.length()) {
            result.add(slate);
            return;
        }

        String letters = ds.get(String.valueOf(digits.charAt(index)));

        for(int i=0; i< letters.length() - 1; i++) {
            letterCombinationsHelper(digits,  slate + letters.charAt(i), index+1, result, ds);
        }

    }

    public int wordBreak(String A, ArrayList<String> B) {
        return wordBreakHelper(A, 0, new HashSet<>(B));
    }

    public int wordBreakHelper(String A, int start, Set<String> dict) {

        if(start == A.length()) return 1;

        for(int end = start+1; end<=A.length(); end++) {

            if((dict.contains(A.substring(start,end)))
                    && (wordBreakHelper(A,end, dict)) ==1) {
                return 1;
            }

        }

        return 0;

    }

}
