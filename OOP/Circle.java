package OOP;

class Circle extends Shape{
    private double r;

    public Circle(double r){
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("Darawing a Circle");
    }

    @Override
    public void findArea() {
        System.out.println("Area of the Circle is : "+3.14*r*r);
    }
}
