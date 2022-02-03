package pl.sood.cwiczenia3.zadanie2;

import java.util.concurrent.Semaphore;

public class Pot {
    static final int M = 5; // Pojemnoœæ kot³a
    private Semaphore emptyPot = new Semaphore(1);
    private Semaphore available = new Semaphore(0);
    private int servingsAvailable = 0;
    private int totalServedCount = 0;

    private synchronized void insertServings(int value) {
        servingsAvailable = value;
    }

    private synchronized int removeServing() {
        --servingsAvailable;
        ++totalServedCount;
        return servingsAvailable;
    }

    public int getTotalServedCount() {
        return totalServedCount;
    }

    public void getServing() throws InterruptedException {
// Kod rozwi¹zania...
        available.acquire();
        removeServing();
        if (servingsAvailable == 0) {
            emptyPot.release();
        }
    }

    public void fill() throws InterruptedException {
// Kod rozwi¹zania...
        emptyPot.acquire();
        insertServings(M);
        available.release(M);
    }

}
