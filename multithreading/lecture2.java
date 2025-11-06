package multithreading;

public class lecture2 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();

        myThread.start();
        myThread1.start();
    }
}
