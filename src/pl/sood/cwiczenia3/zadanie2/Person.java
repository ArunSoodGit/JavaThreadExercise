package pl.sood.cwiczenia3.zadanie2;

class Person extends Thread { // Reprezentuje tubylca
    Pot pot;
    int servingsConsumed = 0;
    public Person(String name, Pot pot) {
        super(name);
        this.pot = pot;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; ++i) {
                pot.getServing();
                ++servingsConsumed;
                Thread.yield();
            }
        } catch(InterruptedException e) {
            return ;
        }
    }
}
