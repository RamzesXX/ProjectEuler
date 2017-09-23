package com.khanchych.sandbox.t1;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

public class ExecutorConsumerAdapter implements Consumer<Runnable> {
    private final Executor executor;

    public ExecutorConsumerAdapter(Executor executor) {
        this.executor = executor;
    }

    public void accept(Runnable task) {
        executor.execute(task);
    }
}
