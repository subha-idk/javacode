package OOP;

public class Car {
  private String color;
  // public default protected private
  // default is only visible to same package
  public void setColor(String color){
    this.color = color;
  }

  public String getColor(){
    return this.color;
  }
}
