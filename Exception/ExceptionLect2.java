package Exception;

import java.util.Scanner;

public class ExceptionLect2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        try{
            int res = a/b;
            System.out.println("res = " + res);
        } catch(ArithmeticException e){
            System.out.println("Division is not possible");
            System.out.println(e.getMessage());
        }
        System.out.println("hello!");

    }
}
