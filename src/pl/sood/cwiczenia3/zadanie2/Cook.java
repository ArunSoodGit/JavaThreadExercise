package pl.sood.cwiczenia3.zadanie2;

class Cook extends Thread { // Reprezentuje kucharza
    Pot pot;
    public Cook(Pot pot) {
        this.pot = pot;
        setDaemon(true);
    }
    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                pot.fill();
            }
        } catch(InterruptedException e) {
            return ;
        }
    }
}
