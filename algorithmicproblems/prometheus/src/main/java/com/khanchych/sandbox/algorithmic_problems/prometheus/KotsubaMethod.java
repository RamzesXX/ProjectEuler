package com.khanchych.sandbox.algorithmic_problems.prometheus;

import java.math.BigInteger;

public class KotsubaMethod {
    private int count;
    private String AD_BC;

    public KotsubaMethod(String ab_cd){
        this.count = 0;
        this.AD_BC = ab_cd;
    }
    public String mul(String first, String second) {
        int n = Math.max(first.length(), second.length());
        int n2 = n / 2;


        first = makeZeroString(n - first.length()) + first;
        second = makeZeroString(n - second.length()) + second;

        if (n == 1) {
            return String.valueOf((first.charAt(0) - '0') * (second.charAt(0) - '0'));
        }

        String a = first.substring(0, n2);
        String b = first.substring(n2);
        String c = second.substring(0, n2);
        String d = second.substring(n2);
        String ac = mul(a, c);
        String bd = mul(b, d);
        String ab_cd = mul(add(a, b), add(c, d));
        String ad_bc = sub(ab_cd, add(ac, bd));

        String result;

        if (AD_BC.equals(ad_bc)){
            count++;
        }
        result = ac + makeZeroString(2 * (n - n2));
        result = add(result, ad_bc + makeZeroString(n - n2));
        result = add(result, bd);
        return result;
    }

    protected String add(String first, String second) {
        BigInteger firstBI = new BigInteger(first);
        BigInteger secondBI = new BigInteger(second);

        return firstBI.add(secondBI).toString();
    }

    protected String sub(String first, String second) {
        BigInteger firstBI = new BigInteger(first);
        BigInteger secondBI = new BigInteger(second);

        return firstBI.subtract(secondBI).toString();
    }

    private String makeZeroString(int n) {
        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            result.append('0');
        }

        return result.toString();
    }

    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        KotsubaMethod kotsubaMethod = new KotsubaMethod("12");
        String first = "1685287499328328297814655639278583667919355849391453456921116729";
        String second = "7114192848577754587969744626558571536728983167954552999895348492";
        System.out.println(kotsubaMethod.mul(first,second));
        System.out.println(kotsubaMethod.getCount());
    }

}
