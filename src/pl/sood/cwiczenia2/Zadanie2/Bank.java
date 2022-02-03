package pl.sood.cwiczenia2.Zadanie2;

import java.util.concurrent.locks.*;

class Bank {
    public static final int N = 10;
    private int[] balances = new int[N];
    private Lock[] locks = new Lock[N];

    public Bank() {
        for (int i = 0; i < locks.length; ++i) {
            locks[i] = new ReentrantLock();
        }
    }

    public void deposit(int accountId, int amount) {
        balances[accountId] += amount;
    }

    public int getBalance(int accountId) {
        return balances[accountId];
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        while (true) {
            if (locks[fromAccount].tryLock()) {
                if (locks[toAccount].tryLock()) {
                    if (balances[fromAccount] >= amount) {
                        balances[fromAccount] = balances[fromAccount] - amount;
                        balances[toAccount] = balances[toAccount] + amount;
                    }
                    locks[fromAccount].unlock();
                    locks[toAccount].unlock();

                    return true;
                }
                locks[fromAccount].unlock();

            }
            return false;
        }
    }
}

