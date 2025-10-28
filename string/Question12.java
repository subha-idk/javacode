package string;

public class Question12 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("CEMK, Kolaghat");
        System.out.println("Before reverse : "+ sb);

        int s=0, e=sb.length()-1;
        while(s<e){
            char temp = sb.charAt(s);
            sb.setCharAt(s,sb.charAt(e));
            sb.setCharAt(e,temp);

            s++;e--;
        }
        System.out.println("After reverse : "+ sb);
    }
}
