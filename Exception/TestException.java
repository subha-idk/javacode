package Exception;

import java.util.Scanner;

public class TestException {
    public static void validateAge(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("Invalid Age");
        }else{
            System.out.println("Age is valid");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age");
        int age = sc.nextInt();

        try{
            validateAge(age);  //   /0 ->
        }catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("end of program");
    }
}
