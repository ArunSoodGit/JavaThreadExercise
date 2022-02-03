package pl.sood.cwiczenia4.zadanie1.b;

public class FooBarExercise2 {
    public static void main(String[] args) {
// Drukowanych bêdzie 40 komunikatów
        final FooBar foobar = new FooBar(40);
// Pierwszy w¹tek -- wywo³uje foo()
        new Thread(foobar::foo).start();
// Drugi w¹tek -- wywo³uje bar()
        new Thread(foobar::bar).start();
    }
}
