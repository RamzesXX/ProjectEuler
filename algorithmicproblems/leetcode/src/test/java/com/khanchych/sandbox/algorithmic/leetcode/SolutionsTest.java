package com.khanchych.sandbox.algorithmic.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionsTest {
    private Solutions solutions;

    @Before
    public void setUp() {
        solutions = new Solutions();
    }

    @Test
    public void lengthOfLongestSubstring() throws Exception {
        assertEquals(1, solutions.lengthOfLongestSubstring("aaaaaaa"));
        assertEquals(3, solutions.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, solutions.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, solutions.lengthOfLongestSubstring("pwwkew"));
    }

}