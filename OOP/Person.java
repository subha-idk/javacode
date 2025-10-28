package OOP;

public class Person {
  String name;
  String dept;
  String phNO;
  String email;
  Person(){

  }

  Person(String name, String dept, String phNO, String email){
    this.name = name;
    this.dept = dept;
    this.phNO = phNO;
    this.email= email;
  }

  protected void display(){
    System.out.println("Name : "+this.name);
    System.out.println("dept : "+this.dept);
    System.out.println("phno : "+this.phNO);
    System.out.println("email : "+this.email);
  }

}
