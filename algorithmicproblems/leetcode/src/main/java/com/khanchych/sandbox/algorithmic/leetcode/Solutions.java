package com.khanchych.sandbox.algorithmic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solutions {
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
}
