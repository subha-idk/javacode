package multithreading;

public class MyTask implements Runnable {
    String name;
    MyTask() {
    }
    MyTask(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            System.out.println(name+" Thread is running "+ i);
        }
    }
}
