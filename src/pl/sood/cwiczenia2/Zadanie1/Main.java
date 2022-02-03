package pl.sood.cwiczenia2.Zadanie1;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // Single counter
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; ++i) {
            threads[i] = new Thread(new Worker(counter));
        }
        long startTime = System.nanoTime();
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        long endTime = System.nanoTime();
// Now only the main thread prints the final value:
        System.out.println("Counter value is: " + counter.value);
        System.out.println("The expected value is: " + (threads.length * Counter.Iter));
        System.out.printf("The execution took: %.2f ms\n", (endTime - startTime) * 1e-6);
    }

}
