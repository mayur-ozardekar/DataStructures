package com.study.ds.recursion;

import java.util.Stack;

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

}
