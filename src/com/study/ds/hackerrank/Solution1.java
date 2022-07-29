package com.study.ds.hackerrank;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(programmerIndexPart("progxrammerrxproxgrammer"));
    }

    private static int programmerIndexPart(String str){
        String leftTemp = "programmer";

        int i = 0;
        int j = str.length() - 1;

        for(; i < str.length(); i ++){
            int currentIndex = leftTemp.indexOf(str.charAt(i));

            if(currentIndex != -1){
                leftTemp = leftTemp.substring(0, currentIndex).concat(leftTemp.substring(currentIndex + 1));

                System.out.println(leftTemp);
            }

            if(leftTemp.length() == 0){
                i ++;
                break;
            }
        }

        String rightTemp = "programmer";

        for(; j >= 0; j --){
            int currentIndex = rightTemp.indexOf(str.charAt(j));

            if(currentIndex != -1){
                rightTemp = rightTemp.substring(0, currentIndex).concat(rightTemp.substring(currentIndex + 1));
            }

            if(rightTemp.length() == 0){
                j --;
                break;
            }


        }

        return j - i + 1;
    }
}
