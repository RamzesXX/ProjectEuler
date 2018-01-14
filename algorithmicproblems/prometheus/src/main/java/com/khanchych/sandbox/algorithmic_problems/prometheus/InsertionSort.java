package com.khanchych.sandbox.algorithmic_problems.prometheus;

import java.util.Arrays;

public class InsertionSort<T extends Comparable> {
    public T[] sort(T[] origin) {
        T[] sortedArray = Arrays.copyOf(origin, origin.length);

        for (int i = 1, k = i; i < sortedArray.length; k = ++i) {
            while (k > 0 && (sortedArray[k].compareTo(sortedArray[k - 1]) < 0)) {
                swap(sortedArray, k, k - 1);
                k--;
            }
        }

        return sortedArray;
    }

    private void swap(T[] array, int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
