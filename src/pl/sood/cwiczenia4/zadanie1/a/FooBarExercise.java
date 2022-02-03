package pl.sood.cwiczenia4.zadanie1.a;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FooBarExercise {
    public static void main(String[] args) {
        // Drukowanych b�dzie 40 komunikat�w
        final FooBar foobar = new FooBar(40);
        // Pierwszy w�tek -- wywo�uje foo()
        new Thread(() -> {
            try {
                foobar.foo();
            } catch (InterruptedException ex) {
                Logger.getLogger(FooBarExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        // Drugi w�tek -- wywo�uje bar()
        new Thread(() -> {
            try {
                foobar.bar();
            } catch (InterruptedException ex) {
                Logger.getLogger(FooBarExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
}
