package com.khanchych.sandbox.algorithmic.leetcode;

import java.util.*;

public class Solutions {

    public int lengthOfLongestSubstringAnswer2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
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
}
