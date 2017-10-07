package com.khanchych.sandbox.algorithmic.projecteuler;

public class NumberSpiralDiagonals {
    public long calc(int n) {
        if (n == 1) {
            return 1;
        }

        return 4 * n * n - 6 *( n -1) + calc(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new NumberSpiralDiagonals().calc(1001));
    }
}
