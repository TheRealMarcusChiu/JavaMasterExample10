package synchronization.a_synchronized_method.b_with_synchronize;

class Table {

    //method not synchronized
    synchronized void printTable(int n) {
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

class MyThread1 extends Thread {
    private Table t;

    MyThread1(Table t) {
        this.t=t;
    }

    public void run() {
        t.printTable(5);
    }

}
class MyThread2 extends Thread {
    private Table t;

    MyThread2(Table t) {
        this.t=t;
    }

    public void run() {
        t.printTable(100);
    }
}

class TestSynchronization1 {

    public static void main(String args[]) {
        //only one object to share between MyThread1&2
        Table obj = new Table();

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}

