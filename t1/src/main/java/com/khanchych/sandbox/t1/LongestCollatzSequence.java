package com.khanchych.sandbox.t1;

import java.util.HashMap;
import java.util.Map;

public class LongestCollatzSequence {
    private Map<Long, Long> map;
    private Long maxSequence;
    private Long valueForMaxSequence;
    private final Long n;

    public LongestCollatzSequence(Long n) {
        this.n = n;
        map = new HashMap<>();
        this.maxSequence = 0L;
    }

    public void calc() {
        for (long i = 1; i <= n; i++) {
            if (map.get(i) != null) {
                continue;
            }

            calcSequenceLength(i);
        }
    }

    private Long calcSequenceLength(Long m) {
        long result;

        if (map.get(m) != null) {
            return map.get(m);
        }

        if (m == 1) {
            result = 1;
        } else {
            result = calcSequenceLength(m % 2 == 0 ? m / 2 : 3 * m + 1) + 1;
        }
        if (maxSequence < result) {
            maxSequence = result;
            valueForMaxSequence = m;
        }
        map.put(m, result);

        return result;
    }

    public Long getValueForMaxSequence() {
        return valueForMaxSequence;
    }

    public Long getSequenceLengthForN(Long n) {
        return map.get(n);
    }

    public static void main(String[] args) {
        Long n = 1000000L;
        Long maxValue;
        LongestCollatzSequence collatzSequence = new LongestCollatzSequence(n);

        collatzSequence.calc();

        maxValue = collatzSequence.getValueForMaxSequence();
        System.out.println("Maximal sequence length is " + collatzSequence.getSequenceLengthForN(maxValue) + " for number " + maxValue);
    }
}
