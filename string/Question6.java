package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Print all character of the string without using charAt()
    inbuilt function
 */
public class Question6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(char ch: str.toCharArray()){
            System.out.printf("%c",ch);
        }
    }
}
