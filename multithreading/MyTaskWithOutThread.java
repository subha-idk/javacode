package multithreading;

public class MyTaskWithOutThread {
    String name;
    MyTaskWithOutThread(String name){
        this.name = name;
    }

    public void start() {
        for(int i=0; i<100; i++){
            System.out.println(name+" Thread is running "+ i);
        }
    }
}
