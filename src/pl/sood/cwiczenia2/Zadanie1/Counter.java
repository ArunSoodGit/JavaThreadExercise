package pl.sood.cwiczenia2.Zadanie1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    static final int Iter = 1_000_000;
    int value = 0;
    final TestAndSetLock lock = new TestAndSetLock();
    final Lock lock2 = new ReentrantLock();

    public void increment() {
        lock.lock(); // Entry protocol
        try { // Critical section:
            ++value;
        } finally {
            lock.unlock(); // Exit protocol
        }
    }
}
