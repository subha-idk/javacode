package multithreading;

public class MyThread extends Thread {
    public void run(){


        for(int i=0; i<100; i++){
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName() + " is running" +" Task "+ i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
