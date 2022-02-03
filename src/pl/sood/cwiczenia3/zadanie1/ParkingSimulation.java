package pl.sood.cwiczenia3.zadanie1;

public class ParkingSimulation {

    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking(4);
        int parkAttempts = 5;
        Thread[] cars = new Thread[6];
        for (int i = 0; i < cars.length; ++i) {
            cars[i] = new Car(parking, i + 1, parkAttempts);
        }
        System.out.println("Simulation started.");
        for (Thread t : cars) {
            t.start();
        }
        for (Thread t : cars) {
            t.join();
        }
        System.out.println("Simulation finished.");
    }
}