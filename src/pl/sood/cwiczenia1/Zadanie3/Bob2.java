package pl.sood.cwiczenia1.Zadanie3;

public class Bob2 extends Thread {
    private int input;

    @Override
    public void run() {
        while (true) {
            if (interrupted()) {
                if (input == 0) {
                    System.out.println("[Bob] Finishing work");
                    break;
                } else {
                    System.out.println("[Bob] The result is: " + this.input * 2);
                }
            }
        }
    }

    public void setInput(int x) {
        this.input = x;
    }
}
