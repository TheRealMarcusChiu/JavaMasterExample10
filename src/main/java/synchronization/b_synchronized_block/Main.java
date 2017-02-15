package synchronization.b_synchronized_block;

public class Main {

    public static void main(String args[]) {
        // create only one object to share between MyThread1&2
        Synchronize obj = new Synchronize();

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
