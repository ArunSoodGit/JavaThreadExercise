package pl.sood.cwiczenia2.Zadanie2;

public class Exercise2 {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        for (int i = 0; i < Bank.N; ++i) {
            bank.deposit(i, 100);
        }
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; ++i) {
            threads[i] = new Accountant(bank);
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        int total = 0;
        for (int i = 0; i < Bank.N; ++i) {
            int b = bank.getBalance(i);
            total += b;
            System.out.printf("Account [%d] balance: %d\n", i, b);
        }
        System.out.printf("Total balance is %d\tvalid value is %d\n",
                total, Bank.N * 100);
    }
}
