package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    check if a string is a palindrome or not
    without using any built in reverse
 */
public class Question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int i=0,j=str.length()-1;
        boolean palindrome = true;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                palindrome = false;
                break;
            }
            i++;j--;
        }
        System.out.println("String is Palindrome: "+palindrome);
    }
}
