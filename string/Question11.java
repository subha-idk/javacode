package string;

import java.util.HashSet;

public class Question11 {
    public static void main(String[] args) {
        String s = "abaacabcbb";
        HashSet<Character> set = new HashSet<>();
        int l=0,len=0;
        for(int r=0; r<s.length(); r++){
            if(set.contains(s.charAt(r))){
                while(l<r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            len = Math.max(len,r-l+1);

        }
        System.out.println(len);
    }
}
