package pl.sood.cwiczenia5;

import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Long> {
    final long n, m;

    public Task(long n, long m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public Long compute() {
        // Rozwi¹zanie...

        if (n * m < 300) {
            return Exercise2.countPartitions(n, m);
        } else {
            long count = 0;
            Task[] tasks = new Task[(int) Math.min(n, m)];
            for (long k = Math.min(n, m); k >= 1; --k) {
                tasks[(int) k - 1] = new Task(n - k, Math.min(k, m));
                tasks[(int) k - 1].fork();
            }
            for (long k = Math.min(n, m); k >= 1; --k) {
                count += tasks[(int) k - 1].join();

            }
            return count;
        }
    }
}
