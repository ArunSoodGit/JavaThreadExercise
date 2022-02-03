package pl.sood.cwiczenia2.Zadanie1;

class Worker implements Runnable {
    Counter counter = null;

    public Worker(Counter c) { counter = c; }

    @Override
    public void run() {
        for (int i = 0; i < Counter.Iter; ++i) {
            counter.increment();
        }
    }
}