package pl.sood.cwiczenia3.zadanie1;

import java.util.concurrent.ThreadLocalRandom;

class Car extends Thread {

    private Parking parking;
    private int id;
    private int attempts;

    public Car(Parking parking, int id, int attempts) {
        this.parking = parking;
        this.id = id;
        this.attempts = attempts;
    }

    private void rest() throws InterruptedException {
        Thread.sleep(1000 * (1 + ThreadLocalRandom.current().nextInt(2)));
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < attempts; ++i) {
                rest();
                System.out.printf("[Car %-3d] arrived\n", id);
                parking.enter(id);
                rest();
                parking.leave(id);
                System.out.printf("[Car %-3d] left (parked: %d times)\n", id, i + 1);
            }
        } catch (InterruptedException e) {
        }
    }
}
