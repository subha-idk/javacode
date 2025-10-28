package OOP;

// extends
public class Student extends Person {
  String roll;

  Student() {

  }

  Student(String name, String dept, String phNO, String email, String roll) {
    super(name, dept, phNO, email);
    this.roll = roll;
  }

  public void display() {
    super.display();
    System.out.println("RollNo : "+this.roll);
  }

  // Person(){

  // }

  // Person(String name, String dept, String phNO, String email){
  // this.name = name;
  // this.dept = dept;
  // this.phNO = phNO;
  // this.email= email;
  // }

  // public void display(){
  // System.out.println("Name : "+this.name);
  // System.out.println("dept : "+this.dept);
  // System.out.println("phno : "+this.phNO);
  // System.out.println("email : "+this.email);
  // }

}

/*
 * public class Student extends Person{
 * String roll;
 * String name;
 * String dept;
 * String phNO;
 * String email;
 * }
 * 
 * 
 */
