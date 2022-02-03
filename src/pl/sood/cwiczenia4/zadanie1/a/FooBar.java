package pl.sood.cwiczenia4.zadanie1.a;

class FooBar {
    private int n;
    private boolean fooPrints = false;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (fooPrints == true) {
                wait();

            }
            System.out.print("foo");
            fooPrints = true;
            notify();
        }


    }

    public synchronized void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooPrints) {
                wait();
            }
            System.out.println("bar");
            fooPrints = false;
            notify();

        }
    }
}
