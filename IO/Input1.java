package IO;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Input1 {
    public static void main(String[] args) {
//        System.out.println("enter Your name : ");
//        Scanner sc = new Scanner(System.in);
//        String name = sc.nextLine();
//        System.out.println("Name is: " + name);
//        sc.close();

//        {1,2,3,4,5}
//        int arr[5];

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("enter 5 numbers");
        for(int i=0;i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

//        output
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }









    }


}
