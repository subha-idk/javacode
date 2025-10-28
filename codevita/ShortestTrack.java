package codevita;

import java.util.*;

public class ShortestTrack {
    static class Point {
        int r, c, dist;
        Point(int r, int c, int dist) { this.r = r; this.c = c; this.dist = dist; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[N][N];
        int sr = 0, sc1 = 0, dr = 0, dc1 = 0;
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().trim();
            grid[i] = line.toCharArray();
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'S') { sr = i; sc1 = j; }
                if (grid[i][j] == 'D') { dr = i; dc1 = j; }
            }
        }

        System.out.println(bfs(grid, sr, sc1, dr, dc1));
    }

    static int bfs(char[][] grid, int sr, int sc1, int dr, int dc1) {
        int N = grid.length;
        int[] drs = {-1, 1, 0, 0};
        int[] dcs = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr, sc1, 1));
        visited[sr][sc1] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.r == dr && p.c == dc1) return p.dist;
            for (int k = 0; k < 4; k++) {
                int nr = p.r + drs[k], nc = p.c + dcs[k];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] &&
                        (grid[nr][nc] == 'T' || grid[nr][nc] == 'D')) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, p.dist + 1));
                }
            }
        }
        return -1; // no path
    }
}
