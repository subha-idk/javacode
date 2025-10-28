package wrapperclass;

public class Lect1 {
    public static void main(String[] args) {
        int a = 10;  //normal primitive data type
        System.out.println(a);
        Integer objA = a;
        System.out.println(objA);
        int b = (int) objA;
    }
}
