package bakjoon.bfs_dfs_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 게임
public class BakJoon1103 {
    static int height, width;
    static char[][] area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] dp;
    static int Ans = -1;
    static boolean[][] visit = new boolean[width][height];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new char[width][height];
        dp = new int[width][height];
        visit = new boolean[width][height];
        for (int h = 0; h < height; h++) {
            String input = br.readLine();
            for (int w = 0; w < width; w++) {
                area[w][h] = input.charAt(w);
            }
        }
        dfs(0, 0);
        if (Ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[0][0]);
        }
    }

    static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height || area[x][y] == 'H') {
            return 0;
        }

        if (visit[x][y]) {
            Ans = Integer.MAX_VALUE;
            return 0;
        }

        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        visit[x][y] = true;
        int jump = area[x][y] - '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * jump;
            int ny = y + dy[i] * jump;
            dp[x][y] = Math.max(dfs(nx, ny) + 1,dp[x][y]);
        }
        visit[x][y] = false;
        return dp[x][y];
    }
}
