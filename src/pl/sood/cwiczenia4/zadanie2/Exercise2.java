package pl.sood.cwiczenia4.zadanie2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Exercise2 {
    public static void main(String[] args) throws InterruptedException {
// Tworzymy w�tki robocze
        Worker[] workers = new Worker[8];
        BlockingQueue<Task> workQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < workers.length; ++i) {
            workers[i] = new Worker(workQueue);
            workers[i].start();
        }
// A teraz lista zada� do obliczenia
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            int n = i % 42;
            Task t = new Task(n); // Znajd� n-ty wyraz ci�gu Fibonacciego
            tasks.add(t);
        }
// Dodaj zadania do workQueue aby mog�y zosta� przetworzone
        workQueue.addAll(tasks);
        workQueue.put(new Task(-1)); // Sygnalizuje koniec pracy
// Czekaj na zako�czenie pracy w�tk�w
        for (Thread t : workers) {
            t.join();
        }
// Oblicz sum� kontroln� wynik�w
        int controlSum = 0;
        for (Task t : tasks) {
            controlSum ^= t.output;
        }
        System.out.println("XOR of the task results: " + controlSum);
    }

}
