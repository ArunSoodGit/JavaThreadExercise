package pl.sood.cwiczenia5;

import java.util.concurrent.ForkJoinPool;

public class Exercise2 {
    public static void main(String[] args) {
        // Sekwencyjnie
        long n = 110;
        long m = n;
        long start_time = System.nanoTime();
        long ans = countPartitions(n, m);
        long end_time = System.nanoTime();
        System.out.printf("[sequentially] The answer is: %d\nComputation time: %.1f sec.\n", ans, (end_time - start_time) * 1e-9);
        // Równolegle
        ForkJoinPool pool = new ForkJoinPool();
        start_time = System.nanoTime();
        ans = pool.invoke(new Task(n, m));
        end_time = System.nanoTime();
        System.out.printf("[parallel] The answer is: %d\nComputation time: %.1f sec.\n",
                ans, (end_time - start_time) * 1e-9);
    }

    public static long countPartitions(long n, long m) {
        if (n <= 1 || m == 1) return 1;
        long count = 0;
        for (long k = Math.min(n, m); k >= 1; --k) {
            count += countPartitions(n - k, Math.min(k, m));
        }
        return count;
    }
}
