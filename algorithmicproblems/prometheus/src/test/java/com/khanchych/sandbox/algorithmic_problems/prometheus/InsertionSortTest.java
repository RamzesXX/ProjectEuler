package com.khanchych.sandbox.algorithmic_problems.prometheus;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {
    private InsertionSort insertionSort;

    @Before
    public void setUP() {
        insertionSort = new InsertionSort();
    }

    @Test
    public void sortSortedArray() {
        Integer[] v = {1, 2, 5, 6, 8, 9, 12};

        assertArrayEquals(v, insertionSort.sort(v));
    }

    @Test
    public void sort() {
        Integer[] originArray = {12, 2, 5, 8, 6, 9, 1};
        Integer[] sortedArray = {1, 2, 5, 6, 8, 9, 12};

        assertArrayEquals(sortedArray, insertionSort.sort(originArray));
    }

    @Test
    public void sortLongArray() {
        Integer[] originArray = generateIntegerRandomArray(1_000_000);
        Integer[] sortedArray = Arrays.copyOf(originArray, originArray.length);
        Arrays.sort(sortedArray);

        assertArrayEquals(sortedArray, insertionSort.sort(originArray));
    }

    private Integer[] generateIntegerRandomArray(int n) {
        Integer[] randomArray = new Integer[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            randomArray[i] = random.nextInt(n);
        }

        return randomArray;
    }
}