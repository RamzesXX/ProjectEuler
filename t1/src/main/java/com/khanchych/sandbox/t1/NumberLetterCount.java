package com.khanchych.sandbox.t1;

import java.util.Arrays;

public class NumberLetterCount {
    static String[] a = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] b = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] c = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public static void main(String[] args) {
        int first9 = Arrays.stream(a).mapToInt(String::length).sum();
        int first19 = first9 + Arrays.stream(b).mapToInt(String::length).sum();
        int first99 = first19 + 10 * Arrays.stream(c).mapToInt(String::length).sum() + first9 * c.length;
        int first999 = 10 * first99 + 100 * first9 + "hundred".length() * 100 * a.length + "and".length() * a.length * 99;

        int first1000 = first999 + "onethousand".length();
        System.out.println(first1000);
    }
}
