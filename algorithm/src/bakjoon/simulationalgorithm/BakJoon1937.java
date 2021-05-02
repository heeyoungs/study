package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 욕심쟁이 판다
public class BakJoon1937 {
    static int N;
    static int[][] dp;
    static int[][] area;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxValue = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        dp = new int[N][N];
        for (int h = 0; h < N; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int w = 0; w < N; w++) {
                area[w][h] = Integer.parseInt(st.nextToken());
            }
        }
        // 탐색
        for (int h = 0; h < N; h++) {
            for (int w = 0; w < N; w++) {
                if (dp[w][h] == 0) {
                    dp[w][h] = dfs(w, h);
                }
            }
        }
        // 출력
        System.out.println(maxValue);
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (area[x][y] < area[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny) + 1);
                maxValue = Math.max(maxValue, dp[x][y]);
            }
        }
        return dp[x][y];
    }
}

