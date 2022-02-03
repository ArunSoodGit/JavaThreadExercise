package pl.sood.cwiczenia1.Zadanie3;

public class Singer extends Thread {
    int n;
    Singer next;

    public Singer(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100-n; i++) {
            if(this.next.next != null){
                this.next = this.next.next;
            }
        }
        print(this.n);
    }

    public void setNext(Singer next) {
        this.next = next;
    }

    public void print(int number) {
        System.out.println(number + " bottles of beer on the wall " + number + " bottles of beer  \n" +
                "Take one down and pass it around, " + (number - 1) + " bottles of beer on the wall");
    }
}
