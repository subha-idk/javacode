package OOP;

public abstract class Shape {
    public abstract void draw();

    public abstract void findArea();  //why i'm not declaring this method as normal method

    public void displayInfo(){
        System.out.println("shape");
    }
}
