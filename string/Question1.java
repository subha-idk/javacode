package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    Take a input String create two function
    to change to toUpperCase and toLowerCase without any built in function
 */
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string: ");
        String str = br.readLine();
        System.out.println(toUpperCase(str));
        System.out.println(toLowerCase(str));
    }
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if('a'<=c && 'z'>=c){
                sb.append((char) (c-32));
            }else
                sb.append(c);
        }
        return sb.toString();
    }
    public static String toLowerCase(String str){
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()){
            if('A'<=c && 'Z'>=c){
                sb.append((char)(c+32));
            }else
                sb.append(c);
        }
        return sb.toString();
    }
}
