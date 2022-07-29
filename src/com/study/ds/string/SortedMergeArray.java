package com.study.ds.string;

import java.util.ArrayList;
import java.util.List;

public class SortedMergeArray {
    public static void main(String[] args) {

    }

    private List<Integer> sortedMergedArray(List<Integer> l1, List<Integer> l2){
        List<Integer> result = new ArrayList<>();

        int lengthL1 = l1.size();
        int lengthL2 = l2.size();

        int minLength = Math.min(lengthL1, lengthL2);
        int maxLength = Math.max(lengthL1, lengthL2);

        int counterMax = 0;
        int counterMin = 0;

         while(true){

             if(counterMax > lengthL1) break;
             if(counterMin > lengthL2) break;

             if(l1.get(counterMax) < l2.get(counterMin)){
                 result.add(l1.get(counterMax));
                 counterMax ++;
                 // counter L1 ++
             } else {
                 result.add(l2.get(counterMin));
                 counterMin ++;
                 // counter of L2 ++
             }

         }

        if(lengthL1 > minLength){

            for(int i = minLength; i < lengthL1; i ++){
                result.add(l1.get(i));
            }

        } else {
            for(int i = minLength; i < lengthL2; i ++){
                result.add(l2.get(i));
            }
        }

        return result;
    }
}
