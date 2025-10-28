package string;

import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);
        int count = findFreq(str, ch);
//        String finalStr = makeFinalString(str);
        System.out.println(count);
        sc.close();
    }
    public static int findFreq(String str, char ch){
        int lowerCase=0, upperCase=0, count=0;
        if('A'<=ch && ch<='Z'){
            upperCase=ch;
            lowerCase=ch+32;
        }else if('a'<=ch && ch<='z'){
            lowerCase=ch;
            upperCase=ch-32;
        }
        for(char c: str.toCharArray()){
            if(c==lowerCase || c==upperCase){
                count++;
            }
        }
        return count;
    }
//    public static String makeFinalString(String str){
//
//    }
}

