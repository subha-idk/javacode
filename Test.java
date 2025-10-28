import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,5,4};
        int[][] queries = {{1,4,2,3},{0,2,1,2}};
        int res = solution.xorAfterQueries(nums, queries);
        System.out.println(res);
    }
}

class Solution {
    int mod = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] q : queries){
            int idx=q[0], r=q[1], k=q[2], v=q[3];
            while(idx<=r){
                nums[idx] =  (nums[idx] * v) % mod;
                idx += k;
            }
        }

        // calculate xor
        int res=0;
        for(int num: nums)
            res ^= num;

        return res;
    }
}