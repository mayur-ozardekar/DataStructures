package com.study.ds.string.utils;

public class AddBinary {
    public static void main(String[] args) {

        System.out.println(addBinaries("100", "11"));
        System.out.println(addBinary("100", "11"));
        System.out.println(addBinaryPointer("100", "11"));

    }

    private static String addBinaryPointer(String A, String B){
        int i = A.length() - 1;
        int j = B.length() - 1;

        int carry = 0;
        int sum = 0;

        StringBuilder bit = new StringBuilder();

        while(i >= 0 || j >=0 || carry != 0){

            if(i >= 0){
                sum += (A.charAt(i) - '0');
                i --;
            }

            if(j >= 0){
                sum += (A.charAt(j) - '0');
                j --;
            }

            sum += carry;
            int temp = sum % 2;

            bit.append((char) (temp + '0'));
            carry = sum / 2;
        }

        return bit.reverse().toString();
    }

    private static String addBinary(String A, String B){
        int i = Integer.parseInt(A, 2);
        int j = Integer.parseInt(B, 2);

        int sum = i + j;

        return Integer.toBinaryString(sum);
    }

    private static String addBinaries(String A, String B){
        int a = A.length() - 1;
        int b = B.length() - 1;

        int maxLength = Math.max(a, b);

        StringBuilder sum = new StringBuilder();
        int carry = 0;

        for(int i = 0; i <= maxLength; i ++){
            int p = i <= a ? A.charAt(a - i) - '0' : 0;
            int q = i <= b ? B.charAt(b - i) - '0' : 0;

            int temp = p + q + carry;

            carry = temp / 2;
            sum.insert(0, temp % 2);
        }

        return carry == 0 ? sum.toString() : '1' + sum.toString();
    }
}
