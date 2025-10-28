package string;

public class Question9 {
    public static void main(String[] args) {
//        String str = "hello";
//        str = str+" World!";
//        System.out.println(str);

        StringBuilder sb = new StringBuilder("hello");
        sb.append(" World!");
        sb.setCharAt(0, 'H');
        System.out.println(sb);
    }
}
