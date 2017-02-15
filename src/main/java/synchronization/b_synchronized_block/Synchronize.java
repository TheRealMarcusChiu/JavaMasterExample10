package synchronization.b_synchronized_block;

public class Synchronize {

    void printTable(int n) {

        // Synchronized block is used to lock an object for any shared resource.
        // Scope of synchronized block is smaller than the method.
        // synchronized block
        synchronized(this) {
            for(int i=1;i<=5;i++) {

                System.out.println(n*i);

                try {
                    Thread.sleep(400);
                } catch(Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}

class MyThread1 extends Thread {
    private Synchronize t;

    MyThread1(Synchronize t) {
        this.t=t;
    }

    public void run() {
        t.printTable(5);
    }

}

class MyThread2 extends Thread {
    private Synchronize t;

    MyThread2(Synchronize t) {
        this.t=t;
    }

    public void run() {
        t.printTable(100);
    }
}