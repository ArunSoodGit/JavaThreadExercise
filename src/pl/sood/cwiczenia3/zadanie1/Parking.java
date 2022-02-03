package pl.sood.cwiczenia3.zadanie1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Parking {

    private Semaphore gate = null; // u¿ywany w enter() i leave()
    private AtomicInteger waitingCount = new AtomicInteger(0);
    private int[] carsParked = null;

    public Parking(int capacity) {
        this.carsParked = new int[capacity];
        this.gate = new Semaphore(capacity);
    }

    public void enter(int carId) throws InterruptedException {
        waitingCount.incrementAndGet(); // Inkrementowany jest licznik samochodów czekaj¹cych na wjazd
        printInfo(); //wyœwietlany jest komunikat o  stanie parkingu
        gate.acquire(); // Nastêpuje czekanie na wolne miejsce
        waitingCount.decrementAndGet(); // Zmniejszany jest licznik samochodów czekaj¹cych na wjazd
        addCar(carId); //„parkuje” samochdów zapisuj¹c jego identyfikator w tablicy carsParked.
        printInfo(); //wyœwietlany jest komunikat o stanie parkingu
    }

    public void leave(int carId) throws InterruptedException {
        removeCar(carId);
        gate.release();
    }

    private synchronized void addCar(int carId) {
        for (int i = 0; i < carsParked.length; i++) {
            if (carsParked[i] == 0) {
                carsParked[i] = carId;
                break;
            }
        }
    }

    private synchronized void removeCar(int carId) {
        for (int i = 0; i < carsParked.length; i++) {
            if (carsParked[i] == carId) {
                carsParked[i] = 0;
                break;
            }
        }
    }

    public synchronized void printInfo() {
        StringBuffer out = new StringBuffer();
        out.append(String.format("[Parking] # of cars waiting: %d\t Cars parked: ",
                waitingCount.get()));
        for (int carParked : carsParked) {
            if (carParked != 0) {
                out.append(String.format("%d ", carParked));
            }
        }
        out.append("\n");
        System.out.print(out.toString());
    }
}


