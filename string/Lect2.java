package string;

public class Lect2 {
    public static void main(String[] args) {
        String name = new String("abc");
//        StringBuilder sb = new StringBuilder("CEMK,");
//        StringBuilder sb1 = sb;
//        sb.append(" Kolaghat");
//        System.out.println("Before Delete: "+sb);
//        sb.deleteCharAt(4);
//        System.out.println("After Delete: "+sb);
//        System.out.println(sb.substring(5,sb.length()));
//        System.out.println(sb1);
        StringBuffer sb = new StringBuffer("CEMK,");
        sb.append(" Kolaghat");
        System.out.println(sb);
    }
}
