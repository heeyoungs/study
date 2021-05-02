package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점프
public class BakJoon1890 {
    static int[][] area;
    static long[][] dp;
    static int N;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        dp = new long[N][N];
        for (int h = 0; h < N; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 0));
    }

    static long dfs(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }
        if (area[x][y] == 0){
            return 0;
        }
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * area[x][y];
            int ny = y + dy[i] * area[x][y];
            if (nx >= N || ny >= N) continue;
            dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
    }
}
