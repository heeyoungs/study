package bakjoon.dynamicprogrmmingalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 격자상의 경로
public class BakJoon10164 {
    static int[][] dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int stoppingAreaX = 0;
    static int stoppingAreaY = 0;
    static int width;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken()) - 1;
        int k1 = 1;
        if (point != -1) {
            stoppingAreaY = point / width;
            stoppingAreaX = point % width;
            dp = new int[width][height];
            k1 = dfs1(0, 0);
        }
        dp = new int[width][height];
        int k2 = dfs2(stoppingAreaX, stoppingAreaY);
        System.out.println(k1*k2);
    }

    static int dfs1(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        if (x == stoppingAreaX && y == stoppingAreaY) {
            return 1;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > stoppingAreaX || ny > stoppingAreaY) continue;
            dp[x][y] += dfs1(nx, ny);
        }
        return dp[x][y];
    }

    static int dfs2(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        if (x == width - 1 && y == height - 1) {
            return 1;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= width || ny >= height) continue;
            dp[x][y] += dfs2(nx, ny);
        }
        return dp[x][y];
    }
}
