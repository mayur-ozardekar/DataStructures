package com.study.ds.string.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static int countVowels(String str){
        if(str == null) return 0;

        int count = 0;
        String vowels = "aeiou";

        for (char ch : str.toCharArray()) {
            if(vowels.indexOf(ch) != -1) count ++;
            // if(vowels.contains(Character.toString(ch))) count ++;
        }

        return count;
    }

    public static String reverseString(String str){
        if(str == null) return "";
        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse();
        return reversed.toString();
    }

    public static String reverseOrderOfString(String sentence){
        if (sentence == null) return "";

        String[] words = sentence.trim().split("\\s");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

        /*StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0 ; i --) {
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();*/
    }

    public static boolean areDuplicates(String source, String target){
        if(source == null || target == null) return false;
        return (source.length() == target.length()) && (source + source).contains(target);
    }

    public static String removeDuplicates(String str){
        if(str == null) return "";

        StringBuilder result = new StringBuilder();
        int[] chars = new int[256];

        for(char ch : str.toCharArray())
            chars[ch] ++;

        for(int i = 0; i < 256; i ++){
            if(chars[i] > 0)
                result.append((char) i);
        }

        return result.toString();

        /*StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for(char ch : str.toCharArray()){
            if(!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        return result.toString();*/
    }

    public static char getMaximumOccurringCharacter(String str){
        if(str == null || str.isEmpty()) throw new IllegalArgumentException("Please provide valid String");

        char[] chars = str.toCharArray();
        /*Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : chars){
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }*/

        int[] charCount = new int[256];
        for (char ch : chars) {
            charCount[ch] ++;
        }

        int max = 0;
        char result = 32;

        for (int i = 0; i < 256; i++) {
            if(charCount[i] > max){
                max = charCount[i];
                result = (char) i;
            }
        }

       /* for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                result = entry.getKey();
            }
        }*/

        return result;
    }

    public static String capitalise(String str){
        if(str == null || str.isEmpty()) return "";

        String[] words = str.trim().replaceAll(" +", " ").split(" ");

        for(int i = 0; i < words.length; i ++){
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean areAnagrams(String first, String second){
        if(first == null || second == null || first.length() != second.length()) return false;

        char[] array1 = first.toLowerCase().toCharArray();
        char[] array2 = second.toLowerCase().toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);

    }

    public static boolean areAnagrams_histogramming(String first, String second){
        if(first == null || second == null || first.length() != second.length()) return false;

        int[] charCount = new int[26];

        first = first.toLowerCase();
        second = second.toLowerCase();

        for(int i = 0; i < first.length(); i ++){
            charCount[first.charAt(i) - 'a'] ++;
        }

        for(int i = 0; i < second.length(); i ++){
            int index = second.charAt(i) - 'a';
            if(charCount[index] == 0) return false;
            charCount[index] --;
        }

        return true;
    }

    public static boolean isPalindrome(String word){
        if(word == null) return false;

        int left = 0;
        int right = word.length() - 1;

        while(left < right)
            if(word.charAt(left ++) != word.charAt(right --)) return false;

        return true;
        /*StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        return word.equals(sb.toString());*/
    }

    private static int countVowelsWithSet(String string){
        int count = 0;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('u');
        vowels.add('i');

        for(char ch : string.toCharArray())
            if(vowels.contains(ch)) count ++;

        return count;
    }

    private String replaceOccurance(String text, String replaceFrom, String replaceTo, int occuranceIndex)
    {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(replaceFrom);
        Matcher m = p.matcher(text);
        int count = 0;
        while (m.find())
        {
            if (count++ == occuranceIndex - 1)
            {
                m.appendReplacement(sb, replaceTo);
            }
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static boolean isAnagram(String a, String b){

        return false;
    }
}
