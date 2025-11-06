package multithreading;

public class lecture1 {
    public static void main(String[] args){
//        with thread

//        Thread t1 = new Thread(new MyTask("Thread-1"));
//        Thread t2 = new Thread(new MyTask("Thread-2"));
//
//        t1.start();
//        t2.start();



        MyTaskWithOutThread t1 = new MyTaskWithOutThread("Thread-1");
        MyTaskWithOutThread t2 = new MyTaskWithOutThread("Thread-2");

        t1.start();
        t2.start();
    }
}
