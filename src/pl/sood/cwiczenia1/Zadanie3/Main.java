package pl.sood.cwiczenia1.Zadanie3;


public class Main {


    //Zadanie 1
//    public static void main(String[] args) throws InterruptedException {
//        Singer[] threads = new Singer[100];
//        for (int i = 0; i < threads.length; ++i) {
//            threads[i] = new Singer(i + 1);
//
//        }
//        for (Thread t : threads) {
//            t.start();
//            t.join();
//        }
//    }

    //Zadanie 2
//    public static void main(String [] args) throws InterruptedException {
//        Singer [] threads = new Singer[100];
//        for (int i = 0; i < threads.length; ++i) {
//            threads[i] = new Singer(i+1);
//            if (i >= 1) {
//                threads[i-1].setNext(threads[i]);
//            }
//        }
//        for (Thread t : threads) {
//            t.start();
//            t.join();
//        }
//    }


//    Zadanie3

    public static void main(String[] args) {
        Bob2 bob = new Bob2();
        Alice2 alice = new Alice2(bob);
        bob.start();
        alice.start();

    }


}
