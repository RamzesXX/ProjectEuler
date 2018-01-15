package com.khanchych.sandbox.algorithmic_problems.prometheus;

public class KotsubaMethod {
    public String mul(String first, String second) {
        int n = first.length();
        int n2 = n / 2;

        if (n == 1) {
            return String.valueOf((first.charAt(0) - '0')* (second.charAt(0) - '0'));
        }

        String a = first.substring(0, n2);
        String b = first.substring(n2);
        String c = second.substring(0, n2);
        String d = second.substring(n2);
        String ac = mul(a, c);
        String bd = mul(b, d);
        String result;

        result = ac + makeZeroString(n);
        result = add(result, add(mul(add(a, b), add(c, d)), neg(add(ac, bd))) + makeZeroString(n2));
        result = add(result, bd);

        return result;
    }

    protected String neg(String first) {
        if (first.charAt(0) == '-') {
            return first.substring(1);
        }

        return '-' + first;
    }

    protected String add(String first, String second) {
        boolean isSubstraction = (first.charAt(0) == '-') ^ (second.charAt(0) == '-');
        int overflow;
        StringBuilder firstSB;
        StringBuilder secondSB;
        StringBuilder result = new StringBuilder(first.length() + second.length() + 1);

        if (first.length() < second.length()) {
            firstSB = new StringBuilder(first).reverse();
            secondSB = new StringBuilder(second).reverse();
        } else {
            secondSB = new StringBuilder(first).reverse();
            firstSB = new StringBuilder(second).reverse();
        }

        overflow = 0;
        for (int i = 0; i < firstSB.length(); i++) {
            overflow += firstSB.charAt(i) - '0';
            if (i < secondSB.length()) {
                overflow += secondSB.charAt(i) - '0';
            }
            result.append((char)('0' + overflow % 10));
            overflow /= 10;
        }

        if (overflow > 0) {
            result.append((char)('0' + overflow % 10));
        }

        return result.reverse().toString();
    }

    private String makeZeroString(int n) {
        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            result.append('0');
        }

        return result.toString();
    }
}
