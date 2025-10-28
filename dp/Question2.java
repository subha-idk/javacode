package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {
    static int[][] dp;
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = ")()";
        int n=8;
        dp = new int[n/2+1][n/2+1];
        for(int[] temp:dp)
            Arrays.fill(temp, -1);

        int noOfWays = solve(0,0,n);
        System.out.println("No of Valid String "+ noOfWays);
    }
    public static int solve(int opCount, int closeCount, int n) {
        if((n&1)==1)
            return 0;
        if(opCount == n/2 && closeCount == n/2) return 1;


        if(dp[opCount][closeCount]!=-1)
            return dp[opCount][closeCount];

        int temp = 0;
        if(opCount<n/2){ //can take opening's bracket
            temp += solve(opCount+1, closeCount, n);
        }
        if(opCount>closeCount){
            temp += solve(opCount, closeCount+1, n);
        }
        return dp[opCount][closeCount]=temp;

    }
}
