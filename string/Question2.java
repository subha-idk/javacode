package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Input line1: take a string
    Input line2: take a char
    --------------------------
    find the frequency of the character in the string, second the make the string
    special, after a space when word first letter start from upper case. at the end
    add a special char to the end of the string. return the final string
    --------------------------
    output1: frequency of the char
    output2: print the final string
 */
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char ch = (char) br.read();
        System.out.println(findFreq(str,ch));
        System.out.println(makeSpecial(str));
        br.close();
    }
    public static int findFreq(String str, char ch) {
        int count = 0;
        int uppercase=0, lowercase=0;
        if('A'<=ch && ch<='Z'){
            uppercase = ch;
            lowercase = ch+32;
        }else{
            uppercase = ch-32;
            lowercase = ch;
        }
        for(char c: str.toCharArray()){
            if(c==uppercase || c==lowercase){
                count++;
            }
        }
        return count;
    }

    public static String makeSpecial(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==32){   //hello world
                sb.append(ch);  // hello
                sb.append(toUpperCase(str.charAt(++i)));
            }else{
                sb.append(ch);
            }
        }
        sb.append(randomChar()); //Hello World  (specical char)
        return sb.toString();
    }
    public static char toUpperCase(char ch){
        if('A'<=ch && ch<='Z'){
            return ch;
        }
        return (char) (ch-32);
    }
    public static char randomChar(){
        char[] chars = {'!','@','#','$','%','^','&','*','(',')'};
        int index = (int) (Math.random() * (chars.length + 1));
        return chars[index];
    }
}
