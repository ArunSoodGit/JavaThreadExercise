package pl.sood.cwiczenia2.Zadanie1;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestAndSetLock {

    AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void lock() {
        while (atomicBoolean.getAndSet(true)) {
        }
    }

    public void unlock() {
        atomicBoolean.set(false);
    }


}
