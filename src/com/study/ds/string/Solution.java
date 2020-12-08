package com.study.ds.string;

import com.study.ds.string.utils.StringUtils;

public class Solution {
    public static void main(String[] args) {
        System.out.println(StringUtils.countVowels("Hello"));
        System.out.println(StringUtils.reverseString("Hello"));
        System.out.println(StringUtils.reverseOrderOfString("Trees are beautiful"));
        System.out.println(StringUtils.areDuplicates("ABCD", "DABC"));
        System.out.println(StringUtils.removeDuplicates("Hello"));
        System.out.println(StringUtils.getMaximumOccurringCharacter("Tree are beautiful"));
        System.out.println(StringUtils.capitalise("what a beutiful day"));
        System.out.println(StringUtils.areAnagrams("abcd", null));
        System.out.println(StringUtils.areAnagrams_histogramming("abcXe", "abcXe"));
        System.out.println(StringUtils.isPalindrome(null));
    }
}
