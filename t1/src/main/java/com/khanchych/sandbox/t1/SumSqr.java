package com.khanchych.sandbox.t1;

public class SumSqr {
    public static long sumSqr(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 5;
        }

        if (n % 2 == 0) {
            return n * n * (n + 3) / 4 + 2 * sumSqr(n / 2 - 1);
        } else {
            return n * (n + 1) * (n + 1) / 4 + 2 * sumSqr((n - 1) / 2);
        }
    }

    public static long sqrSum(int n) {
        return n * n * (1 + n) * (1 + n) / 4;
    }

    public static void main(String[] args) {
        int n = 200;

        System.out.println(sqrSum(n)-sumSqr(n));
    }
}
