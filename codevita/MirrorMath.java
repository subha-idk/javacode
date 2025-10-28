//package codevita;


import java.util.*;

public class MirrorMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();
        String mirror = sc.nextLine();

        Map<Character, Map<Character, Character>> map = new HashMap<>();

        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        char[] mirrors = {'L','R','U','D','S'};

        for(char d : digits) {
            map.put(d, new HashMap<>());
        }

        map.get('0').put('L','0');
        map.get('0').put('R','0');
        map.get('0').put('U','0');
        map.get('0').put('D','0');
        map.get('0').put('S','0');
        map.get('1').put('L','1');
        map.get('1').put('R','1');
        map.get('1').put('D','1');
        map.get('1').put('S','1');
        map.get('2').put('D','5');
        map.get('2').put('S','2');
        map.get('3').put('S','3');
        map.get('4').put('S','4');
        map.get('5').put('D','5');

        map.get('5').put('S','5');
        map.get('6').put('S','6');
        map.get('7').put('S','7');
        map.get('8').put('L','8');
        map.get('8').put('R','8');
        map.get('8').put('U','8');
        map.get('8').put('D','8');
        map.get('8').put('S','8');
        map.get('9').put('S','9');

        int[] count = new int[10];

        for(int i =0; i<number.length(); i++){
            char d = number.charAt(i);
            char m = mirror.charAt(i);

            if(map.get(d).containsKey(m)){
                char mirroredDigit = map.get(d).get(m);
                count[mirroredDigit - '0']++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=9; i++){
            for(int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }

        String result = sb.toString().replaceFirst("^0+(?!$)", "");
        System.out.println(result);
    }
}
