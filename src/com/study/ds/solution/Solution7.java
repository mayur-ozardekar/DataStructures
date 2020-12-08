package com.study.java.solution;

public class Solution7 {
    public static void main(String[] args) {

        maximumPossible(268, 5);
        maximumPossible(0, 5);
        maximumPossible(-999, 5);
        maximumPossible(670, 5);
    }

    public static int maximumPossible(int num, int digit)
    {
        // base case
        if (num == 0)
        {
            System.out.println(digit * 10);
            return digit * 10;
        }

        int negative = num / Math.abs(num);

        // take abs value
        num = Math.abs(num);

        int checkDigitCounter = num;

        int max = Integer.MIN_VALUE;
        int counter = 0;
        int pos = 1;

        // count the number of digits
        while (checkDigitCounter > 0)
        {
            counter ++;
            checkDigitCounter = checkDigitCounter / 10;
        }

        // loop to place digit
        for (int i = 0; i <= counter; i++)
        {
            // forming formula for our use case
            int temp = ((num / pos) * (pos * 10)) + (digit * pos) + (num % pos);

            // check max
            if (temp * negative > max)
            {
                max = temp * negative;
            }

            pos = pos * 10;
        }

        System.out.println(max);

        return max;
    }
}
