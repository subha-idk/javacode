package codevita;


import java.util.HashSet;
import java.util.Scanner;

public class DetectiveChu {
    static int[][] direction = {{-1, 0},{0, 1},{1, 0},{0, -1}}; //URDL
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[R][C];
        for(int i=0; i<R; i++)
            map[i] = sc.nextLine().toCharArray();

        String move = sc.nextLine();

        HashSet<String> set = new HashSet<String>();
//        int count = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == '.'){
                    for(int dir=0; dir<4; dir++){
                        int[] temp = solve(map,i,j,dir,move);
                        if(temp != null){
                            set.add(temp[0]+","+temp[1]);
                        }
                    }
                }
            }
        }
        if(!set.isEmpty()){
            System.out.println(set.size());
        }else
            System.out.println("Impossible");

        sc.close();
    }
    public static int[] solve(char[][] map,int i,int j,int dir,String moves){
        int R = map.length;
        int C = map[0].length;

        for(char move : moves.toCharArray()){
            if(move == 'L'){
                dir = (dir+3) % 4;
            }else if(move == 'R'){
                dir = (dir+1) % 4;
            }else if(move == 'S'){
                i += direction[dir][0];
                j += direction[dir][1];

                if(i <0 || i >= R || j < 0 || j >= C || map[i][j] == '#'){
                    return null;
                }
            }
        }
        return new int[]{i,j};
    }
}
