package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Write a program to check no or words are present in a string word
    separated by space
 */
public class Question5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(countWords(str));
    }
    public static int countWords(String str) {
        int count = 0;
        for(char ch: str.toCharArray()){
            if(ch == ' ')
                count++;
        }
        return count+1;
    }
}
