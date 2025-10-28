package OOP;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException {
    System.out.println();
    Circle c1 = new Circle(5);
    c1.findArea();

    Shape c2 = new Circle(3);
    c2.displayInfo();
    c2.draw();
    c2.findArea();

    Shape r1 = new Rectangle(2,3);
    r1.draw();
    r1.findArea();


    

    
  }
}


