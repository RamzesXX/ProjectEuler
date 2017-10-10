package com.khanchych.sandbox.t1;

import java.util.concurrent.atomic.AtomicInteger;

public class CharCounterTask implements Runnable {
    private final String str;
    AtomicInteger counter;

    public CharCounterTask(String str, AtomicInteger counter) {
        this.str = str;
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.addAndGet(str.length());
    }
}
