package bit;

import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a,b)->{
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if(countA == countB){
                return a-b;
            }
            return countA - countB;
        });
        int[] res = Arrays.stream(boxed).mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(res));
    }
}
