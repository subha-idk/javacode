package OOP;

public class Rectangle extends Shape{
    private float len;
    private float wid;

    public Rectangle(float len, float wid){
        this.len = len;
        this.wid = wid;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public void findArea() {
        System.out.println("Area of the Rectangle is : "+len*wid);
    }
}
