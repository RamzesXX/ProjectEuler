package com.khanchych.sandbox.algorithmic.leetcode;

import java.util.*;
import java.util.stream.Stream;

public class Solutions {

    public int lengthOfLongestSubstringAnswer2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> positions = new HashMap<>();
        Character ch;
        int start, i, max;

        max = i = start = 0;

        while (i < s.length()) {
            ch = s.charAt(i);
            if (positions.get(ch) != null) {
                max = Math.max(max, i - start);
                i = start = positions.get(ch) + 1;
                ch = s.charAt(i);
                positions.clear();
            }
            positions.put(ch, i++);
        }

        return Math.max(max, i - start);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int resultLength = nums1.length + nums2.length;
        int index = nums1.length;
        int index1 = nums1.length / 2;
        int index2 = nums2.length / 2;

//        while (index1 + index2 != resultLength /2)


        return 2.0;
    }

    public int minimumDeleteSum(String s1, String s2) {
        Map<Integer, Integer> map = new HashMap<>();

        s1.chars().forEach(ch -> map.compute(ch, (key, value) -> value == null ? ch : ch + value ));
        s2.chars().forEach(ch -> map.compute(ch, (key, value) -> value == null ? -ch : -ch + value ));

        return map.values().stream().mapToInt(Math::abs).sum();
    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}