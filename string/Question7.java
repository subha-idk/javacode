package string;

/*
    Write a program to remove extra space from the string
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==32)
                continue;
            else if(str.charAt(i-1)==32)
                sb.append(" ");
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
