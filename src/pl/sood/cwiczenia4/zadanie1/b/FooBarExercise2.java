package pl.sood.cwiczenia4.zadanie1.b;

public class FooBarExercise2 {
    public static void main(String[] args) {
// Drukowanych b�dzie 40 komunikat�w
        final FooBar foobar = new FooBar(40);
// Pierwszy w�tek -- wywo�uje foo()
        new Thread(foobar::foo).start();
// Drugi w�tek -- wywo�uje bar()
        new Thread(foobar::bar).start();
    }
}
