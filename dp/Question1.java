package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
//        How to create a valid parenthesis string of size n.
        List<String> list = new ArrayList<>();
        String str = ")()";
        int n=10;
        solve(0,0,n , "", list);

        System.out.println("No of Possible Solution That is Valid: "+list.size());
        System.out.println(Arrays.toString(list.toArray()));

        int count = 0;
        for(String s: list){
            if(isPresent(s,str)){
                count++;
            }
        }
        System.out.println("Valid Count where substring present is : "+count);
    }
    public static boolean isPresent(String s, String substring){
        StringBuilder window = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(window.length()<substring.length()){
                window.append(s.charAt(i));
            }else{
                window.deleteCharAt(0);
                window.append(s.charAt(i));
            }
            if(window.toString().equals(substring)){
                return true;
            }
        }
        return false;
    }
    public static void solve(int opCount, int closeCount, int n, String curString, List<String> list){
        if(opCount+closeCount==n){  //base condition
            list.add(curString);
        }

        if(opCount<n/2){ //can take opening's bracket
            solve(opCount+1, closeCount, n, curString+"(", list);
        }
        if(opCount>closeCount){
            solve(opCount, closeCount+1, n, curString+")", list);
        }
    }
}
