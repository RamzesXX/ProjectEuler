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
        assertEquals(9, solutions.lengthOfLongestSubstring("dwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarjdwjhwowviwejnv0ienvwnviwovnwqvnw0pvnwqpvnqwpvkpdvkfkjglkfdjglksajfarj-1krwqfg"));
        assertEquals(8, solutions.lengthOfLongestSubstring("abcdajlkm"));
    }

    @Test
    public void findMedianSortedArrays() throws Exception {
        assertEquals(2.0, solutions.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0001);
        assertEquals(2.5, solutions.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0001);
    }

    @Test
    public void minimumDeleteSum() throws Exception {
        assertEquals(231, solutions.minimumDeleteSum("sea", "eat"));
        assertEquals(403, solutions.minimumDeleteSum("delete", "leet"));
    }

    @Test
    public void maxProfit() throws Exception {
        assertEquals(0, solutions.maxProfit(new int[]{9, 8, 1, 2, 3}, 2));
    }


    @Test
    public void descent() throws Exception {
        int m = 10, n = 10;
        int[][] field = new int[m][n];

        field[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] += (i > 0 ? field[i - 1][j] : 0) + (j > 0 ? field[i][j - 1] : 0);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d", field[i][j]);
            }
            System.out.println();
        }
    }
}