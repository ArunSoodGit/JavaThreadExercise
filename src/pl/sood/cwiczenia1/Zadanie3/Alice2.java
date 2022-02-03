package pl.sood.cwiczenia1.Zadanie3;

public class Alice2 extends Thread {

    private Bob2 bob2;

    public Alice2(Bob2 bob2) {
        this.bob2 = bob2;

    }

    @Override
    public void run() {

        for (int i = 1; i < 10; i++) {

            System.out.println("Sent to Bob value: " + i);
            bob2.setInput(i);
            bob2.interrupt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

        bob2.setInput(0);
        bob2.interrupt();
    }
}



