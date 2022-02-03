package pl.sood.cwiczenia4.zadanie1.b;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

class FooBar {

    private int n;
    private boolean fooPrints = true;
    Semaphore fooSem = new Semaphore(1);
    Semaphore barSem = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() {

        for (int i = 0; i < n; i++) {
            try {
                fooSem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(FooBar.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print("foo");
            barSem.release();
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            try {
                barSem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(FooBar.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("bar");
            fooSem.release();
        }
    }
}