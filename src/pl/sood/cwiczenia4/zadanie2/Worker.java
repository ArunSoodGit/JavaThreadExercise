package pl.sood.cwiczenia4.zadanie2;

import java.util.concurrent.BlockingQueue;

class Worker extends Thread {
    private BlockingQueue<Task> queue;

    public Worker(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task element = queue.take();;
                if (element.input >= 0)
                    element.output = Fib.calc(element.input);
                else {
                    queue.put(element);
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("B³¹d przetwarzania");
        }
    }
}

class Task {
    int input;
    int output = 0;

    public Task(int in) {
        input = in;
    }
}

class Fib {
    public static int calc(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return Fib.calc(n - 1) + Fib.calc(n - 2);
    }
}
