package com.khanchych.sandbox.t1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AdapterClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        final AtomicInteger counter = new AtomicInteger();

        Stream.of("kl", "qwer", "hgfhjhgf").map(s -> new CharCounterTask(s, counter)).forEach(g->executorService.execute(g));

        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(counter);
        executorService.shutdown();



    }
}
