package pl.sood.cwiczenia4.zadanie1.a;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FooBarExercise {
    public static void main(String[] args) {
        // Drukowanych bêdzie 40 komunikatów
        final FooBar foobar = new FooBar(40);
        // Pierwszy w¹tek -- wywo³uje foo()
        new Thread(() -> {
            try {
                foobar.foo();
            } catch (InterruptedException ex) {
                Logger.getLogger(FooBarExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        // Drugi w¹tek -- wywo³uje bar()
        new Thread(() -> {
            try {
                foobar.bar();
            } catch (InterruptedException ex) {
                Logger.getLogger(FooBarExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
}
