package OOP;

// abstract class classname{}
// interface interfacename
interface Payment {
  void pay(double amount);
}

class CreditCardPayment implements Payment {

  @Override
  public void pay(double amount) {
    System.out.println("Paid RS: " + amount + " using creditcard.");
  }

}

public class InterfaceDemo {
  public static void main(String[] args) {
    // Payment p1 = new Payment() {
    //   @Override
    //   public void pay(double amount) {
    //     System.out.println("Paid RS: " + amount + " using creditcard.");
    //   }
    // };

    Payment p1 = new CreditCardPayment();


    // lamda expression (java 8)
    // Payment p1 = (amount)->{
    //     System.out.println("Paid RS: " + amount + " using creditcard.");
    // };


    p1.pay(35000);
  }
}
